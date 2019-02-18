package dk.kea.class2019.tsbat.gameengine19;

public abstract class Screen
{
    protected final GameEngine gameEngine;

    public Screen(GameEngine gameEngine)
    {
        this.gameEngine = gameEngine;
    }

    public abstract void update(float deltaTime);
    public abstract void pause();
    public abstract void resume();
    public abstract void dispose();
}
