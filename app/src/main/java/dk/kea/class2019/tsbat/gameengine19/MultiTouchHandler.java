package dk.kea.class2019.tsbat.gameengine19;

import android.view.MotionEvent;
import android.view.View;

public class MultiTouchHandler implements TouchHandler, View.OnTouchListener
{
    private boolean[] isTouched = new boolean[20]; // store the first 20 touches
    private int[] touchX = new int[20];
    private int[] touchY = new int[20];

    private List<TouchEvent> toucheventBuffer;
    private TouchEventPool touchEventPool;


    @Override
    public boolean isTouchDown(int pointer)
    {
        return false;
    }

    @Override
    public int getTouchX(int pointer)
    {
        return 0;
    }

    @Override
    public int getTouchY(int pointer)
    {
        return 0;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event)
    {
        return false;
    }
}
