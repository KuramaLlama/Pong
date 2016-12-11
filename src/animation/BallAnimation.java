package animation;

import gui.GameScreen;
import pongObject.Ball;

public class BallAnimation {

    private Ball ball;
    private int screenWidth, screenHeight;

    public BallAnimation(GameScreen screen, Ball ball) {
        this.ball = ball;
        screenWidth = screen.getWidth();
        screenHeight = screen.getHeight();
        randomDirection();
    }

    public BallAnimation(Ball ball, int screenWidth, int screenHeight) {
        this.ball = ball;
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
        randomDirection();
    }

    public void moveBall() {
        checkScreenBorder();
        if(ball.getYIsIncreasing())
            ball.setY(ball.getY()+ball.getyVel());
        else
            ball.setY(ball.getY()-ball.getyVel());

        if(ball.getXIsIncreasing())
            ball.setX(ball.getX()+ball.getxVel());
        else
            ball.setX(ball.getX()-ball.getxVel());
    }

    private void checkScreenBorder() {
        if(ball.getX() <= 0) {
            ball.setxIsIncreasing(true);
        } else if((ball.getX() + ball.getWidth()) >= screenWidth) {
            ball.setxIsIncreasing(false);
        } else if(ball.getY() <= 0) {
            ball.setyIsIncreasing(true);
        } else if((ball.getY() + ball.getHeight()) >= screenHeight) {
            ball.setyIsIncreasing(false);
        }
    }

    private void randomDirection() {
        switch((int)(Math.random() * 4)) {
            case 0 :
                ball.setyIsIncreasing(false);
                ball.setxIsIncreasing(false);
                break;
            case 1:
                ball.setyIsIncreasing(false);
                ball.setxIsIncreasing(true);
                break;
            case 2:
                ball.setyIsIncreasing(true);
                ball.setxIsIncreasing(true);
                break;
            case 3:
                ball.setyIsIncreasing(true);
                ball.setxIsIncreasing(false);
                break;
        }
    }
}
