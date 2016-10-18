package dev.flash.smartgame.entities;

import java.awt.Point;

/**
 * Created by Flash on 17/10/2016.
 */
public class Entity {

    protected float x;
    protected float y;
    protected float w;
    protected float h;
    protected Point center;

    public Entity(){

    }

    //GETTERS AND SETTERS
    public Point getCenter(){
        center.setLocation(x + w/2, y + h/2);
        return center;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
    }

    public float getH() {
        return h;
    }

    public void setH(float h) {
        this.h = h;
    }
}
