package game;

import javax.swing.JFrame;
import game.GamePanel;

public class GameFrame extends JFrame{
    public GameFrame(){
        
        this.setTitle("Snake Game");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(600,600);
        
        GamePanel panel=new GamePanel();
        this.add(panel);
        this.setVisible(true);

    }
}
