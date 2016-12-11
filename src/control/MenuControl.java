package control;

import gui.ConnectScreen;
import gui.GameScreen;
import gui.MainMenu;
import gui.Window;

public class MenuControl {

    private GameScreen gameScreen = new GameScreen(800, 600);
    private ConnectScreen connectScreen = new ConnectScreen(800, 600);
    private GameSetup gameSetup;
    private Window window;
    private MainMenu mainMenu;
    private boolean running = true;

    public MenuControl(Window window, MainMenu mainMenu) {
        this.window = window;
        this.mainMenu = mainMenu;
    }

    public void runMenu() {
        while(running) {
            try{
                mainMenu.repaint();
                Thread.sleep(5);
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        }

        gameScreen.init();
        gameSetup = new GameSetup(gameScreen);
        gameSetup.addPaintObjectsToScreen();
        gameSetup.run();

        //set flags to run single player and another flag for online which will run continuing
        //off the main thread because right now by starting the game thread from the EDT it hogs up the EDT
        //as i'm trying to add the player Control off the EDT which is queued rather than ran.
    }

    public void onSingle() {
        mainMenu.addActionListenerSingle(e -> {
            window.swap(mainMenu, gameScreen);
            running = false;
        });
    }

    public void onOnline() {
        mainMenu.addActionListenerOnline(e -> {
            connectScreen.build();
            window.swap(mainMenu, connectScreen);
            running = false;
        });
    }
}
