package com.fattoucheinnovations.pharaohjump;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by Alex on 2016-01-08.
 */

public class GamePanel extends SurfaceView implements SurfaceHolder.Callback{

    private MainThread thread;
    public static final int WIDTH = 856;
    public static final int HEIGHT =480;
    public static final int MOVESPEED =-5;
    private Pharaoh pharaoh;
    private Background backer;


    public GamePanel(Context context){
        super(context);
        //this will allow us to read events pressed ie single tap double tap
        getHolder().addCallback(this);
        thread = new MainThread(getHolder(),this);

        setFocusable(true);

    }
    @Override
    public void surfaceChanged(SurfaceHolder holder,int format, int width,int height){

    }
    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        boolean retry=true;
        while(retry){
            try{thread.setRunning(false);
                thread.join();
            }catch (InterruptedException e){e.printStackTrace();}
            retry = false;
        }
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder){
        //now we can start the game
        backer = new Background(BitmapFactory.decodeResource(getResources(), R.drawable.grassbg1));
        pharaoh = new Pharaoh(BitmapFactory.decodeResource(getResources(), R.drawable.helicopter), 65, 25, 3);
        thread.setRunning(true);
        thread.start();
    }
    @Override
    public boolean onTouchEvent(MotionEvent event){
        if(event.getAction()==MotionEvent.ACTION_DOWN){
            if(!pharaoh.getPlaying()){
                pharaoh.setPlaying(true);
            }
            else{
                pharaoh.setUp(true);
            }
            return true;
        }
        if(event.getAction()==MotionEvent.ACTION_UP){
            pharaoh.setUp(false);
            return true;
        }
        return super.onTouchEvent(event);
    }
    public void update(){
        if(pharaoh.getPlaying()){
            pharaoh.update();
        }
    }

    public void trace(Canvas canvas){
        final float scaleFactorX=getWidth()/(WIDTH*1.f);
        final float scaleFactorY=getHeight() / (HEIGHT*1.f);
        if(canvas!=null){
            pharaoh.trace(canvas);
        }
    }

}
