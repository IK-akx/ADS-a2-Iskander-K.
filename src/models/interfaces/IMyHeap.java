package models.interfaces;

public interface IMyHeap<T> {
    T getExtremum();
    T extractExtremum();
    void insert(T element);
    boolean isEmpty();
    int size();
}