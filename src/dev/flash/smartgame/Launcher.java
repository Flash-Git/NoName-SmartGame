package dev.flash.smartgame;

/**
 * Created by Flash on 17/10/2016.
 */

public class Launcher {
    public static void main(String[] args) {
        Game game = new Game("Smart Game", 1100, 600);
        game.start();
    }
}
