import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class State {

    private static State currentState = null;
    protected Game game;

    public static void setState(State state){ //static funkcionalumas
        currentState = state;
    }

    public static State getState(){
        return currentState;
    } //static funkcionalumas


    public State(Game game){
        this.game = game;
    }

    public abstract void tick();
    public abstract void render (Graphics g);

}

