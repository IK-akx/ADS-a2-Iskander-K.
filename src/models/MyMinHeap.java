package models;

import models.interfaces.IMyHeap;
import models.interfaces.MyList;


public class MyMinHeap<T extends Comparable<T>> implements IMyHeap<T> {
    private final MyList<T> list;

    public MyMinHeap(MyList<T> list) {
        this.list = list;
    }


    @Override
    public T getExtremum() {
        if (isEmpty()){
            throw new IllegalStateException("Heap is empty");
        }

        return list.get(0);
    }

    @Override
    public T extractExtremum() {
        if (isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }

        T min = list.get(0);
        T last = list.getLast();

        list.set(0, last);
        list.removeLast();

        heapifyDown(0);
        return min;
    }

    @Override
    public void insert(T element) {
        list.add(element);
        heapifyUp(list.size() - 1);

    }

    @Override
    public boolean isEmpty() {
        return list.size() == 0;
    }

    @Override
    public int size() {
        return list.size();
    }

    private void heapifyUp(int index) {
        while (index > 0) {
            int parentIndex = (index - 1) / 2;
            T current = list.get(index);
            T parent = list.get(parentIndex);

            if (current.compareTo(parent) < 0) {
                swap(index, parentIndex);
                index = parentIndex;
            } else {
                break;
            }
        }
    }

    private void heapifyDown(int index) {
        int size = list.size();

        while (index < size) {
            int left = 2 * index + 1;
            int right = 2 * index + 2;
            int smallest = index;

            if (left < size && list.get(left).compareTo(list.get(smallest)) < 0) {
                smallest = left;
            }
            if (right < size && list.get(right).compareTo(list.get(smallest)) < 0) {
                smallest = right;
            }

            if (smallest != index) {
                swap(index, smallest);
                index = smallest;
            } else {
                break;
            }
        }
    }

    private void swap(int i, int j) {
        T temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }
}
