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

    @Override
    public void update(float deltaTime)
    {
        if(gameEngine.isTouchDown(0))
        {
            x = gameEngine.getTouchX(0);
            y = gameEngine.getTouchX(0);
        }
        gameEngine.clearFrameBuffer(Color.BLUE);
        gameEngine.drawBitmap(bitmap, 0, 0);
        gameEngine.drawBitmap(bitmap, 500, 500, 0, 0, 64, 64);
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
