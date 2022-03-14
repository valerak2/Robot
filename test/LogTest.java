import gui.LogWindow;
import log.LogLevel;
import log.LogWindowSource;
import log.Logger;
import org.junit.jupiter.api.Test;

import javax.swing.*;


import static org.junit.jupiter.api.Assertions.*;

public class LogTest {
    @Test
    void contains() {
        LogWindow logWindow = new LogWindow(Logger.getDefaultLogSource());
        for (int i = 0; i < Logger.getDefaultLogSource().getM_iQueueLength(); i++) {
            Logger.info("A");
        }
        for (int i = 0; i < Logger.getDefaultLogSource().getM_iQueueLength(); i++) {
            Logger.warning("Б");
        }
        String logContent = logWindow.getM_logSource().toString();
        assertFalse(logContent.contains("Протокол работает"));
        assertFalse(logContent.contains("А"));
        assertFalse(logContent.contains("[Info]"));
        assertTrue(logContent.contains("Б"));

    }

    @Test
    void size() {
        LogWindowSource log = new LogWindowSource(10);
        for (int i = 1; i < log.getM_iQueueLength() + 10; i++) {
            log.append(LogLevel.Info, "A");
        }
        assertEquals(10, log.size());

    }

    @Test
    void error() {
        LogWindow logWindow = new LogWindow(Logger.getDefaultLogSource());
        try {
            UIManager.setLookAndFeel("null");
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException e) {
            Logger.error(e.toString());
        }
        String logContent = logWindow.getM_logSource().toString();
        System.out.println(logContent);
        assertTrue(logContent.contains("[Error]"));

    }
}
