package gui.windows;

import gui.menu.CloseDialogPanel;
import logic.GameVisualizer;

import java.awt.*;

import javax.swing.*;

public class GameWindow extends JInternalFrame {
    GameVisualizer m_visualizer;

    public GameVisualizer getM_visualizer() {
        return m_visualizer;
    }

    public GameWindow() {
        super("Игровое поле", true, true, true, true);
        m_visualizer = new GameVisualizer();
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(m_visualizer, BorderLayout.CENTER);
        getContentPane().add(panel);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        CloseDialogPanel.addJInternalListener(this);
    }
}