package dk.kea.class2019.tsbat.gameengine19;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import java.util.ArrayList;
import java.util.List;

public abstract class GameEngine extends AppCompatActivity {

    private Thread mainLoopThread;
    private State state = State.Paused;
    private List<State> stateChanges = new ArrayList<>();
    

    public abstract Screen createStartScreen();

    public void setScreen(Screen screen)
    {

    }

    public Bitmap loadBimap(String fileName)
    {
        return null;
    }

    public void clearFrameBuffer(int color)
    {

    }

    public void drawBitmap(Bitmap bitmap, int x, int y)
    {

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().addFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN |
                WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
    }

    public void onPause()
    {
        super.onPause();
    }

    public void onResume()
    {
        super.onResume();
    }
}
