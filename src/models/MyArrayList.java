package models;

import models.interfaces.MyList;

import java.util.Iterator;

public class MyArrayList<T> implements MyList<T> {
    private Object[] elements;
    private int length;

    public MyArrayList() {
        elements = (T[]) new Object[10];
        length = 0;
    }


    @Override
    public void add(T item) {
        if (length == elements.length) {
            increaseBuffer();
        }
        elements[length++] = item;
    }

    @Override
    public void set(int index, T item) {
        checkIndex(index);
        elements[index] = item;
    }

    @Override
    public void add(int index, T item) {
        checkIndex(index);
        if (length == elements.length) {
            increaseBuffer();
        }

        shiftR(index);
        elements[index] = item;
    }

    @Override
    public void addFirst(T item) {
        add(0, item);
    }

    @Override
    public void addLast(T item) {
        add(item);
    }

    @Override
    public T get(int index){
        checkIndex(index);
        return (T) elements[index];  //downcasting
    }

    @Override
    public T getFirst() {
        checkIndex(0);
        return (T) elements[0];
    }

    @Override
    public T getLast() {
        checkIndex(length - 1);
        return (T) elements[length - 1];
    }

    @Override
    public void remove(int index){
        checkIndex(index);
        for(int i = index; i < length - 1; i++){
            elements[i] = elements[i+1];
        }
        length--;
    }

    @Override
    public void removeFirst() {
        remove(0);
    }

    @Override
    public void removeLast() {
        remove(length - 1);
    }

    @Override
    public void sort() {


    }

    @Override
    public int indexOf(Object object) {
        return findIndexOfElement(object);
    }

    @Override
    public int lastIndexOf(Object object) {
        return findLastIndexOfElement(object);
    }

    @Override
    public boolean exists(Object object) {
        for (int i = 0; i < length; i++) {
            if (object.equals(elements[i])) {

                return true;
            }
        }

        return false;
    }

    @Override
    public Object[] toArray() {
        Object[] result = new Object[length];
        for (int i = 0; i < length; i++) {
            result[i] = elements[i];
        }

        return result;
    }

    @Override
    public void clear(){
        elements = new Object[5];
        length = 0;
    }

    @Override
    public int size() {
        return length;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < length;
            }

            @Override
            public T next() {
                return (T) elements[index++];
            }
        };
    }


    //============================================================================

    private void increaseBuffer() {
        Object[] newElements = new Object[length *2];
        for(int i = 0; i < elements.length; i++){
            newElements[i] = elements[i];
        }
        elements = newElements;
    }

    private void checkIndex(int index) {
        if(index < 0 || index >= length){
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + length);
        }
    }

    private void shiftR(int index) {
        for (int i = length - 1; i >= index; i--) {
            elements[i+1] = elements[i];
        }
    }

    private int findIndexOfElement(Object element) {
        for (int i = 0; i < length; i++) {
            if (elements[i].equals(element)) {

                return i;
            }
        }

        return -1;
    }

    private int findLastIndexOfElement(Object element) {
        int index = -1;
        for (int i = 0; i < length; i++) {
            if (elements[i].equals(element)) {
                index = i;
            }
        }

        return index;
    }

}
