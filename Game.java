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
    protected String direction;
    Snake snake = new Snake();
    public Game(){
        setFocusable(true);
        addKeyListener(this);    
        //Image h = this.head.getScaledInstance(10, 10, 1);
        setSize(400,400);
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
     if(e.getKeyCode() == KeyEvent.VK_RIGHT){
        System.out.println("here");
        snake.slither();
        repaint();
     }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void actionPerformed(ActionEvent e) {
     
    }
    
}