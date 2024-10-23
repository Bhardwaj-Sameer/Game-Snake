package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.JPanel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GamePanel extends JPanel {

    Snake snake;

    public GamePanel() {
        this.setBackground(Color.BLACK);
        snake = new Snake();

        this.setFocusable(true); // For keyboard input

        this.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {

                int key = e.getKeyCode();

                switch (key) {
                    case KeyEvent.VK_UP:
                        snake.move(0, -20);
                        break;

                    case KeyEvent.VK_DOWN:
                        snake.move(0, 20);
                        break;

                    case KeyEvent.VK_RIGHT:
                        snake.move(20, 0);
                        break;

                    case KeyEvent.VK_LEFT:
                        snake.move(-20, 0);
                        break;
                }
                repaint();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.RED);
        

        for(Rectangle segment: snake.body){
            g.fillOval(segment.x, segment.y, segment.width, segment.height);
        }
    }

}
