import javax.swing.JFrame;

public class Main {
    public static void main(String[] args){
        JFrame frame = new JFrame();
        Game game = new Game();

        frame.setSize(400, 400);
        frame.setTitle("SnEk");
        frame.setVisible(true);
        //Game game = new Game();
        frame.setContentPane(game);
        game.setFocusable(true);
        frame.addKeyListener(game);
    }
}