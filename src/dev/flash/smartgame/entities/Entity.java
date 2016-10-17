package dev.flash.smartgame.entities;

import java.awt.Point;

/**
 * Created by Flash on 17/10/2016.
 */
public class Entity {

    protected int x;
    protected int y;
    protected int w;
    protected int h;
    protected Point center;

    public Entity(){

    }

    //GETTERS AND SETTERS
    public Point getCenter(){
        center.setLocation(x + w/2, y + h/2);
        return center;
    }

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
