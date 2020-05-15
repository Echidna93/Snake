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
    // method to return the head of the ArrayList representing Snake body
    public int[] getHead(){
        int xComponent = getBodyXComponent(length-1);
        int yComponent = getBodyYComponent(length-1);
        int[] head = new int[]{xComponent, yComponent};
        return head;
    }

    public int getBodyXComponent(int bodySegment){
        return body.get(bodySegment)[0];
    }

    public int getBodyYComponent(int bodySegment){
        return body.get(bodySegment)[1];
    }

    public void slither(boolean isOnBorder){
        
        // grab tail
        int[] tail = new int[]{body.get(0)[0], body.get(0)[1]};
        
        // logic to handle the case where the snake head is on the border of the map
        // TODO: make this conditional on the direction as well
        if(isOnBorder){
            tail[0] = 0;    
        }
        else{
            tail[0] = getHead()[0] + OVAL_WIDTH;
        }
        body.remove(0);
        body.add(tail);
    }

}