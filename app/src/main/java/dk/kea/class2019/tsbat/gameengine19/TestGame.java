package dk.kea.class2019.tsbat.gameengine19;

public class TestGame extends GameEngine
{

    @Override
    public Screen createStartScreen()
    {
        return new TestScreen(this);
    }
}
