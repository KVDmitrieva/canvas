package com.example.kated.myapplication;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

public class Ball {
    float x = 20, y=20, rad = 50;
    private float vX = 0;
    private float vY = 0;
    private float velocity = 1;
    int rand=(int)(Math.random()*5);

    void bigger(){
        rad=rad+10;
    }


    void setcol(Paint paint){
        switch (rand) {
            case 1:
                paint.setColor(Color.RED);
                break;
            case 2:
                paint.setColor(Color.BLUE);
                break;
            case 3:
                paint.setColor(Color.GREEN);
                break;
            case 4:
                paint.setColor(Color.YELLOW);
                break;
            default:
                paint.setColor(Color.BLACK);
        }
    }
        void setVec(MotionEvent event){
            float corX = event.getX();
            float corY = event.getY();
            float vx = corX-x;
           float vy =corY-y;
            float len = (float)Math.sqrt(vx*vx+vy*vy);
            vX = vx/len;
            vY = vy/len;
            if (corX<x+rad && corX>x-rad && corY<y+rad && corY>y-rad) bigger();
        }

    void move(){
        x += vX * velocity;
        y += vY * velocity;
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    protected void onDraw(Canvas canvas) {
        Paint paint = new Paint();
        setcol(paint);
        canvas.drawCircle(x,y,rad,paint);
    }
}
