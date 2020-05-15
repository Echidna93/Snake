// To store the snake class
// Goal of snake class: store direction, location of body parts
import java.util.ArrayList;
import java.util.Arrays;

public class Snake {
    // stores length of snake
    
    public int length;
    public static int OVAL_WIDTH = 10;
    public static int OVAL_HEIGHT = 10;
    public int x;
    public int y;
    public ArrayList<int[]> body = new ArrayList<>();
    public Snake(){
        body.add(new int[]{100,100});
        body.add(new int[]{110,100});
        body.add(new int[]{120,100});
        this.length = body.size();
    }
    public int getOvalWidth(){
        return OVAL_WIDTH;
    }
    public int getOvalHeight(){
        return OVAL_HEIGHT;
    }
    public int getLength(){
        return this.length;
    }

    public int getBodyXComponent(int bodySegment){
        return body.get(bodySegment)[0];
    }

    public int getBodyYComponent(int bodySegment){
        return body.get(bodySegment)[1];
    }

    public void slither(){
        // step the array
        // swap element 1 and 2
        int[] tmpBody = new int[]{body.get(0)[0], body.get(0)[1]}; 
        tmpBody[0] += 3*OVAL_WIDTH;
        body.remove(0);
        body.add(tmpBody);
    }

}