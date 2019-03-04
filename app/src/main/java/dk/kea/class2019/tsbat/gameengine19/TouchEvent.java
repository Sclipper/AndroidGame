package dk.kea.class2019.tsbat.gameengine19;

public class TouchEvent
{
    public enum TouchEventType
    {
        Down,
        Up,
        Dragged
    }
    public TouchEventType type; // the type of event
    public int x;
    public int y;
    public int pointer;
}
