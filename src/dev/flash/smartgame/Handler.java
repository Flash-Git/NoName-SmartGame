package dev.flash.smartgame;

/**
 * Created by Flash on 17/10/2016.
 */
public class Handler {


    private Game game;
    private World world;

    public Handler(Game game){
        this.game = game;
    }


    //GETTERS AND SETTERS

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public World getWorld() {
        return world;
    }

    public void setWorld(World world) {
        this.world = world;
    }

}
