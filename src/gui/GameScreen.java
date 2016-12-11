package gui;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GameScreen extends Canvas {

    private List<Painter> painterObjects = new ArrayList<Painter>();
    private BufferStrategy strategy;

    public GameScreen(int width, int height) {
        setPreferredSize(new Dimension(width, height));
    }

    public void addPainterObject(Painter painterObject)
    {
        painterObjects.add(painterObject);
    }


    public synchronized void removeMessageBoards() {
        List<Painter> paintersToBeRemoved = painterObjects.stream().filter(painterObject -> painterObject instanceof MessageBoard).collect(Collectors.toList());
        painterObjects.removeAll(paintersToBeRemoved);
    }

    public void init() {
        createBufferStrategy(3);
        strategy = getBufferStrategy();
    }

    public void render() {
        do {
            do {
                Graphics g = strategy.getDrawGraphics();

                paintBackground(g);
                paintPongObjects(g);

                g.dispose();
            } while(strategy.contentsRestored());
            strategy.show();
        } while(strategy.contentsLost());
    }

    private void paintBackground(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, getWidth(), getHeight());
        g.setColor(Color.WHITE);
        g.fillRect(getWidth()/2, 0, 5, getHeight());
    }

    private synchronized void paintPongObjects(Graphics g) {
        for(Painter paintObject : painterObjects)
            paintObject.paint(g);
    }
}
