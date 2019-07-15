import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class GameObjects {

    protected int x, y;
    protected int health;
    protected int speed;
    protected int xMove, yMove;

    public GameObjects(int x, int y){
        this.x = x;
        this.y = y;
        health = 1;
        speed = 3;
        xMove = 0;
        yMove = 0;
    }

    public void move(){
        x += xMove;
        y += yMove;
    }

    public int getHealth() {
        return health;
    }

    public abstract void tick ();

    public abstract void render(Graphics g);

    public Rectangle getBounds(int width, int height){
        return new Rectangle((int)x, (int)y, (int)width, (int)height);

    }

}
