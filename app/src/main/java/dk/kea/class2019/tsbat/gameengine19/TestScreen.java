package dk.kea.class2019.tsbat.gameengine19;

import android.graphics.Bitmap;
import android.graphics.Color;

public class TestScreen extends Screen
{
    public TestScreen(GameEngine gameEngine, int x, int y, Bitmap bitmap)
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
        gameEngine.drawBitmap(bitmap, x, y);
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
