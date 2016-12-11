package animation;

import gui.GameScreen;
import pongObject.Player;

public class PlayerAnimation {

    private GameScreen gameScreen;
    private Player player;
    private boolean isUp, isDown;


    public PlayerAnimation(GameScreen gameScreen, Player player) {
        this.gameScreen = gameScreen;
        this.player = player;
    }

    public void setUp(boolean isUp) {
        this.isUp = isUp;
    }

    public void setDown(boolean isDown) {
        this.isDown = isDown;
    }

    public void movePlayer() {
        if(isUp && player.getY() >= 0)
            player.setY(player.getY()-player.getyVel());
        if(isDown && (player.getY() + player.getHeight()) <= gameScreen.getHeight()) {
            player.setY(player.getY()+player.getyVel());
        }
    }
}
