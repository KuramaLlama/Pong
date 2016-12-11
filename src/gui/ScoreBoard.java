package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class ScoreBoard implements Painter {

    private int player1Score = 0, player2Score = 0;
    private GameScreen screen;

    public ScoreBoard(GameScreen screen) {
        this.screen = screen;
    }

    public void setPlayer1Score(int score) {
        player1Score = score;
    }

    public void setPlayer2Score(int score) {
        player2Score = score;
    }

    public int getPlayer1Score() {
        return player1Score;
    }

    public int getPlayer2Score() {
        return player2Score;
    }

    public void resetScores() {
        player1Score = 0;
        player2Score = 0;
    }

    public void paint(Graphics g) {
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 40));
        g.drawString(Integer.toString(player1Score), screen.getWidth()/2 - 75, 50);
        g.drawString(Integer.toString(player2Score), screen.getWidth()/2 + 50, 50);
    }
}
