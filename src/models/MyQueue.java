package models;

import models.interfaces.IMyQueue;
import models.interfaces.MyList;

public class MyQueue<T> implements IMyQueue<T> {
    private final MyList<T> list;

    public MyQueue(MyList<T> list) {
        this.list = list;
    }


    @Override
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }

        return list.getFirst();
    }

    @Override
    public T enqueue(T element) {
        list.add(element);
        return element;
    }

    @Override
    public T dequeue() {
        if (isEmpty()){
            throw new IllegalStateException("Queue is empty");
        }

        T first = list.getFirst();
        list.removeFirst();
        return first;
    }

    @Override
    public boolean isEmpty() {
        return list.size() == 0;
    }

    @Override
    public int size() {
        return list.size();
    }
}
