import java.util.LinkedList;

public class Physics {

    static boolean menu = true;

    public static boolean Collision(Enemy enemy, LinkedList<Bullet> bullet){

        for (int i = 0; i < bullet.size(); i++){
            if (enemy.getBounds(100,57).intersects(bullet.get(i).getBounds(2,2))){
                GameState.highscore += 100;
                return true;
            }
        }
        return false;
    }
    public static boolean Collision(Player player, LinkedList<Enemy> enemy) {

        for (int i = 0; i < enemy.size(); i++) {
            if (player.getBounds(150, 90).intersects(enemy.get(i).getBounds(100, 57))) {
                menu = true;
                return true;
            }
            else menu = false;
        }
        return false;
    }

}
