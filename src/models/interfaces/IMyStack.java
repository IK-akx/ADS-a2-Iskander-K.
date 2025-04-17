package models.interfaces;


public interface IMyStack<T> {
    T peek();
    T push(T element);
    T pop();
    boolean isEmpty();
    int size();
}