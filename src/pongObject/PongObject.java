package pongObject;

import gui.Painter;

import java.awt.Graphics;

public class PongObject implements Painter {

    private int x, y, width, height, xVel = 1, yVel = 1;
    private boolean xIsIncreasing, yIsIncreasing;

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setxVel(int xVel) {
        this.xVel = xVel;
    }

    public void setyVel(int yVel) {
        this.yVel = yVel;
    }

    public void setxIsIncreasing(boolean xIsIncreasing) { this.xIsIncreasing = xIsIncreasing; }

    public void setyIsIncreasing(boolean yIsIncreasing) { this.yIsIncreasing = yIsIncreasing; }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getxVel() { return xVel; }

    public int getyVel() { return yVel; }

    public boolean getXIsIncreasing() { return xIsIncreasing; }

    public boolean getYIsIncreasing() { return yIsIncreasing; }

    public void paint(Graphics g) {}
}
