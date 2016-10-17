package dev.flash.smartgame;

import dev.flash.smartgame.display.Display;
import dev.flash.smartgame.gfx.Assets;
import dev.flash.smartgame.gfx.GameCamera;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

/**
 * Created by Flash on 17/10/2016.
 */

public class Game implements Runnable{
    //display handles JFrame
    private Display display;
    private BufferStrategy bs;
    private Graphics g;

    //Game
    private int width, height;
    private String title;
    private boolean running;
    private Thread thread;
    private Handler handler;
    private GameCamera gameCamera;

    public static int FPS;


    public Game(String title, int width, int height){
        this.title = title;
        this.width = width;
        this.height = height;
    }

    private void init(){
        handler = new Handler(this);

        //Create window
        display = new Display(title, width, height);
        //display.getFrame().addKeyListener(keyManager);
        //display.getFrame().addMouseListener(mouseManager);
        //display.getFrame().addMouseMotionListener(mouseManager);
        //display.getCanvas().addMouseListener(mouseManager);
        //display.getCanvas().addMouseMotionListener(mouseManager);

        //Load the game's assets
        Assets.init();

        gameCamera = new GameCamera(handler, 0, 0);

        //Setting up the program's States
        //menuState = new MenuState(handler);
        //ingameState = new GameState(handler);
        //State.setState(menuState);
    }

    private void tick(long deltaTime){

    }

    private void render(){
        //Draw frames before displaying them
        bs = display.getCanvas().getBufferStrategy();
        if(bs == null){
            display.getCanvas().createBufferStrategy(2);//amount of stored up frames ready before pushing to screen
            return;
        }
        g = bs.getDrawGraphics();

        //Clear Screen
        g.clearRect(0, 0, width, height);

        //Draw Here
        //if(State.getState() != null){
        //    State.getState().render(g);
        //}

        //End Draw
        bs.show();
        g.dispose();
    }

    @Override
    public void run(){
        init();
        int targetFps = 144;
        double timePerTick = 1000000000/targetFps;
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();
        long timer = 0;
        int ticks = 0;
        long deltaTime;//better to have this be a long that converts to int or pass a long into tick()?
        long deltaLastTime = System.nanoTime();;
        long deltaNow;

        while(running){
            now = System.nanoTime();
            timer += now-lastTime;
            delta += (now - lastTime)/timePerTick;

            lastTime = now;

            if(delta>=1){//this should avoid lost or gained frames from speeding up or slowing down the game
                deltaNow = System.nanoTime();
                deltaTime = deltaNow-deltaLastTime;

                tick(deltaTime/1000000);//converts nano to milli
                render();
                ticks++;
                delta--;
                deltaLastTime = deltaNow;
            }

            if(timer>=1000000000){
                System.out.println("Ticks and Frames: " + ticks);
                FPS = ticks;
                ticks = 0;
                timer = 0;
            }
        }
        stop();
    }

    //Creates the thread
    public synchronized void start(){
        if(running==true){
            return;
        }
        running = true;
        thread = new Thread(this);
        thread.start();
    }

    //Stops the code cleanly
    public synchronized void stop(){
        if(!running){
            return;
        }
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {//Does not change display
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {//Does not change display
        this.height = height;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
