
// To store the snake class
// Goal of snake class: store direction, location of body parts
import java.util.ArrayList;
import java.util.Arrays;

public class Snake {
    // stores length of snake
    
    public static int OVAL_WIDTH = 10;
    public static int OVAL_HEIGHT = 10;

    public static String EMPTY = "";

    public int x;
    public int y;
    // arrayList holds the body elements of the snake
    public ArrayList<int[]> body = new ArrayList<>();

    public int[] directionVector = new int[]{};

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

    public int[] getSecondComponent(){
        return body.get(body.size()-2);
    }

    public int getBodyXComponent(int bodySegment){
        return body.get(bodySegment)[0];
    }

    public int getBodyYComponent(int bodySegment){
        return body.get(bodySegment)[1];
    }

    public void grow(){
        body.add(new int[]{this.getHead()[0] + directionVector[0], this.getHead()[1] + this.directionVector[1]});
        System.out.println("(\n");
        for(int[] part : body){
                System.out.println("( " + part[0] + "," + part[1] + ")");
            }
        }
    

    
    public void slither(String isWhichOnBorder, int[] direction){    
        // grab tail
        int[] tail = new int[]{body.get(0)[0], body.get(0)[1]};
        // logic to handle the case where the snake head is on the border of the map
        // TODO: make this conditional on the direction as well
        this.directionVector = direction;
        if(!isWhichOnBorder.equals(EMPTY)){
            System.out.println("hitting the isEmpty() statement");
            switch(isWhichOnBorder){
                case "TOP":
                    tail[1] = 0;
                    break;
                case "BOTTOM":
                    tail[1] = 400;
                    break;
                case "LEFT":
                    tail[0] = 400;
                    break;
                case "RIGHT":
                    tail[0] = 0;
                    break;
                default:
                    break;
            }
        }else{
            tail[0] = getHead()[0] + direction[0];
            tail[1] = getHead()[1] + direction[1];
            System.out.println("this is head of array: " + "( " + getHead()[0] + "," + getHead()[1] + ")");
        }

        body.remove(0);
        for(int[] part : body){
            System.out.println("( " + part[0] + "," + part[1] + ")");
        }
        body.add(tail);
        System.out.println("after adding new head: ");
        for(int[] part : body){
            System.out.println("( " + part[0] + "," + part[1] + ")");
        }
    }

}