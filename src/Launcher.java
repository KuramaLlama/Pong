import control.MenuControl;
import gui.MainMenu;
import gui.Window;

public class Launcher {

    private static Window window = new Window();
    private static MainMenu mainMenu = new MainMenu(800, 600);

    public static void main(String[] args) throws InterruptedException {
        setupWindow();
        setupMainMenu();
    }

    private static void setupWindow() {
        window.add(mainMenu);
        window.build("Pong");
        mainMenu.build();
        window.setVisible(true);

    }

    private static void setupMainMenu() {
        MenuControl menuControl = new MenuControl(window, mainMenu);
        menuControl.onSingle();
        menuControl.onOnline();

        menuControl.runMenu();
    }

//    private static void setupScreen() {
//        screen.init();
//    }
//
//    private static void setupControl() {
//        GameSetup gameSetup = new GameSetup(screen);
//        gameSetup.addPaintObjectsToScreen();
//        gameSetup.run();
//    }
}
