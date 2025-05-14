package generics;

// extends apply interface as constraints
// "&" for multiple interfaces
public class GenericList<T extends Comparable> {
    private T[] items = (T[]) new Object[10];
    private int count;

    public void add(T item) {
        items[count++] = item;
    }

    public T get(int index) {
        return items[index];
    }
}
