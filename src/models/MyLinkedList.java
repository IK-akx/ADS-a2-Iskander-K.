package models;

import models.interfaces.MyList;

import java.util.Iterator;

public class MyLinkedList<T> implements MyList<T> {
    private MyNode<T> head;
    private MyNode<T> tail;
    private int length;

    public MyLinkedList() {
        head = null;
        tail = null;
        length = 0;
    }

    @Override
    public void add(T item) {
        addLast(item);
    }

    @Override
    public void set(int index, T item) {
        checkIndex(index);
        getNode(index).setElement(item);
    }

    @Override
    public void add(int index, T item) {
        if (index < 0 || index > length) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            addFirst(item);
        } else if (index == length) {
            addLast(item);
        } else {
            MyNode<T> current = getNode(index);
            MyNode<T> newNode = new MyNode<>(item);
            MyNode<T> prev = current.getPrevious();

            newNode.setPrevious(prev);
            newNode.setNext(current);

            prev.setNext(newNode);
            current.setPrevious(newNode);
            length++;
        }
    }

    @Override
    public void addFirst(T item) {
        MyNode<T> newNode = new MyNode<>(item);
        if (length == 0) {
            head = tail = newNode;
        } else {
            newNode.setNext(head);
            head.setPrevious(newNode);
            head = newNode;
        }
        length++;
    }

    @Override
    public void addLast(T item) {
        MyNode<T> newNode = new MyNode<>(item);
        if (length == 0) {
            head = tail = newNode;
        } else {
            newNode.setPrevious(tail);
            tail.setNext(newNode);
            tail = newNode;
        }
        length++;
    }

    @Override
    public T get(int index) {
        checkIndex(index);
        return getNode(index).getElement();
    }

    @Override
    public T getFirst() {
        if (length == 0) {
            throw new IllegalStateException("List is empty");
        }

        return head.getElement();
    }

    @Override
    public T getLast() {
        if (length == 0) throw new IllegalStateException("List is empty");
        return tail.getElement();
    }

    @Override
    public void remove(int index) {
        checkIndex(index);
        removeNode(getNode(index));
    }

    @Override
    public void removeFirst() {
        if (length == 0) throw new IllegalStateException("List is empty");
        removeNode(head);
    }

    @Override
    public void removeLast() {
        if (length == 0) throw new IllegalStateException("List is empty");
        removeNode(tail);
    }

    private void removeNode(MyNode<T> node) {
        if (node.getPrevious() != null) {
            node.getPrevious().setNext(node.getNext());
        } else {
            head = node.getNext();
        }

        if (node.getNext() != null) {
            node.getNext().setPrevious(node.getPrevious());
        } else {
            tail = node.getPrevious();
        }

        length--;
    }


    @Override
    public void sort() {
        Object[] array = toArray();
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                Comparable<T> a = (Comparable<T>) array[j];
                T b = (T) array[j + 1];
                if (a.compareTo(b) > 0) {
                    Object temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        clear();
        for (Object o : array) add((T) o);
    }

    @Override
    public int indexOf(Object object) {
        int index = 0;
        for (MyNode<T> current = head; current != null; current = current.getNext()) {
            if (current.getElement().equals(object)) return index;
            index++;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object object) {
        int index = length - 1;
        for (MyNode<T> current = tail; current != null; current = current.getPrevious()) {
            if (current.getElement().equals(object)) return index;
            index--;
        }
        return -1;
    }

    @Override
    public boolean exists(Object object) {
        return indexOf(object) != -1;
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[length];
        int i = 0;
        for (MyNode<T> current = head; current != null; current = current.getNext()) {
            array[i++] = current.getElement();
        }
        return array;
    }

    @Override
    public void clear() {
        head = tail = null;
        length = 0;
    }

    @Override
    public int size() {
        return length;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= length) {
            throw new IndexOutOfBoundsException("Index: " + index);
        }
    }

    private MyNode<T> getNode(int index) {
        checkIndex(index);
        MyNode<T> current;
        if (index < length / 2) {
            current = head;
            for (int i = 0; i < index; i++){
                current = current.getNext();
            }
        } else {
            current = tail;
            for (int i = length - 1; i > index; i--) {
                current = current.getPrevious();
            }
        }
        return current;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private MyNode<T> current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                T value = current.getElement();
                current = current.getNext();
                return value;
            }
        };
    }
}