import javax.swing.*;
import java.awt.*;
import java.awt.Dimension;

public class Window extends Canvas {

    private JFrame frame;
    private Canvas canvas;
    private String title;
    private int height, width;

    public Window (String title, int width, int height, Game game){
        this.title = title;
        this.width = width;
        this.height = height;

        createDisplay(game);
    }

    private void createDisplay(Game game){
        frame = new JFrame(title);
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(width,height));
        canvas.setMaximumSize(new Dimension(width,height));
        canvas.setMinimumSize(new Dimension(width,height));

        frame.add(game);
        game.setFocusable(false);
        game.start();
    }

    public JFrame getFrame(){
        return frame;
    }
    public Canvas getCanvas() { return canvas; }

}
