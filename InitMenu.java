import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.KeyListener;
import java.util.Arrays;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class InitMenu extends JPanel {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    JButton startButton = new JButton("New Game");
    public InitMenu(){
        add(startButton);           
    }
    @Override
    protected void paintComponent(Graphics g){
        
    }
    
}