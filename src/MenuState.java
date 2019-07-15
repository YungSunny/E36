import java.awt.*;

public class MenuState extends State {

    public MenuState(Game game) {
        super(game);
    }

    @Override
    public void tick() {
        if (game.getKeyManager().space) {
            State.setState(game.getGameState());
            Physics.menu = false;
        } else if (game.getKeyManager().start) {
            Physics.menu = false;
            State.setState(game.getGameState());
        }
    }

    @Override
    public void render(Graphics g){
        g.drawImage(Assets.e36big,100,100,null);
        g.setColor(Color.black);
        g.fillRect(290,320,150,100);
        g.setColor(Color.red);
        g.setColor(Color.WHITE);
        g.setFont(new Font("Impact",Font.PLAIN, 60));
        g.drawString("PLAY", 313, 395);
        g.setFont(new Font("Impact",Font.PLAIN, 30));
        g.setColor(Color.red);
        g.drawString("PRESS SPACE OR PLAY TO ENTER MADNESS", 120,50 );
    }
}
