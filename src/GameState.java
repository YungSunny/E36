import java.awt.*;
import java.util.*;

public class GameState extends State {

    private Player player;
    static int highscore = 0;
    private Set<Star> star = new HashSet<>();

    private int numberOfStars = 50;

    public GameState(Game game) {
        super(game);
        player = new Player(game, 250, 350, this);
        generateStars();
        player.generateLinkedList();
        player.generateEnemies();
    }

    public Set<Star> generateStars(){
        while (star.size() < numberOfStars){
                star.add(new Star());
        }
        star.add(new Star(0,0));
        star.add(new Star(0,0));
        return star;
    }

    public void tick(){
        player.tick();

        for (Star s: star){
            s.tick();
        }

    }

    public void render(Graphics g) {
        player.render(g);
        g.setColor(Color.RED);
        g.setFont(new Font("Impact",Font.PLAIN, 25));
        g.drawString("HIGHSCORE : " + String.valueOf(highscore), 5, 30);
        for (Star s: star){
            s.render(g);
        }

    }
}
