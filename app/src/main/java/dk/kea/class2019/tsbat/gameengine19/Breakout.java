package dk.kea.class2019.tsbat.gameengine19;

import dk.kea.class2019.tsbat.gameengine19.Screen;

public class Breakout extends GameEngine
{

    @Override
    public Screen createStartScreen() {
        return new MainMenuScreen(this);

    }
}
