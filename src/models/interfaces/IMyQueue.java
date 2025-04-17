package models.interfaces;


public interface IMyQueue<T> {
    T peek();
    T enqueue(T element);
    T dequeue();
    boolean isEmpty();
    int size();
}