package dev.flash.smartgame.entities;

/**
 * Created by Flash on 17/10/2016.
 */
public class Entity {

    protected int x;
    protected int y;
    protected int w;
    protected int h;

    public Entity(){

    }

    //GETTERS AND SETTERS

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }
}
