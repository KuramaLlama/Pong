package pongObject;

import java.awt.Color;
import java.awt.Graphics;

public class Ball extends PongObject {

    public Ball(int x, int y, int width, int height) {
        setX(x);
        setY(y);
        setWidth(width);
        setHeight(height);
        setxVel(3);
    }

    public void paint(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillOval(getX(), getY(), getWidth(), getHeight());
    }
}
