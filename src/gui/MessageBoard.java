package gui;

import java.awt.*;

public class MessageBoard implements Painter {

    private Color messageColor = Color.WHITE;

    private int width, height;
    private String message;
    private GameScreen screen;
    private int x, y;

    public MessageBoard(GameScreen screen, String message, int width, int height) {
        this.screen = screen;
        this.message = message;
        this.width = width;
        this.height = height;

        this.x = screen.getWidth()/2;
        this.y = screen.getHeight()/2;
    }

    public MessageBoard(GameScreen screen, String message, int x, int y, int width, int height) {
        this.screen = screen;
        this.message = message;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void setMessageColor(Color color) {
        this.messageColor = color;
    }

    public void paint(Graphics g) {
        drawBoard(g);
        drawBorder(g);
        drawMessage(g);
    }

    private void drawBoard(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(x-(width/2), y-(height/2), width, height);
    }

    private void drawBorder(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(messageColor);
        g2.setStroke(new BasicStroke(5));
        g2.drawRect(x-(width/2), y-(height/2), width, height);
    }

    private void drawMessage(Graphics g) {
        g.setFont(new Font("Arial", Font.BOLD, 30));
        g.setColor(messageColor);
        FontMetrics metrics = g.getFontMetrics();
        g.drawString(message, x-(metrics.stringWidth(message)/2)/*-(width/2)*/, y+(metrics.getHeight()/2)/*-(height/2)*/);
    }
}
