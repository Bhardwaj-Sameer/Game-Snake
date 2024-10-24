package game;

import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GamePanel extends JPanel {

    Snake snake;
    Food food;
    Timer timer;

    int xDirec=20;
    int yDirec=0;

    public GamePanel() {
        this.setBackground(Color.BLACK);
        snake = new Snake();
        food = new Food();
        timer = new Timer(100, e ->{
            snake.move(xDirec,yDirec);

            //FOOD AND SNAKE INTERSECTION
            if(snake.body.get(0).intersects(food.position)||snake.body.get(1).intersects(food.position)){
                snake.grow();
                food.spawnFood();
            }
            repaint();
        });

        timer.start();

        food.spawnFood();

        //ARROW-KEY INPUT
        this.setFocusable(true); // For keyboard input
        this.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {

                int key = e.getKeyCode();

                switch (key) {
                    case KeyEvent.VK_UP:
                        snake.move(0, -20);
                        xDirec=0;
                        yDirec=-20;
                        break;

                    case KeyEvent.VK_DOWN:
                        snake.move(0, 20);
                        xDirec=0;
                        yDirec=20;
                        break;

                    case KeyEvent.VK_RIGHT:
                        snake.move(20, 0);
                        xDirec=20;
                        yDirec=0;
                        break;

                    case KeyEvent.VK_LEFT:
                        snake.move(-20, 0);
                        xDirec=-20;
                        yDirec=0;
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
        
        //SNAKE
        for(Rectangle segment: snake.body){
            g.fillOval(segment.x, segment.y, segment.width, segment.height);
        }

        //FOOD
        g.setColor(Color.GREEN);
        g.fillOval(food.position.x, food.position.y, food.position.width, food.position.height);
    }

}
