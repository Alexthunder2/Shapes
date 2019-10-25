package code;

import java.util.List;

public class Stack<T> {
    private List<T> array;

    public Stack(List<T> v) {
        array = v;
    }

    public boolean isEmpty() {
        return array.isEmpty();
    }

    public void add(T number) {
        array.add(number);
    }

    public T get() {
        return array.remove(array.size() - 1);
    }

    public int size() {
        return array.size();
    }
}
