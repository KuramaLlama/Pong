package control;

import animation.PlayerAnimation;
import gui.GameScreen;
import gui.MessageBoard;
import pongObject.Player;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class PlayerControl {

    private GameScreen screen;
    private PlayerAnimation playerAnimation;
    private GameSetup gameSetup;

    public PlayerControl(GameScreen screen, PlayerAnimation playerAnimation, GameSetup gameSetup) {//move this up higher in the hierarchy,
        //accept the screen here and create the player object here than setup
        this.screen = screen;
        this.playerAnimation = playerAnimation;
        this.gameSetup = gameSetup;
    }

    public void setPlayerController() {
        screen.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if(gameSetup.getRunning()) {
                    if (e.getKeyCode() == KeyEvent.VK_UP)
                        playerAnimation.setUp(true);
                    else if (e.getKeyCode() == KeyEvent.VK_DOWN)
                        playerAnimation.setDown(true);

                }

                if(e.getKeyCode() == KeyEvent.VK_SPACE) {
                    gameSetup.setRunning(!gameSetup.getRunning());
                    screen.removeMessageBoards();

                    if(gameSetup.getRunning() == false) {
                        screen.addPainterObject(new MessageBoard(screen, "Paused", 150, 50));
                    }
                }
            }

            public void keyReleased(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_UP) {
                    playerAnimation.setUp(false);
                }

                if(e.getKeyCode() == KeyEvent.VK_DOWN) {
                    playerAnimation.setDown(false);
                }
            }
        });
    }
}
