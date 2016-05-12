import modes.Game;
import modes.IGameType;

import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

/**
 * Created on 08/05/2016 by ThePadna.
 */
public class App implements Runnable {

    static public final int HEIGHT = 500, WIDTH = 750;
    static private final JFrame jFrame_MENU = new JFrame("Infiltrations"), jFrame_GAME = new JFrame("Infiltrations");
    static private State state = State.MENU;
    private Game game;

    private JMenu jMenu_PLAY = null, jMenu_SETTINGS = null;
    private JMenuBar jMenuBar = null;

    public App() {
        buildMenu();
    }

    public void run() {
        if(state == State.RUNNING) {
            game.runTicker();
        }
    }

    private void buildMenu() {
        jFrame_MENU.setSize(WIDTH, HEIGHT);
        jMenuBar = new JMenuBar();
        jMenu_PLAY = new JMenu("Play");
        jMenu_SETTINGS = new JMenu("Settings");
        MenuListener menuListener = new MenuListener() {
            public void menuSelected(MenuEvent e) {
                runGameWindow();
            }
            public void menuDeselected(MenuEvent e) {}
            public void menuCanceled(MenuEvent e) {}
        };
        jMenu_PLAY.addMenuListener(menuListener);
        jMenuBar.add(jMenu_PLAY);
        jMenuBar.add(jMenu_SETTINGS);
        jFrame_MENU.setJMenuBar(jMenuBar);
        jFrame_MENU.setVisible(true);
        jFrame_MENU.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void runGameWindow() {
        jFrame_MENU.setVisible(false);
        jFrame_GAME.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                jFrame_GAME.dispose();
                jFrame_MENU.setVisible(true);
            }
        });
        jFrame_GAME.setSize(WIDTH, HEIGHT);
        jFrame_GAME.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jFrame_GAME.setVisible(true);
        game = new Game(jFrame_GAME);
    }
}

enum State {
    RUNNING, MENU;
}