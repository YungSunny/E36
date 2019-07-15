import java.awt.*;

public class Bullet extends GameObjects{

    public Bullet(int x, int y) {
        super(x, y);
    }
    public void tick() {
        y -= 10;
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.bullet, x, y, null);
    }

    public Rectangle getBounds(int width, int height){
        return new Rectangle((int)x, (int)y, (int)width, (int)height);
    }
}
