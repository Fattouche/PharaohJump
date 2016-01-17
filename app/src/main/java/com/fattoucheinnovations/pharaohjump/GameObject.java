package com.fattoucheinnovations.pharaohjump;

import android.graphics.Rect;

/**
 * Created by Alex on 2016-01-10.
 */
public abstract class GameObject {
    //all objects in the game will have the attributes
    protected int x,y,dy,dx,width,height;

    public void setX(int x){
        this.x=x;
    }
    public void setY(int y){
        this.y=y;
    }

    public int getX() {
        return x;
    }
    public int getY(){
        return y;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth(){
        return width;
    }

    public Rect getRectangle(){
        return new Rect(x,y,x+width,y+height);
    }

}
