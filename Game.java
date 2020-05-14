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
    public int[][] bodySegment = new int[][]{{100, 100, 10, 10},{110, 100, 10, 10}};
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
        for(int i = 0; i < bodySegment.length; i++){
        g.fillOval(bodySegment[i][0], bodySegment[i][1], bodySegment[i][2], bodySegment[i][3]);
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
        int length = this.bodySegment.length;
        // take tail attach it to head
        System.out.println(Arrays.toString(bodySegment[0]));
        // step the array
      
        // swap element 1 and 2
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