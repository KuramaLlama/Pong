package gui;

import javax.swing.JPanel;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class GridBagLayoutManager extends GridBagConstraints{

    private JPanel screen;

    public GridBagLayoutManager(JPanel screen) {
        this.screen = screen;
    }

    public void add(Component comp, int x, int y, int width, int height) {
        gridx = x;
        gridy = y;
        gridwidth = width;
        gridheight = height;
        anchor = GridBagConstraints.CENTER;
        insets = new Insets(4, 4, 4, 4);

        screen.add(comp, this);
    }

    public void add(Component comp, int x, int y) {
        gridx = x;
        gridy = y;
        anchor = GridBagConstraints.CENTER;
        insets = new Insets(4, 4, 4, 4);

        screen.add(comp, this);
    }
}
