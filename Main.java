import javax.swing.JFrame;
import sun.security.x509.IssuerAlternativeNameExtension;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        JFrame frame = new JFrame();
        Game game = new Game();
        frame.setSize(400, 400);
        frame.setTitle("SnEk");
        frame.setVisible(true);
        //Game game = new Game();
        frame.setContentPane(game);
        game.setFocusable(true);
        frame.addKeyListener(game);
        while(game.isAlive){
            game.play();
            Thread.sleep(100);
        }
    }
}