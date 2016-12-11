package gui;

import javax.swing.JFrame;
import java.awt.Component;

public class Window extends JFrame {

    public void build(String text) {
        setTitle(text);
        setDefaultCloseOperation(3);
        setResizable(true);
        pack();
        setLocationRelativeTo(null);
    }

    public void swap(Component from, Component to) {
        remove(from);
        add(to);
        repaint();
        revalidate();
    }
}

