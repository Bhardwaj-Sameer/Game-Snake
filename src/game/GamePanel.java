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
        this.setBackground(Color.YELLOW);
        this.setSize(600,600);
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

        //WALLS
        g.setColor(Color.BLACK);
        g.fillRect(0,0,800,20);
        g.fillRect(766,0,20,770);
        g.fillRect(0,743,800,20);
        g.fillRect(0,0,20,770);


        
        //SNAKE
        g.setColor(Color.RED);
        for(int i=snake.body.size()-1;i>=0;i--){
            if(i!=0){
                g.setColor(Color.red);
            }else{
                g.setColor(Color.WHITE);
            }
            g.fillOval(snake.body.get(i).x, snake.body.get(i).y, snake.body.get(i).width, snake.body.get(i).height);
        }

        //FOOD
        g.setColor(Color.GREEN);
        g.fillOval(food.position.x, food.position.y, food.position.width, food.position.height);
    }

}
