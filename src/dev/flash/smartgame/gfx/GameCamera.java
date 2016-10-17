package dev.flash.smartgame.gfx;

import dev.flash.smartgame.Handler;

/**
 * Created by Flash on 17/10/2016.
 */
public class GameCamera {

    private Handler handler;
    private float xOffset, yOffset;

    public GameCamera(Handler handler, float xOffset, float yOffset){
        this.handler = handler;
        this.xOffset = xOffset;
        this.yOffset = yOffset;
    }

    public void checkBlankSpace(){

        int worldWidth = handler.getWorld().getWidth();
        int worldHeight = handler.getWorld().getHeight();

        if(xOffset < 0){
            xOffset = 0;
        }else if(xOffset > worldWidth * Tile.TILEWIDTH - handler.getWidth()){
            xOffset = worldWidth * Tile.TILEWIDTH - handler.getWidth();
        }
        if(yOffset < 0){
            yOffset = 0;
        }else if(yOffset > worldHeight * Tile.TILEWIDTH - handler.getHeight()){
            yOffset = worldHeight * Tile.TILEHEIGHT - handler.getHeight();
        }
    }


    public void centerOnEntity(Entity e){
        xOffset = e.getX() - handler.getWidth() / 2 + e.getWidth()/2;
        yOffset = e.getY() - handler.getHeight() / 2 + e.getHeight()/2;
        checkBlankSpace();
    }

    public void move(float xAmt, float yAmt){
        xOffset +=xAmt;
        yOffset +=yAmt;
        checkBlankSpace();
    }


    public float getxOffset() {
        return xOffset;
    }

    public void setxOffset(float xOffset) {
        this.xOffset = xOffset;
    }

    public float getyOffset() {
        return yOffset;
    }

    public void setyOffset(float yOffset) {
        this.yOffset = yOffset;
    }
}
