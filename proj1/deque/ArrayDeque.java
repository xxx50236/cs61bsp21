package deque;

import java.util.Objects;

public class ArrayDeque<T> {
    private T[] items;
    private int size = 0;
    private int nextFirst = 3;
    private int nextLast = 4;

    private final int START_SIZE = 8;
    private final int FACTOR = 2;
    private final double usageRatio = 0.04;

    public ArrayDeque() {
        items = (T[]) new Object[START_SIZE];
    }

    public void addFirst(T item) {
        if (size == items.length) {
            resize(size * FACTOR);
        }
        size++;
        items[nextFirst--] = item;
        nextFirst = nextFirst < 0 ? (items.length - 1) : nextFirst;
    }

    public void addLast(T item) {
        if (size == items.length) {
            resize(size * FACTOR);
        }
        size++;
        items[nextLast++] = item;
        nextLast = nextLast % items.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public double usageRatio() { return (double)size / items.length; }

    public void printDeque() {
        if(isEmpty()) {
            return;
        }

        T first = items[0];
        String delimiter = " ";
        StringBuilder result = new StringBuilder();
        result.append(first);
        for (int i = 1; i < items.length; i++) {
            Object item = Objects.requireNonNullElse(items[i], "null");
            result.append(delimiter);
            result.append(item);
        }
        System.out.println(result);
    }

    public T removeFirst() {
        if(isEmpty()) {
            return null;
        }

        nextFirst = (nextFirst + 1) % items.length;
        T item = items[nextFirst];
        size--;

        if (usageRatio() <= usageRatio) {
            resize(items.length / 2);
        }

        return item;
    }

    public T removeLast() {
        if(isEmpty()) {
            return null;
        }

        nextLast = nextLast - 1 < 0 ? items.length - 1 : nextLast - 1;
        T item = items[nextLast];
        size--;

        if (usageRatio() <= usageRatio) {
            resize(items.length / 2);
        }

        return item;
    }
    public T get(int index) {
        if(index < 0 && index >= size) {
            return null;
        }

        int actualIndex = (nextFirst + 1 + index) % items.length;
        return items[actualIndex];
    }
    private void resize(int capacity) {
        T[] a = (T[])new Object[capacity];
        int first = (capacity - size) / 2;
        int last = first + 1;

        for (int i = 0; i < size; i++) {
            last = last % capacity;
            a[last++] = get(i);
        }
        nextFirst = first;
        nextLast = last;
        items = a;
    }

}
