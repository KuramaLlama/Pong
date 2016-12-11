package control;

import animation.BallAnimation;
import animation.ComputerAnimation;
import animation.PlayerAnimation;
import gui.GameScreen;
import gui.MessageBoard;
import gui.ScoreBoard;
import pongObject.Ball;
import pongObject.Computer;
import pongObject.Player;


public class GameSetup {

    private GameScreen screen;
    private Ball ball;
    private Player player;
    private Computer computer;
    private PlayerAnimation playerAnimation;
    private BallAnimation ballAnimation;
    private GameControl collision;
    private ScoreBoard scoreBoard;
    private MessageBoard messageBoard;

    private boolean running = false;

    public GameSetup(GameScreen screen) {
        this.screen = screen;
        initObjects();
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public boolean getRunning() {
        return running;
    }

    public void addPaintObjectsToScreen() {
        screen.addPainterObject(ball);
        screen.addPainterObject(player);
        screen.addPainterObject(computer);
        screen.addPainterObject(scoreBoard);
        screen.addPainterObject(messageBoard);
    }

    public void run() {
        setController();
        while(true) {//this should really be in the GameControl class... rather than setup
            screen.render();
            if(running) {
                collision.detectCollision();
                ballAnimation.moveBall();
                playerAnimation.movePlayer();
                runComputer();
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void resetObjPos() {
        ball.setX(screen.getWidth()/2);
        ball.setY(screen.getHeight()/2);

        player.setY((screen.getHeight()/2)-player.getHeight()/2);
        computer.setY((screen.getHeight()/2)-player.getHeight()/2);
    }

    private void initObjects() {
        ball = new Ball(screen.getWidth()/2, screen.getHeight()/2, 10, 10);
        player = new Player(30, screen.getHeight()/2-50, 10, 100);
        computer = new Computer(screen.getWidth()-40, screen.getHeight()/2-50, 10, 100);
        ballAnimation = new BallAnimation(screen, ball);
        scoreBoard = new ScoreBoard(screen);
        collision = new GameControl(player, computer, ball, screen, this, scoreBoard);
        messageBoard = new MessageBoard(screen, "Press Space to Start or Pause!", 450, 50);
    }

    private void setController() {
        playerAnimation = new PlayerAnimation(screen, player);
        PlayerControl controller = new PlayerControl(screen, playerAnimation, this);
        controller.setPlayerController();
    }

    private void runComputer() {
        ComputerAnimation compController = new ComputerAnimation(screen, computer);
        compController.runRightComputer(ball);
    }
}
