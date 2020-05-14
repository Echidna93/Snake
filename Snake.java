// To store the snake class
// Goal of snake class: store direction, location of body parts
public class Snake {
    // stores length of snake
    
    public int length;
    public static int OVAL_WIDTH = 10;
    public static int OVAL_HEIGHT = 10;
    public int x;
    public int y;
    int[][] body = new int[][]{{100, 100},{110, 100},{120,100}};

    public Snake(){
        
    }
    public int getOvalWidth(){
        return OVAL_WIDTH;
    }
    public int getOvalHeight(){
        return OVAL_HEIGHT;
    }
    public void slither(){
        body[0][0] = body[length-1][0] + body[length-1][2];
        int[] tmpArray = body[0];
        body[0] = body[length-1];
        body[length-1] = tmpArray;
    }
    
}