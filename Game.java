import javax.swing.JPanel;
import java.awt.event.KeyListener;
import java.util.Arrays;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.Color;
import java.awt.Graphics;

public class Game extends JPanel implements ActionListener, KeyListener {
    private static final long serialVersionUID = 1L;
    public int BOARD_WIDTH;
    public int BOARD_HEIGHT;
    // field to keep track of snake head hitting the border of the game board
    private boolean isOnBorder = false;
    
    Snake snake = new Snake();

    // default snake direction vector moves to the right
    public int[] RIGHT = new int[]{snake.getOvalHeight(), 0};
    public int[] LEFT = new int[]{-snake.getOvalHeight(), 0};
    public int[] UP = new int[]{0,-snake.getOvalHeight()};
    public int[] DOWN = new int[]{0,snake.getOvalHeight()};
    public int[] direction = new int[]{};

    public Game(){

        setFocusable(true);
        // TODO: check where keyListener actually needs to go
        addKeyListener(this);
        this.BOARD_WIDTH = 400;
        this.BOARD_HEIGHT = 400;    
        setSize(BOARD_WIDTH, BOARD_HEIGHT);
        setBackground(Color.WHITE);
    }

    @Override
    public void paintComponent(Graphics g) {
        //g.clearRect(this.bodysegment[], y, width, height);
        // TODO Auto-generated method stub
        super.paintComponent(g);
        for(int i = 0; i < snake.getLength(); i++){
            g.fillOval(snake.getBodyXComponent(i), snake.getBodyYComponent(i), snake.getOvalHeight(), snake.getOvalWidth());
            //System.out.println("this is body segment : " + snake.getBodySegment(i));
        }
        g.setColor(Color.BLUE);
        //super.paintComponent(g);
        //g.dispose();
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub

    }
 
    @Override
    public void keyPressed(KeyEvent e) {
        //System.out.println("inside keyPressed event ");
     if(snake.getHead()[0] == BOARD_WIDTH){
        isOnBorder = true;
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
        snake.slither(isOnBorder, direction);
        isOnBorder = false;
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void actionPerformed(ActionEvent e) {
     
    }
    
}