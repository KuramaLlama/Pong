package control;

import gui.GameScreen;
import gui.MessageBoard;
import gui.ScoreBoard;
import pongObject.Ball;
import pongObject.Computer;
import pongObject.Player;

import java.awt.Color;

public class GameControl {

    private Player player;
    private Computer computer;
    private Ball ball;
    private GameScreen screen;
    private GameSetup setup;
    private ScoreBoard scoreBoard;

    public GameControl(Player player, Computer computer, Ball ball, GameScreen screen, GameSetup setup, ScoreBoard scoreBoard) {
        this.player = player;
        this.computer = computer;
        this.ball = ball;
        this.screen = screen;
        this.setup = setup;
        this.scoreBoard = scoreBoard;
    }

    public void detectCollision() {
        if(playerYCollision() || computerYCollision()) {
//            if(ball.getY() < player.getY()+player.getHeight()/2 )
//                ball.setyIsIncreasing(false);
//            else
//                ball.setyIsIncreasing(true);
            ball.setxIsIncreasing(!ball.getXIsIncreasing());
        }
        scoreOnCollision();
    }

    private void scoreOnCollision() {
        if(ball.getX() <= 0) {
            scoreBoard.setPlayer2Score(scoreBoard.getPlayer2Score()+1);
            screen.addPainterObject(new MessageBoard(screen, "Computer Scored!", 300, 50));
            checkWin();
            resetGame();
        } else if(ball.getX()+ball.getWidth() >= screen.getWidth()) {
            scoreBoard.setPlayer1Score(scoreBoard.getPlayer1Score()+1);
            screen.addPainterObject(new MessageBoard(screen, "You Scored!", 200, 50));
            checkWin();
            resetGame();
        }
    }

    private void resetGame() {
        setup.resetObjPos();
        setup.setRunning(false);
    }

    private void checkWin() {
        if(scoreBoard.getPlayer1Score() == 10) {
            screen.removeMessageBoards();
            winner("WINNER", screen.getWidth()/4, screen.getHeight()/2);
            loser("LOSER", (screen.getWidth()/4) * 3, screen.getHeight()/2);
        } else if(scoreBoard.getPlayer2Score() == 10) {
            screen.removeMessageBoards();
            winner("WINNER", (screen.getWidth()/4) * 3, screen.getHeight()/2);
            loser("LOSER", screen.getWidth()/4, screen.getHeight()/2);
        }
    }

    private void winner(String message, int x, int y) {
        MessageBoard winnerMsg = new MessageBoard(screen, message, x, y, 150, 50);
        winnerMsg.setMessageColor(Color.GREEN);
        screen.addPainterObject(winnerMsg);
        scoreBoard.resetScores();
    }

    private void loser(String message, int x, int y) {
        MessageBoard loserMsg = new MessageBoard(screen, message, x, y, 150, 50);
        loserMsg.setMessageColor(Color.RED);
        screen.addPainterObject(loserMsg);
        scoreBoard.resetScores();
    }

    private boolean playerYCollision() {
        return(player.getX() <= ball.getX()+ball.getWidth() && player.getX()+player.getWidth() >= ball.getX()
                && player.getY() <= ball.getY() && (player.getY()+player.getHeight()) >= ball.getY()+ball.getHeight());
    }

    private boolean computerYCollision() {
        return(computer.getX() <= (ball.getX()+ball.getWidth()) && computer.getX()+computer.getWidth() >= ball.getX()
                && computer.getY() <= (ball.getY()+ball.getHeight()) && (computer.getY()+computer.getHeight()) >= ball.getY());
    }
}
