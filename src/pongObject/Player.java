package pongObject;

import java.awt.Color;
import java.awt.Graphics;

public class Player extends PongObject {

    public Player(int x, int y, int width, int height) {
        setX(x);
        setY(y);
        setWidth(width);
        setHeight(height);
        setyVel(3);
    }

    public void paint(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(getX(), getY(), getWidth(), getHeight());
    }
}
