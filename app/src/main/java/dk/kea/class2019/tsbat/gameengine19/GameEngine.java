package dk.kea.class2019.tsbat.gameengine19;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.Window;
import android.view.WindowManager;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public abstract class GameEngine extends AppCompatActivity implements Runnable {

    private Thread mainLoopThread;
    private State state = State.Paused;
    private List<State> stateChanges = new ArrayList<>();
    private SurfaceView surfaceView;
    private SurfaceHolder surfaceHolder;
    private Canvas canvas = null;
    private Screen screen = null;

    public abstract Screen createStartScreen();

    public void setScreen(Screen screen){}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().addFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN |
                        WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        surfaceView = new SurfaceView(this);
        setContentView(surfaceView);
        surfaceHolder = surfaceView.getHolder();
        screen = createStartScreen();
    }

    public Bitmap loadBimap(String fileName)
    {
        InputStream in = null;
        Bitmap bitmap = null;
        try
        {
            in = getAssets().open(fileName);
            bitmap = BitmapFactory.decodeStream(in);
            if(bitmap == null)
            {
                throw new RuntimeException("Couldnt load bitmap from file" + fileName);
            }
            return bitmap;
        }
        catch (IOException ioe)
        {
            throw new RuntimeException("Couldnt load bitmap from assests" + fileName);
        }
        finally
        {
            if(in != null)
            {
                try
                {
                    in.close();
                }
                catch (IOException ioe)
                {
                    throw new RuntimeException("Could not close the file");
                }
            }
        }
    }

    public void clearFrameBuffer(int color)
    {
        canvas.drawColor(Color.BLUE);
    }

    public void drawBitmap(Bitmap bitmap, int x, int y)
    {
        if(canvas != null)
        {
            canvas.drawBitmap(bitmap, x, y, null);
        }
    }

    public boolean isTouchDown(int pointer)
    {


        // Todo: Change return statement
        return false;
    }

    public int getTouchX(int pointer)
    {
        return 0;
    }

    public int getTouchY(int pointer)
    {
        return 0;
    }

    public void run()
    {
        while(true)
        {
            synchronized(stateChanges)
            {
                for(int i = 0; i < stateChanges.size(); i++ )
                {
                    state = stateChanges.get(i);
                    if(state == State.Disposed)
                    {
                        Log.d("GameEngine", "state changed to Disposed");
                        return;
                    }
                    if(state == State.Paused)
                    {
                        Log.d("GameEngine", "state changed to Paused");
                        return;
                    }
                    if(state == State.Resumed)
                    {
                        Log.d("GameEngine", "state changed to Resumed");
                        state = State.Running;
                    }
                } // end of for
                stateChanges.clear();

                if(state == State.Running)
                {
                    Log.d("Game Engine", "is Running");
                   if (!surfaceHolder.getSurface().isValid())
                   {
                       continue;
                   }
                    Log.d("Game Engine", "is Running After continue");
                    canvas = surfaceHolder.lockCanvas();
                   // drawing happens here
//                    canvas.drawColor(Color.BLUE);
                    if(screen != null) screen.update(0);
                    surfaceHolder.unlockCanvasAndPost(canvas);
                }

            }  //end of synchronised
        }  // end of while
    } // my teacher is a moron

    public void onPause()
    {
        super.onPause();
        synchronized (stateChanges)
        {
            if(isFinishing())
            {
                stateChanges.add(stateChanges.size(), State.Disposed);
            }
            else
            {
                stateChanges.add(stateChanges.size(), State.Paused);
            }
        }
    }

    public void onResume()
    {
        super.onResume();
        mainLoopThread = new Thread(this);
        mainLoopThread.start();
        synchronized (stateChanges)
        {
            stateChanges.add(stateChanges.size(), State.Resumed);
        }
    }
}
