package gui;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class MainMenu extends JPanel {

    private GridBagLayoutManager grid = new GridBagLayoutManager(this);

    MainMenuBackground menuBackground;
    private JLabel header;
    private JButton playSingle, playOnline;

    public MainMenu(int width, int height) {
        setPreferredSize(new Dimension(width, height));
    }

    public void build() {
        menuBackground = new MainMenuBackground(this);
        setLayout(new GridBagLayout());
        buildHeader();
        buildPlaySingle();
        buildPlayOnline();
    }

    public void paintComponent(Graphics g) {
        menuBackground.paintBackground(g);
    }

    public void addActionListenerSingle(ActionListener listener) {
        playSingle.addActionListener(listener);
    }

    public void addActionListenerOnline(ActionListener listener) {
        playOnline.addActionListener(listener);
    }

    private void buildHeader() {
        header = new JLabel("P O N G");
        header.setForeground(Color.WHITE);
        header.setFont(new Font("Arial", Font.BOLD, 50));
        grid.add(header, 0, 0);
    }

    private void buildPlaySingle() {
        playSingle = new JButton("   Single   ");
        setPongDefaultButton(playSingle);
        grid.add(playSingle, 0, 1);
    }

    private void buildPlayOnline() {
        playOnline = new JButton("   Online   ");
        setPongDefaultButton(playOnline);
        grid.add(playOnline, 0, 2);
    }

    private void setPongDefaultButton(JButton button) {
        button.setFont(new Font("Arial", Font.BOLD, 30));
        button.setBackground(Color.BLACK);
        button.setForeground(Color.WHITE);
        button.setBorder(new LineBorder(Color.WHITE, 3));
    }
}