import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.util.Arrays;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class InitMenu extends JPanel implements ActionListener {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    boolean startGame;

    JButton startButton = new JButton("New Game");
    JFrame frame = new JFrame();
    Game game = new Game();
    public InitMenu(Game game, JFrame frame) {
        add(startButton);
        startButton.addActionListener(this);
        startGame = false;
        this.game = game;
        this.frame = frame;

    }
    @Override
    protected void paintComponent(Graphics g){
        
    }
    public void setStartGame(boolean startgame){
        this.startGame = startgame;
    }
    public boolean getStartGame(){
        return this.startGame;
    }
    @Override
    public void actionPerformed(ActionEvent e){
        frame.setContentPane(game);
        frame.validate();
    }
}