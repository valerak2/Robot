
import gui.windows.LogWindow;
import log.LogLevel;
import log.LogWindowSource;

import log.Logger;
import org.junit.Test;

import javax.swing.*;


import static org.junit.jupiter.api.Assertions.*;

public class LogTest {
   @Test
    public void contains() {
       Logger logger = Logger.getInstance();
        LogWindow logWindow = new LogWindow();
        for (int i = 0; i < logger.getLogSource().getM_iQueueLength(); i++) {
            logger.info("A");
        }
        for (int i = 0; i < logger.getLogSource().getM_iQueueLength(); i++) {
            logger.warning("Б");
        }
        String logContent = logWindow.getLogWindowContent().toString();
        assertFalse(logContent.contains("Протокол работает"));
        assertFalse(logContent.contains("А"));
        assertFalse(logContent.contains("[Info]"));
        assertTrue(logContent.contains("Б"));

    }

    @Test
    public void size() {
        LogWindowSource log = new LogWindowSource(10);
        for (int i = 1; i < log.getM_iQueueLength() + 10; i++) {
            log.append(LogLevel.Info, "A");
        }
        assertEquals(10, log.size());

    }

    @Test
    public void error() {
        LogWindow logWindow = new LogWindow();
        Logger logger = Logger.getInstance();
        try {
            UIManager.setLookAndFeel("null");
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException e) {
            logger.error(e.toString());
        }
        String logContent = logWindow.getLogWindowContent().toString();
        System.out.println(logContent);
        assertTrue(logContent.contains("[Error]"));

    }
}

