package dk.kea.class2019.tsbat.gameengine19;

import android.graphics.Bitmap;

public class WorldRenderer
{
    GameEngine gameEngine;
    World world;
    Bitmap ballImage;
    Bitmap paddleImage;

    public WorldRenderer(GameEngine gameEngine, World world)
    {
         this.gameEngine = gameEngine;
         this.world = world;
         ballImage = gameEngine.loadBitmap("ball.png");
         paddleImage = gameEngine.loadBitmap("paddle.png");
    }

    public void render()
    {
        gameEngine.drawBitmap(ballImage, (int)world.ball.x, (int)world.ball.y);
        gameEngine.drawBitmap(paddleImage, (int)world.paddle.x, (int)world.paddle.y);
    }
}
