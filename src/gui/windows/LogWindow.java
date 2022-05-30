package gui.windows;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.TextArea;
import java.util.ResourceBundle;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;

import gui.localization.Language;
import gui.menu.options.CloseDialogPanel;
import log.ILogChangeListener;
import log.LogEntry;
import log.Logger;

public class LogWindow extends JInternalFrame implements ILogChangeListener {
    private final Logger logger = Logger.getInstance();
    private final TextArea logWindowContent;

    public LogWindow() {
        super(ResourceBundle.getBundle("lang", Language.language).getString("LogWindow.name"), true, true, true, true);


        logger.getLogSource().registerListener(this);
        logWindowContent = new TextArea("");
        logWindowContent.setEditable(false);

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(logWindowContent, BorderLayout.CENTER);
        getContentPane().add(panel);
        updateLogContent();
        CloseDialogPanel.addJInternalListener(this);
    }

    /**
     * Метод
     */
    private void updateLogContent() {
        StringBuilder content = new StringBuilder();
        for (LogEntry entry : logger.getLogSource().all()) {
            content.append(String.format("[%s] %s \n", entry.m_logLevel(), entry.m_strMessage()));
        }
        logWindowContent.setText(content.toString());
        logWindowContent.invalidate();
    }


    @Override
    public void onLogChanged() {
        EventQueue.invokeLater(this::updateLogContent);
    }

    public TextArea getLogWindowContent() {
        return logWindowContent;
    }
}
