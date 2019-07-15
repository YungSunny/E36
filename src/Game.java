
import java.awt.*;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable { //loading and doing

    public int width;
    public int height;
    private Thread thread;
    private boolean running = false;

    private Window window;

    //states
    private static State gameState;
    private static State menustate;

    private KeyManager keyManager;
    private MouseManager mouseManager;


    public Game(String title, int width, int height){
        this.width = width;
        this.height = height;
        window = new Window(title, width, height, this); //konstruktorius kreipiasi i kita
        keyManager = new KeyManager();
        mouseManager = new MouseManager();
    }

    public synchronized void start(){     //synchronized only direct working with threads
        if (running){
            return;
        }
        thread = new Thread(this); //this same name as a class
        thread.start();
        running = true;
    }

    public synchronized void stop(){
        if (!running){
            return;
        }
        try{
            thread.join();            //tread is waiting
            running = false;
        }catch (Exception e){
            e.printStackTrace();      //show error bug in console
        }
    }


    private void tick (){ // (update)
        keyManager.tick();
        if (State.getState() != null){
            State.getState().tick();
        }
        if (Physics.menu == true){
            State.setState(menustate);
        }
        else State.setState(gameState);
    }

    private void init (){

        gameState = new GameState(this);
        menustate = new MenuState(this);
        State.setState(menustate);
        Assets.init();
        window.getFrame().addKeyListener(keyManager);
        window.getFrame().addMouseListener(mouseManager);
        window.getFrame().addMouseMotionListener(mouseManager);
        window.getCanvas().addMouseListener(mouseManager);
        window.getCanvas().addMouseMotionListener(mouseManager);
    }

    private void render(){
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null){
            this.createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();
        g.clearRect(0,0,width,height);
        g.drawImage(Assets.back,0, 0,null);
        if (State.getState() != null)
            State.getState().render(g);
        g.dispose();
        bs.show();

    }

    public void run(){
        init();
        int fps = 60;
        double timePerTick = 1_000_000_000 / fps;
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();
        long timer = 0;
        int ticks = 0;
        while (running){
            now = System.nanoTime();
            delta += (now - lastTime) / timePerTick;
            timer += now - lastTime;
            lastTime = now;
            if (delta >= 1){
                tick();
                render();
                ticks++;
                delta--;
            }
            if (timer >= 1000000000){
                //System.out.println("FPS " + ticks);
                ticks = 0;
                timer = 0;
            }
        }
        stop();
    }

    public KeyManager getKeyManager(){
        return keyManager;
    }
    public State getGameState() { return gameState; }

    public String toString(){
        return " Width " + width + " Height " + height;
    }

    public static void main(String[] args) {
        Game game = new Game ("AYCM",720,540);
        System.out.println(game);

    }
}
