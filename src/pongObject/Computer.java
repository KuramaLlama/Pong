package pongObject;

import java.awt.Color;
import java.awt.Graphics;

public class Computer extends PongObject {

    public Computer(int x, int y, int width, int height) {
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
