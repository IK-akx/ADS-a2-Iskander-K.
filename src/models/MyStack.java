package models;

import models.interfaces.IMyStack;
import models.interfaces.MyList;

public class MyStack<T> implements IMyStack<T> {
    private final MyList<T> list;

    public MyStack(MyList<T> list) {
        this.list = list;
    }


    @Override
    public T peek() {
        if(isEmpty()){
            throw new IllegalStateException("Stack is empty");
        }

        return list.getLast();
    }

    @Override
    public T push(T element) {
        list.addLast(element);
        return element;
    }

    @Override
    public T pop() {
        if(isEmpty()){
            throw new IllegalStateException("Stack is empty");
        }

        T top = list.getLast();
        list.removeLast();
        return top;
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
