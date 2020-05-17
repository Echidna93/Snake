import javax.swing.JPanel;
import java.awt.event.KeyListener;
import java.util.Arrays;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Game extends JPanel implements ActionListener, KeyListener {
    private static final long serialVersionUID = 1L;
    public int BOARD_WIDTH = 400;
    public int BOARD_HEIGHT = 400;
    // field to keep track of snake head hitting the border of the game board
    public String isOnWhichBorder = "";
    Snake snake = new Snake();
    int randX = (int)(Math.random() * ((BOARD_WIDTH) + 1));
    int randY = (int)(Math.random() * ((BOARD_HEIGHT) + 1));
    Apple apple = new Apple(randX, randY, 20, 20);
    public int[] RIGHT = new int[]{snake.getOvalHeight(), 0};
    public int[] LEFT = new int[]{-snake.getOvalHeight(), 0};
    public int[] UP = new int[]{0,-snake.getOvalHeight()};
    public int[] DOWN = new int[]{0,snake.getOvalHeight()};

    // default snake direction vector moves to the right
    public int[] direction = new int[]{};

    public Game(){

        setFocusable(true);
        // TODO: check where keyListener actually needs to go
        addKeyListener(this);    
        setSize(BOARD_WIDTH, BOARD_HEIGHT);
        setBackground(Color.WHITE);
    }

    @Override
    public void paintComponent(final Graphics g) {
        //g.clearRect(this.bodysegment[], y, width, height);
        // TODO Auto-generated method stub
        super.paintComponent(g);
        g.setColor(Color.GREEN);
        for(int i = 0; i < snake.getLength(); i++){
            g.fillOval(snake.getBodyXComponent(i), snake.getBodyYComponent(i), snake.getOvalHeight(), snake.getOvalWidth());
            //System.out.println("this is body segment : " + snake.getBodySegment(i));
        }
        g.setColor(Color.RED);
        g.fillOval(apple.getX(), apple.getY(), apple.getWidth(), apple.getHeight());
        //super.paintComponent(g);
        //g.dispose();
    }
    /*
     * @param isOnWhichBorder the isOnWhichBorder to set
     */
    public void setIsOnWhichBorder(final String isOnWhichBorder) {
        this.isOnWhichBorder = isOnWhichBorder;
    }

    @Override
    public void keyTyped(final KeyEvent e) {
        // TODO Auto-generated method stub

    }

    // method to check if snake and apple are occupying the same point in the game board
    public boolean isCollision(Apple apple, Snake snake){
        //System.out.println("Snake position : " + Arrays.toString(snake.getHead()));
        //System.out.println("Apple position : " + "(" + apple.getX() + apple.getY() + ")");
        //(snake.getHead()[0] <= (apple.getX() + apple.getWidth()))) && (snake.getHead()[1] >= Math.abs(apple.getX() - apple.getWidth()) && (snake.getHead()[1] <= (apple.getY() - apple.getHeight())))
        boolean isCollision = false;
        if(((snake.getHead()[0] >= Math.abs(apple.getX() - apple.getWidth())) && (snake.getHead()[0] <= (apple.getX() + apple.getWidth()))) && ((snake.getHead()[1] >= Math.abs(apple.getY() - apple.getHeight())) && (snake.getHead()[1] <= (apple.getY() + apple.getHeight())))){
            isCollision = true;
        }
        return isCollision;
    }
 
    @Override
    public void keyPressed(final KeyEvent e) {
        //System.out.println("inside keyPressed event ");
     if(snake.getHead()[0] == 0 && !(snake.getBodyXComponent(1) == 400)){
        isOnWhichBorder = "LEFT";
     }
     else if((snake.getHead()[0] == BOARD_WIDTH) && !(snake.getBodyXComponent(1) == 0)){
        isOnWhichBorder = "RIGHT";
     }
     else if((snake.getHead()[1] == 0) && !(snake.getBodyYComponent(1) == 400)){
        isOnWhichBorder = "BOTTOM";
     }
     else if((snake.getHead()[1] == BOARD_HEIGHT) && !(snake.getBodyYComponent(1) == 0)){
        isOnWhichBorder = "TOP";
     }
    switch(e.getKeyCode()){
        case KeyEvent.VK_RIGHT:
            direction = RIGHT;
            break;
        case KeyEvent.VK_LEFT:
            direction = LEFT;
            break;
        case KeyEvent.VK_UP:
            direction = UP;
            break;
        case KeyEvent.VK_DOWN:
            direction = DOWN;
            break;
        }
        snake.slither(isOnWhichBorder, direction);
        if(isCollision(apple, snake)){
            System.out.println("snake and apple have collided");
        }
        this.setIsOnWhichBorder("");
        repaint();
    }

    @Override
    public void keyReleased(final KeyEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void actionPerformed(final ActionEvent e) {
     
    }
    
}