package models;

public class MyNode<T> {
    private T element;
    private MyNode<T> next;
    private MyNode<T> previous;

    public MyNode(T element) {
        this.element = element;
    }

    public void setElement(T element) {
        this.element = element;
    }

    public T getElement() {
        return element;
    }

    public boolean hasNext() {
        return next != null;
    }

    public boolean hasPrevious() {
        return previous != null;
    }

    public void setNext(MyNode<T> next) {
        this.next = next;
    }

    public MyNode<T> getNext() {
        return next;
    }

    public void setPrevious(MyNode<T> previous) {
        this.previous = previous;
    }

    public MyNode<T> getPrevious() {
        return previous;
    }
}