package gui;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.*;

public class ConnectScreen extends JPanel {

    private GridBagLayoutManager grid = new GridBagLayoutManager(this);
    private JLabel connectLabel, ipLabel;
    private JTextField ipField;

    public ConnectScreen(int width, int height){
        setPreferredSize(new Dimension(width, height));
    }

    public void build() {
        buildConnectLabel();
        buildIpLabel();
        buildIpAddressField();

    }

    private void buildConnectLabel() {
        setLayout(new GridBagLayout());
        connectLabel = new JLabel("C O N N E CT");
        defaultPongComponent(connectLabel);
        grid.add(connectLabel, 0, 0, 1, 1);
    }

    private void buildIpLabel() {
        ipLabel = new JLabel("IP Address: ");
        defaultPongComponent(ipLabel);
        grid.add(ipLabel, 0, 1, 1, 1);
    }

    private void buildIpAddressField() {
        ipField = new JTextField();
        defaultPongComponent(ipField);
        grid.add(ipField, 1, 1);
    }

    public void paintComponent(Graphics g) {
        paintBackground(g);
    }

    private void defaultPongComponent(Component comp) {
        comp.setForeground(Color.WHITE);
        comp.setBackground(Color.BLACK);
        comp.setFont(new Font("Arial", Font.BOLD, 40));
    }

    private void paintBackground(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, getWidth(), getHeight());
    }
}
