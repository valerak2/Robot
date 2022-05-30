package log;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * Что починить:
 * 1. Этот класс порождает утечку ресурсов (связанные слушатели оказываются
 * удерживаемыми в памяти)
 */
public class LogWindowSource {
    /**
     * Максимальное количество сообщений в логе
     */
    private final int m_iQueueLength;
    /**
     * Максимальное количество сообщений в логе
     */
    private ArrayBlockingQueue<LogEntry> m_messages;
    /**
     * Все слушатели объекта
     */
    private final ArrayList<ILogChangeListener> m_listeners;
    /**
     * Активные слушатели объекта
     */
    private volatile ILogChangeListener[] m_activeListeners;

    public LogWindowSource(int iQueueLength) {
        m_iQueueLength = iQueueLength;
        m_messages = new ArrayBlockingQueue<>(iQueueLength);
        m_listeners = new ArrayList<>();
    }

    public void registerListener(ILogChangeListener listener) {
        synchronized (m_listeners) {
            m_listeners.add(listener);
            m_activeListeners = null;
        }
    }

    /**
     * Может пригодиться в будущем
     */
    public void unregisterListener(ILogChangeListener listener) {
        synchronized (m_listeners) {
            m_listeners.remove(listener);
            m_activeListeners = null;
        }
    }

    public void append(LogLevel logLevel, String strMessage) {
        LogEntry entry = new LogEntry(logLevel, strMessage);
        boolean appendInTail = m_messages.offer(entry);
        while (!appendInTail) {
            m_messages.poll();
            appendInTail = m_messages.offer(entry);
        }
        ILogChangeListener[] activeListeners = m_activeListeners;
        if (activeListeners == null) {
            synchronized (m_listeners) {
                if (m_activeListeners == null) {
                    activeListeners = m_listeners.toArray(new ILogChangeListener[0]);
                    m_activeListeners = activeListeners;
                }
            }
        }
        assert activeListeners != null;
        for (ILogChangeListener listener : activeListeners) {
            listener.onLogChanged();
        }
    }

    /**
     * Вставляет указанный элемент в хвост этой очереди,
     * если это возможно сделать немедленно,
     * не превышая емкость очереди, возвращая значение true в случае успеха
     * и вызывая исключение IllegalStateException ,
     * если эта очередь заполнена.
     */
    private void add(LogLevel logLevel, String strMessage) {
        LogEntry entry = new LogEntry(logLevel, strMessage);
        m_messages.add(entry);
    }

    /**
     * Вставляет указанный элемент в хвост этой очереди,
     * если это возможно сделать немедленно, не превышая емкость очереди,
     * возвращая true в случае успеха и false , если эта очередь заполнена.
     * Этот метод, как правило, предпочтительнее, чем метод add(E),
     * который может не вставить элемент только из-за исключения.
     */
    private void offer(LogLevel logLevel, String strMessage) {
        LogEntry entry = new LogEntry(logLevel, strMessage);
        m_messages.offer(entry);
    }

    /**
     * Вставляет указанный элемент в хвост этой очереди,
     * ожидая освобождения места, если очередь заполнена.
     */
    private void put(LogLevel logLevel, String strMessage) throws InterruptedException {
        LogEntry entry = new LogEntry(logLevel, strMessage);
        m_messages.put(entry);
    }

    /**
     * Вставляет указанный элемент в хвост этой очереди, ожидая до указанного времени ожидания,
     * пока пространство не станет доступным, если очередь заполнена.
     */
    private void offerTimeout(LogLevel logLevel, String strMessage) throws InterruptedException {
        LogEntry entry = new LogEntry(logLevel, strMessage);
        m_messages.offer(entry, 50, TimeUnit.SECONDS);
    }

    public int size() {
        return m_messages.size();
    }

    public Iterable<LogEntry> all() {
        Iterator<LogEntry> iterator = m_messages.iterator();
        ArrayList<LogEntry> res = new ArrayList<>();
        iterator.forEachRemaining(res::add);
        return res;
    }

    public int getM_iQueueLength() {
        return m_iQueueLength;
    }
}