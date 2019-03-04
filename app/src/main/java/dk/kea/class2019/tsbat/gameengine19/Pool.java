package dk.kea.class2019.tsbat.gameengine19;

import java.util.ArrayList;
import java.util.List;

public abstract class Pool<T>
{
    private List<T> items = new ArrayList<>();

    protected abstract T newItem();

    public T obtains()
    {
        int size = items.size();
        if (size == 0)
        {
            return newItem();
        }
        return items.remove(size - 1);
    }

    public void free(T item)
    {
        items.add(item);
    }
}
