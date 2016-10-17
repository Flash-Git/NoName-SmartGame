package dev.flash.smartgame.gfx;

import dev.flash.smartgame.Handler;
import dev.flash.smartgame.entities.Entity;

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

        if(xOffset < 0){
            xOffset = 0;
        }else if(xOffset > handler.getWorldWidth()  - handler.getScreenWidth()){
            xOffset = handler.getWorldWidth() - handler.getScreenWidth();
        }
        if(yOffset < 0){
            yOffset = 0;
        }else if(yOffset > handler.getWorldHeight() - handler.getScreenHeight()){
            yOffset = handler.getWorldHeight() - handler.getScreenHeight();
        }
    }

    public void centerOnEntity(Entity e){
        xOffset = e.getX() - handler.getScreenWidth() / 2 + e.getW()/2;
        yOffset = e.getY() - handler.getScreenHeight() / 2 + e.getH()/2;
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
