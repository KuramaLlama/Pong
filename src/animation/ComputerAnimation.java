package animation;

import gui.GameScreen;
import pongObject.Ball;
import pongObject.Computer;

public class ComputerAnimation {

    private int screenWidth;
    private Computer computer;
    private Ball ball;

    public ComputerAnimation(GameScreen screen, Computer computer) {
        this.screenWidth = screen.getWidth();
        this.computer = computer;
    }

    public ComputerAnimation(int screenWidth, Computer computer) {
        this.screenWidth = screenWidth;
        this.computer = computer;
    }

    public void runLeftComputer(Ball ball) {
        int computerMidPointPosition = computer.getHeight()/2 + computer.getY();
        int ballMidPointPosition = ball.getHeight()/2 + ball.getY();
        if(ball.getX() < screenWidth/2 && !ball.getXIsIncreasing()) {
            if (ballMidPointPosition > computerMidPointPosition) {
                computer.setY(computer.getY() + computer.getyVel());
            } else if (ballMidPointPosition < computerMidPointPosition) {
                computer.setY(computer.getY() - computer.getyVel());
            }
        }
    }

    public void runRightComputer(Ball ball) {
        int computerMidPointPosition = computer.getHeight()/2 + computer.getY();
        int ballMidPointPosition = ball.getHeight()/2 + ball.getY();
        if(ball.getX() > screenWidth/2 && ball.getXIsIncreasing()) {
            if (ballMidPointPosition > computerMidPointPosition) {
                computer.setY(computer.getY() + computer.getyVel());
            } else if (ballMidPointPosition < computerMidPointPosition) {
                computer.setY(computer.getY() - computer.getyVel());
            }
        }
    }
}
