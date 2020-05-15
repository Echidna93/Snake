// To store the snake class
// Goal of snake class: store direction, location of body parts
import java.util.ArrayList;

public class Snake {

    // stores length of snake
    
    public static int OVAL_WIDTH = 10;
    public static int OVAL_HEIGHT = 10;

    public int x;
    public int y;
    // arrayList holds the body elements of the snake
    public ArrayList<int[]> body = new ArrayList<>();
    public Snake(){
        // add some initial body elements
        body.add(new int[]{100,100});
        body.add(new int[]{110,100});
        body.add(new int[]{120,100});
    }
    public int getOvalWidth(){
        return OVAL_WIDTH;
    }
    public int getOvalHeight(){
        return OVAL_HEIGHT;
    }
    public int getLength(){
        return body.size();
    }
    // method to return the head of the ArrayList representing Snake body
    public int[] getHead(){
        int xComponent = getBodyXComponent(body.size()-1);
        int yComponent = getBodyYComponent(body.size()-1);
        int[] head = new int[]{xComponent, yComponent};
        return head;
    }

    public int getBodyXComponent(int bodySegment){
        return body.get(bodySegment)[0];
    }

    public int getBodyYComponent(int bodySegment){
        return body.get(bodySegment)[1];
    }

    public void slither(boolean isOnBorder, int[] direction){
        
        // grab tail
        int[] tail = new int[]{body.get(0)[0], body.get(0)[1]};
        
        // logic to handle the case where the snake head is on the border of the map
        // TODO: make this conditional on the direction as well
        if(isOnBorder){
            tail[0] = 0;    
            
        }else{
            tail[0] = getHead()[0] + direction[0];
            tail[1] = getHead()[1] + direction[1];
        }
        body.remove(0);
        body.add(tail);
    }

}