package game;

import javax.swing.JFrame;
import game.GamePanel;

import javax.swing.ImageIcon;

public class GameFrame extends JFrame{
    public GameFrame(){

        ImageIcon snake=new ImageIcon("src\\resources\\images\\snake.png");
        
        this.setTitle("Snake Game");
        this.setIconImage(snake.getImage());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(800,800);
        
        
        GamePanel panel=new GamePanel();
        this.add(panel);
        this.setVisible(true);

    }
}
