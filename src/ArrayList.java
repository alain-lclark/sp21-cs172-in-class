import java.util.Iterator;

public class ArrayList<E> implements List<E> {

    private int capacity;
    private int length;
    private E[] data;

    public ArrayList() {
        capacity = 1;
        length = 0;
        data = (E[])new Object[capacity];
    }

    public void add(E item) {
        if (length >= capacity) resize();
        assert length < capacity;
        data[length++] = item;
    }

    private void resize() {
        int newCapacity = capacity * 2;
        E[] newData = (E[])new Object[newCapacity];
        for (int i = 0; i < length; ++i)
            newData[i] = data[i];
        capacity = newCapacity;
        data = newData;
    }

    public E get(int index) {
        return data[index];
    }

    public void removeAt(int index) {

    }

    public int length() {
        return length;
    }

    public Iterator<E> iterator() {
        return null;
    }
}
