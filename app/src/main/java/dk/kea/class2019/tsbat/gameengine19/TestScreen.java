package dk.kea.class2019.tsbat.gameengine19;

import android.graphics.Bitmap;
import android.graphics.Color;

import java.util.Random;

public class TestScreen extends Screen
{
    public TestScreen(GameEngine gameEngine)
    {
        super(gameEngine);
        bitmap = gameEngine.loadBimap("bob.png");
    }

    int x = 0;
    int y = 0;
    Bitmap bitmap;
    Random rand = new Random();
    int color = 0;

    @Override
    public void update(float deltaTime)
    {
        if(gameEngine.isTouchDown(0))
        {
            x = gameEngine.getTouchX(0);
            y = gameEngine.getTouchX(0);
        }
        color = rand.nextInt();
        gameEngine.clearFrameBuffer(color);
//        gameEngine.drawBitmap(bitmap, x, y);
    }

    @Override
    public void pause()
    {

    }

    @Override
    public void resume()
    {

    }

    @Override
    public void dispose()
    {

    }
}
