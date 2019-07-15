
import java.awt.*;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Random;
import java.util.stream.Collectors;


public class Enemy extends GameObjects {

    private Random randomX = new Random();
    private int maxX = 670;
    private int minX = 10;
    private int speed = randomX.nextInt(2) + 1;
    private Controller c;
    private Player player;

    public Enemy(Controller c, Player player) {
        super(0,0);
        x = randomX.nextInt(maxX - minX + 1);
        this.c = c;
        this.player = player;
    }

    @Override
    public void tick() {

        y += speed;
        if (y > 540){
            y = -10;
            x = randomX.nextInt(maxX - minX + 1);
        }
        if(Physics.Collision(this, Player.bullet)) {
            health -= 1;
            player.setEnemy_killed(player.getEnemy_killed() + 1);
        }

            LinkedList<Enemy> eliminate = c.getEnemie().stream()
                    .filter(enemy -> enemy.getHealth() == 0)
                    .collect(Collectors.toCollection(LinkedList::new));
            eliminate.forEach(c::removeEnemy);

            Integer health = c.getEnemie().stream()
                    .map(Enemy::getHealth)
                    .reduce(0, (x,y) -> x + y);
        }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.audi, x, y, null );
    }

    public Rectangle getBounds(int width, int height){
        return new Rectangle((int)x, (int)y, (int)width, (int)height);
    }

    public boolean equals(Object startObject){
        if (this == startObject) return true;
        if (startObject == null || getClass() != startObject.getClass()) return false;
        Enemy enemy = (Enemy) startObject;
        return x == enemy.x && y == enemy.y;
    }

    public int hashCode() {
        return Objects.hash(x, y);
    }

    public int getHealth() {
        return health;
    }

}
