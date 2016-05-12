package modes;

import javax.swing.*;
;import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created on 08/05/2016 by ThePadna.
 */
public class Game {

    private final int TICK_DIFF = 50;
    private final JPanel jGameMenu = new JPanel();
    private final JButton jButton_Multiplayer = new JButton("Multiplayer"),
                          jButton_AI = new JButton("AI Training"),
                          jButton_Story = new JButton("Single Player");
    private final JFrame jFrame;
    private IGameType currentMode;

    public Game(JFrame jFrame) {
        this.jFrame = jFrame;
        jGameMenu.setLayout(new GridLayout(3,0));
        jFrame.add(jGameMenu);
        construct();
    }

    public void init(String mode) {
        switch(mode) {
            case "AI":
                this.currentMode = new GameAI();
            case "multiplayer":
                this.currentMode = new GameMulti();
            case "story":
                this.currentMode = new GameSP();
            default: return;
        }
    }

    private int lastTick;
    public void runTicker() {
        if(!(lastTick != 0 && (lastTick - System.currentTimeMillis()) >= TICK_DIFF)) return;
        if(currentMode != null) currentMode.runTick();
    }

    private void construct() {
        Font btnFont = new Font("Impact", Font.PLAIN, 100);
        jButton_Story.setFont(btnFont);
        jButton_AI.setFont(btnFont);
        jButton_Multiplayer.setFont(btnFont);

        jButton_AI.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                init("AI");
            }
        });

        jButton_Story.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                init("story");
            }
        });

        jButton_Multiplayer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                init("multiplayer");
            }
        });

        jButton_Multiplayer.setHorizontalTextPosition(SwingConstants.CENTER);
        jButton_AI.setHorizontalTextPosition(SwingConstants.CENTER);
        jButton_Story.setHorizontalTextPosition(SwingConstants.CENTER);

        jButton_Multiplayer.setVerticalTextPosition(SwingConstants.CENTER);
        jButton_AI.setHorizontalTextPosition(SwingConstants.CENTER);
        jButton_Story.setHorizontalTextPosition(SwingConstants.CENTER);

        jGameMenu.add(jButton_Story);
        jGameMenu.add(jButton_Multiplayer);
        jGameMenu.add(jButton_AI);
    }
}
