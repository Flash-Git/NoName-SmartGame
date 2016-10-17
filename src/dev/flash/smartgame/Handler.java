package dev.flash.smartgame;

import dev.flash.smartgame.world.World;

/**
 * Created by Flash on 17/10/2016.
 */
public class Handler {

    private Game game;
    private World world;

    private int worldWidth;
    private int worldHeight;

    private int screenWidth;
    private int screenHeight;

    public Handler(Game game){
        setGame(game);
    }

    //GETTERS AND SETTERS

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
        screenWidth = game.getWidth();
        screenHeight = game.getHeight();
    }

    public World getWorld() {
        return world;
    }

    public void setWorld(World world) {
        this.world = world;
        worldWidth = world.getWidth();
        worldHeight = world.getHeight();
    }

    //USEFUL METHODS
    public int getWorldWidth() {
        return worldWidth;
    }

    public int getWorldHeight() {
        return worldHeight;
    }

    public int getScreenWidth() {
        return screenWidth;
    }

    public int getScreenHeight() {
        return screenHeight;
    }
}
