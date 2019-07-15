import java.awt.*;
import java.util.LinkedList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.stream.Collectors;


public class Player extends GameObjects {

    private Game game;
    static public Controller c;
    private GameState gameState;
    private KeyManager key = new KeyManager();
    private long lastAttack;
    private long cooldown = 100;

    public int enemy_count = 6;
    public int enemy_killed = 0;
    static public LinkedList<Bullet> bullet;
    static public LinkedList<Enemy> enemies;

    private DateTimeBuilder builder = new DateTimeBuilderImp();
    private DateNTime dateOject = builder.getDate();


    private int sec = 0;
    private Timer timer = new Timer();
    TimerTask task = new TimerTask() {
        @Override
        public void run() {
            sec++;
            if (sec == 60){
                dateOject.addMinute(1);
                sec = 0;
            }
        }
    };

    public Player(Game game, int x, int y, GameState gameState) {
        super(x, y);
        this.game = game;
        c = new Controller(this, game);
        timer.schedule(task, 0, 1000);
        this.gameState = gameState;
    }

    public void generateEnemies(){
        c.createEnemy(enemy_count);
    }

    public void generateLinkedList(){
        bullet = c.getBullet();
        enemies = c.getEnemie();
    }

    @Override
    public void tick() {
        getInput();
        move();
        c.tick();
        if (x <= 0){
            x = 0;
        }
        if (x >= 720 - 150){
            x = 720 - 150;
        }
        if (y < 0){
            y = 0;
        }
        if (y >= 540 - 115){
            y = 540 - 115;
        }

        if (enemy_killed >= enemy_count){
            enemy_count += 2;
            enemy_killed = 0;
            c.createEnemy(enemy_count);
        }
        if(Physics.Collision(this, enemies)) {
            GameState.highscore = 0;
            Physics.menu = true;
            gameState = new GameState(game);
            enemy_count = 6;
            enemy_killed = 0;
        }
        else Physics.menu = false;
    }

    private void getInput(){
        xMove = 0;
        yMove = 0;

        if(game.getKeyManager().up)
            yMove = -speed;
        if(game.getKeyManager().down)
            yMove = speed;
        if(game.getKeyManager().left)
            xMove = -speed;
        if(game.getKeyManager().right)
            xMove = speed;
        if (game.getKeyManager().space && !key.isShooting){
           key.isShooting = true;
           c.addBullet(new Bullet(x + 107,y + 10));
           }
        long time = System.currentTimeMillis();
        if (time > lastAttack + cooldown){
            key.isShooting = false;
            lastAttack = time;
        }
    }

    @Override
        public void render(Graphics g){ //override???
            g.drawImage(Assets.e36, x, y,null);
            c.render(g);
            g.setColor(Color.WHITE);
            g.setFont(new Font("Impact",Font.PLAIN, 15));
            g.drawString(dateOject.toString(), 0, 510);
        }

    public Rectangle getBounds(int width, int height){
        return new Rectangle((int)x, (int)y, (int)width, (int)height);
    }

    public int getEnemy_killed() {
        return enemy_killed;
    }

    public void setEnemy_killed(int enemy_killed) {
        this.enemy_killed = enemy_killed;
    }
}

