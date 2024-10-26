package game;

import java.awt.Rectangle;
import java.util.Random;

public class Food {
    public Rectangle position;

    public void spawnFood(){
        Random random = new Random();
        int x = random.nextInt(25)*20;
        int y = random.nextInt(25)*20;
        position = new Rectangle(x,y, 10,10);
    }
}
