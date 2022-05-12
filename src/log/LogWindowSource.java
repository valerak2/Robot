package log;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Vector;

/**
 * Что починить:
 * 1. Этот класс порождает утечку ресурсов (связанные слушатели оказываются
 * удерживаемыми в памяти)
 * 2. Этот класс хранит активные сообщения лога, но в такой реализации он
 * их лишь накапливает. Надо же, чтобы количество сообщений в логе было ограничено
 * величиной m_iQueueLength (т.е. реально нужна очередь сообщений
 * ограниченного размера)
 *
 *
 * Структура для хранения протокола должна обладать следующими свойствами:
 * - иметь ограниченный размер;
 * - должна быть потокобезопасной;
 * - добавление данных (с потенциальным удалением старых) и чтение уже хранящихся должны быть быстрыми (т.е. никаких O(n));
 */
public class LogWindowSource {

    private final int m_iQueueLength;

    private volatile  ArrayDeque<LogEntry> m_messages;
    private final ArrayList<LogChangeListener> m_listeners;
    private volatile LogChangeListener[] m_activeListeners;

    public LogWindowSource(int iQueueLength) {
        m_iQueueLength = iQueueLength;
        m_messages = new ArrayDeque<>();
        m_listeners = new ArrayList<>();
    }

    public ArrayDeque<LogEntry> getM_messages() {
        return m_messages;
    }

    public void registerListener(LogChangeListener listener) {
        synchronized (m_listeners) {
            m_listeners.add(listener);
            m_activeListeners = null;
        }
    }

    public void unregisterListener(LogChangeListener listener) {
        synchronized (m_listeners) {
            m_listeners.remove(listener);
            m_activeListeners = null;
        }
    }

    public void append(LogLevel logLevel, String strMessage) {
        LogEntry entry = new LogEntry(logLevel, strMessage);

        if (m_messages.size() >= m_iQueueLength) {
            m_messages.removeFirst();
        }
        m_messages.addLast(entry);
        LogChangeListener[] activeListeners = m_activeListeners;


        if (activeListeners == null) {
            synchronized (m_listeners) {
                if (m_activeListeners == null) {
                    activeListeners = m_listeners.toArray(new LogChangeListener[0]);
                    m_activeListeners = activeListeners;
                }
            }
        }
        assert activeListeners != null;
        for (LogChangeListener listener : activeListeners) {
            listener.onLogChanged();
        }
    }

    public int size() {
        return m_messages.size();
    }

    /*    public Iterable<LogEntry> range(int startFrom, int count) {
            if (startFrom < 0 || startFrom >= m_messages.size()) {
                return Collections.emptyList();
            }
            int indexTo = Math.min(startFrom + count, m_messages.size());
            return m_messages.subList(startFrom, indexTo);
        }*/

    public Iterable<LogEntry> all() {
        return m_messages;
    }

    public int getM_iQueueLength() {
        return m_iQueueLength;
    }
}
