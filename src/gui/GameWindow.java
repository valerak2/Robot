package gui;

import gui.menu.Exit;
import logic.GameVisualizer;

import java.awt.BorderLayout;

import javax.swing.*;

public class GameWindow extends JInternalFrame {

    public GameWindow() {
        super("Игровое поле", true, true, true, true);
        GameVisualizer m_visualizer = new GameVisualizer();
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(m_visualizer, BorderLayout.CENTER);
        getContentPane().add(panel);
        pack();
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        Exit.addJInternalListener(this);
    }
}
