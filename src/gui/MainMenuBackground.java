package gui;

import animation.BallAnimation;
import animation.ComputerAnimation;
import pongObject.Ball;
import pongObject.Computer;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;

public class MainMenuBackground {

    private JPanel screen;
    private Ball ball;
    private BallAnimation ballAnimation;
    private Computer computer1;
    private Computer computer2;
    private ComputerAnimation comp1Animation;
    private ComputerAnimation comp2Animation;

    public MainMenuBackground(JPanel screen) {
        this.screen = screen;
        initObjects();
    }

    public void paintBackground(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, screen.getWidth(), screen.getHeight());
        paintPongObjects(g);
        runAnimations();
        checkCollision();
    }

    private void initObjects() {
        ball = new Ball(screen.getWidth()/2, screen.getHeight()/2, 10, 10);
        ball.setxVel(2);
        ballAnimation = new BallAnimation(ball, screen.getWidth(), screen.getHeight());
        computer1 = new Computer(30, screen.getHeight()/2-50, 10, 100);
        computer2 = new Computer(screen.getWidth()-40, screen.getHeight()/2-50, 10, 100);
        comp1Animation = new ComputerAnimation(screen.getWidth(), computer1);
        comp2Animation = new ComputerAnimation(screen.getWidth(), computer2);

    }

    private void paintPongObjects(Graphics g) {
        g.setColor(Color.WHITE);
        ball.paint(g);
        computer1.paint(g);
        computer2.paint(g);
    }

    private void runAnimations() {
        ballAnimation.moveBall();
        comp1Animation.runLeftComputer(ball);
        comp2Animation.runRightComputer(ball);
    }

    private void checkCollision() {
        if(computer1YCollision() || computer2YCollision()) {
            ball.setxIsIncreasing(!ball.getXIsIncreasing());
        }
    }

    private boolean computer1YCollision() {
        return(computer1.getX() <= ball.getX()+ball.getWidth() && computer1.getX()+computer1.getWidth() >= ball.getX()
                && computer1.getY() <= ball.getY() && (computer1.getY()+computer1.getHeight()) >= ball.getY()+ball.getHeight());
    }

    private boolean computer2YCollision() {
        return(computer2.getX() <= (ball.getX()+ball.getWidth()) && computer2.getX()+computer2.getWidth() >= ball.getX()
                && computer2.getY() <= (ball.getY()+ball.getHeight()) && (computer2.getY()+computer2.getHeight()) >= ball.getY());
    }
}
