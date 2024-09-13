package com.example.game;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.SurfaceView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class View extends SurfaceView implements Runnable {
    private Thread thread;
    private boolean isPlaying,isGameOver=false;
    private back_ground background1,background2;
    private int  screenX,screenY,an,am;
    public int score = 0;
    private Paint paint;
    private flight flight;
    private List<bullet> bullets;
    private Bird[] birds;
    private Random random;
    public static boolean Faruk = false;
    public static int scorevalue;

    public static float screenRatioX,screenRatioY;
    public View(Context context,int screenX,int screenY) {
        super(context);
        this.screenX=screenX;
        this.screenY = screenY;

        screenRatioX = 2160f/screenX;
        screenRatioY = 1080f/screenY;
        background1 = new back_ground(screenX,screenY,getResources());
        background2 = new back_ground(screenX,screenY,getResources());
        bullets = new ArrayList<>();
        background2.x=screenX;
        flight = new flight(this ,screenY,getResources());
        paint = new Paint();
        paint.setTextSize(120);
        paint.setColor(Color.BLACK);
        birds = new Bird[4];
        for(int i=0;i<4;i++)
        {
            Bird bird =new Bird(getResources());
            birds[i]=bird;
        }
        random = new Random();
    }

    @Override
    public void run()
    {
        while(isPlaying)
        {
            update();
            draw();
            sleep();
        }

    }

    private void update()
    {
        background1.x-=(int)(10*screenRatioX);
        background2.x-=(int)(10*screenRatioX);
        if(background1.x+background1.back.getWidth()<0)
        {
            background1.x=screenX;
        }

        if(background2.x+background2.back.getWidth()<0)
        {
            background2.x=screenX;
        }



        if(flight.upp)
        {
            flight.y -= (int) (19*screenRatioY);
        }else
        {
            flight.y +=(int)(19*screenRatioY);
        }
        if(flight.y<0)
        {
            flight.y=0;
        }
        if(flight.y>=screenY-flight.height)
        {
            //need modification
            flight.y = (screenY -flight.height)+5;

        }
        //bullet
        List<bullet> trash = new ArrayList<>();

        for(bullet bullet :bullets)
        {
            if(bullet.x >screenX)
            {
                trash.add(bullet);

            }
            bullet.x += (int)(50*screenRatioX) ;

            //bullet hit or not

            for(Bird bird :birds)
            {
                if(Rect.intersects(bird.getCollisionShape(),bullet.getCollisionShape()))
                {
                    score++;
                    bird.x=-500;
                    bullet.x = screenX+500;
                    bird.wasShot = true;
                }

            }

        }
        for(bullet bullet:trash)
        {
            bullets.remove(bullet);
        }


        //birds

        for(Bird bird :birds)
        {
            bird.x -=bird.speed;
            //speed change
            if(bird.x+bird.width<0)
            {

                if(!bird.wasShot)
                {
                    isGameOver = true;
                    return;
                }
                int bound = (int) (30*screenRatioX);
                bird.speed = random.nextInt(bound);

                if(bird.speed<(10*screenRatioX))
                {
                    bird.speed = (int) (10*screenRatioX);
                }
                bird.x = screenX;
                bird.y = random.nextInt(screenY - bird.height);
                bird.wasShot = false;


            }
            //hit or miss
            if(Rect.intersects(bird.getCollisionShape(),flight.getCollisionShape() )  )
            {
                isGameOver =true;
                //piyal
                Faruk = true;
                //piyal
                return;

            }




        }



    }
    private void sleep()
    {
        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    //piyal
    public static void setFaruk(boolean Faruk){
        View.Faruk = Faruk;
    }
    public static boolean getFaruk() {
        return Faruk;
    }

    public static void setscorevalue(int scorevalue){
        View.scorevalue = scorevalue;
    }
    public static int getscorevalue() {
        return scorevalue;
    }

    //Piyal
    private void draw()
    {
        if(getHolder().getSurface().isValid())
        {
            Canvas canvas = getHolder().lockCanvas();
            canvas.drawBitmap(background1.back,background1.x,background1.y,paint);
            canvas.drawBitmap(background2.back,background2.x,background2.y,paint);



            for(Bird bird : birds)
            {
                canvas.drawBitmap(bird.getBird(),bird.x,bird.y,paint);
            }
            canvas.drawText(score+"",screenX/2f,165,paint);
            //piyal
            setscorevalue(score);

            if(isGameOver)
            {
                isPlaying = false;
                //an = (screenX/2);
               // am = (screenY/2);
                // from easymode editted



                isGameOver =true;
                //piyal
                setFaruk(true);
                //piyal
                canvas.drawBitmap(flight.getDead(),750,150,paint);
                getHolder().unlockCanvasAndPost(canvas);


                //

                return;
            }




            //flight draw

            canvas.drawBitmap(flight.getFlight(),flight.x,flight.y,paint);


            //bullet draw
            for(bullet bullet : bullets)
            {
                canvas.drawBitmap(bullet.bullett,bullet.x,bullet.y,paint);
            }

            getHolder().unlockCanvasAndPost(canvas);


        }

        //piyal
        //setscorevalue(score);

    }

    public void pause()
    {
        try {
            isPlaying = false;
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    public void resume()
    {
        isPlaying =true;
        thread = new Thread(this);
        thread.start();

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction())
        {
            case MotionEvent.ACTION_DOWN:
                if(event.getX()<screenX/2)
                {
                    flight.upp = true;
                    flight.toShoot++;
                }
                break;

            case MotionEvent.ACTION_UP:
                flight.upp = false;
                break;
        }
        return true;

    }

    public void tobullet() {
        bullet bullet1 = new bullet(getResources());
        bullet1.x =flight.x+flight.width;
        bullet1.y =flight.y+(flight.height/2);
        bullets.add(bullet1);

    }
}
