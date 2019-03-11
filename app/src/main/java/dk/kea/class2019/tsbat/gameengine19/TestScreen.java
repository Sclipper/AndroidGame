package dk.kea.class2019.tsbat.gameengine19;

import android.graphics.Bitmap;
import android.graphics.Color;

import java.util.Random;

public class TestScreen extends Screen
{
    int x = 0;
    int y = 240;
    Bitmap bitmap;
    Sound sound;
    Music backgroundMuisc;
    boolean isPlaying = false;

    public TestScreen(GameEngine gameEngine)
    {
        super(gameEngine);
        bitmap = gameEngine.loadBimap("bob.png");
        sound = gameEngine.loadSound("blocksplosion.wav");
        backgroundMuisc = gameEngine.loadMusic("music.ogg");
        isPlaying = true;

    }

    @Override
    public void update(float deltaTime)
    {
        gameEngine.clearFrameBuffer(Color.RED);

        x += 25;
        if (x > 320 + bitmap.getWidth()) x = 0 - bitmap.getWidth();

        if(gameEngine.isTouchDown(0))
        {
            x = gameEngine.getTouchX(0);
            y = gameEngine.getTouchY(0);
            sound.play(1);

            if(backgroundMuisc.isPlaying())
            {
                backgroundMuisc.pause();
                isPlaying = false;
            }
            else
            {
                backgroundMuisc.play();
                isPlaying = true;
            }
        }
//        float x = gameEngine.getAccelerometer()[0];
//        float y = gameEngine.getAccelerometer()[1];
//        x = gameEngine.getFramebufferWidth() / 2 + ((x/10) * gameEngine.getFramebufferWidth() /2);
//        y = gameEngine.getFramebufferHeight() / 2 + ((y/10) * gameEngine.getFramebufferHeight() /2);


        gameEngine.drawBitmap(bitmap, (int)x - 64, (int)y - 64);
//        gameEngine.drawBitmap(bitmap, 500, 500, 0, 0, 64, 64);
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
