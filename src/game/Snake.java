package game;

import java.awt.Rectangle;
import java.util.ArrayList;

public class Snake {

    ArrayList<Rectangle> body;

    public Snake(){
        body = new ArrayList<>();
        
        body.add(new Rectangle(100,100,20,20));
        body.add(new Rectangle(80,100,20,20));
        body.add(new Rectangle(60,100,20,20));
    }

    public void move(int xDirection, int yDirection){
        for(int i = body.size()-1;i>0;i++){
            body.set(i,new Rectangle(body.get(i-1)));
        }

        body.get(0).x+=xDirection;
        body.get(0).y+=yDirection;
    }
}
