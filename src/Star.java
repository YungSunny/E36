import java.awt.*;
import java.util.Objects;
import java.util.Random;


public class Star extends GameObjects{

    private Random randomX = new Random();
    private Random randomY = new Random();
    private int maxX = 720;
    private int minX = 10;
    private int maxY = 540;
    private int minY = 10;

    public Star(){
        super(0,0);
        x = randomX.nextInt(maxX - minX + 1);
        y = randomY.nextInt(maxY - minY + 1);
    }

    public Star(int x, int y){
        super(x,y);
    }

    public boolean equals(Object startObject){
        if (this == startObject) return true;
        if (startObject == null || getClass() != startObject.getClass()) return false;
        Star star = (Star) startObject;
        return x == star.x && y == star.y;
    }

    public int hashCode() {
        return Objects.hash(x, y);
    }

    public void tick() {
        x += 5;
        if(x > 720)
            x = 0;
    }

    public void render(Graphics g) {
        g.drawImage(Assets.star, x, y, null);
    }
}
