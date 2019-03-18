package dk.kea.class2019.tsbat.gameengine19;

import android.graphics.Bitmap;

public class MainMenuScreen extends Screen
{
    Bitmap mainMenu;
    Bitmap insertCoin;
    float passedTime = 0;
    long startTime;

    public MainMenuScreen(GameEngine gameEngine)
    {
        super(gameEngine);
        mainMenu = gameEngine.loadBitmap("mainmenu.png");
        insertCoin = gameEngine.loadBitmap("insertcoin.png");
        startTime = System.nanoTime();

    }

    @Override
    public void update(float deltaTime)
    {
        if (gameEngine.isTouchDown(0) && (passedTime) > 0.05f)
        {
            gameEngine.setScreen(new GameScreen(gameEngine));
            return;
        }
        gameEngine.drawBitmap(mainMenu, 0, 0);
        passedTime = passedTime + deltaTime;
        if ( (passedTime - (int)passedTime) > 0.5f )
        {
            gameEngine.drawBitmap(insertCoin, 160 - insertCoin.getWidth()/2, 320);
        }
    }

    @Override
    public void pause()
    {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {

    }
}
