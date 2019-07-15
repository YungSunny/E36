import java.awt.*;
import java.util.LinkedList;
import java.util.Random;

public class Controller {

    private LinkedList<Bullet> bullet = new LinkedList<>();
    private LinkedList<Enemy> enemie = new LinkedList<>();

    private Bullet tempBullet;
    private Player player;
    private Enemy tempEnemy;
    private Game game;


    public Controller(Player player, Game game){
        this.player= player;
        this.game = game;
    }

    public void createEnemy(int enemy_count){
        for (int i = 0; i < enemy_count; i++){
            addEnemy(new Enemy(this,player));
        }
    }

    public void tick(){
        for (int i = 0; i < bullet.size(); i++){
            tempBullet = bullet.get(i);

            tempBullet.tick();
        }

        for (int i = 0; i < enemie.size(); i++){
            tempEnemy = enemie.get(i);

            tempEnemy.tick();
        }
    }

    public void render(Graphics g) {
        for (int i = 0; i < bullet.size(); i++) {
            tempBullet = bullet.get(i);

            tempBullet.render(g);
        }
        for (int i = 0; i < enemie.size(); i++) {
            tempEnemy = enemie.get(i);

            tempEnemy.render(g);
        }
    }


    public void addBullet(Bullet block){
        bullet.add(block);
    }

    public void removeBullet(Bullet block){
        bullet.remove(block);
    }

    public void addEnemy(Enemy block){
        enemie.add(block);
    }

    public void removeEnemy(Enemy block){ enemie.remove(block); }

    public  LinkedList<Bullet> getBullet() {
        return bullet;
    }

    public  LinkedList<Enemy> getEnemie() {
        return enemie;
    }
}
