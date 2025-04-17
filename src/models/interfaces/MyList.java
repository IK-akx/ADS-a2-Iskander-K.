package models.interfaces;

/**
 * The MyList<T> interface defines a custom list structure with common operations.
 *
 * @param <T> the type of elements stored in the list
 */
public interface MyList<T> extends Iterable<T> {

    /**
     * Adds an item to the end of the list.
     *
     * @param item the item to add
     */
    void add(T item);

    /**
     * Replaces the element at the specified index with the given item.
     *
     * @param index the index of the element to replace
     * @param item the new item to set
     */
    void set(int index, T item);

    /**
     * Inserts an item at the specified index.
     *
     * @param index the index at which the item should be inserted
     * @param item the item to insert
     */
    void add(int index, T item);

    /**
     * Adds an item to the beginning of the list.
     *
     * @param item the item to add
     */
    void addFirst(T item);

    /**
     * Adds an item to the end of the list.
     *
     * @param item the item to add
     */
    void addLast(T item);

    /**
     * Returns the item at the specified index.
     *
     * @param index the index of the item to retrieve
     * @return the item at the given index
     */
    T get(int index);

    /**
     * Returns the first item in the list.
     *
     * @return the first item
     */
    T getFirst();

    /**
     * Returns the last item in the list.
     *
     * @return the last item
     */
    T getLast();

    /**
     * Removes the item at the specified index.
     *
     * @param index the index of the item to remove
     */
    void remove(int index);

    /**
     * Removes the first item in the list.
     */
    void removeFirst();

    /**
     * Removes the last item in the list.
     */
    void removeLast();

    /**
     * Sorts the list elements.
     */
    void sort();

    /**
     * Returns the index of the first occurrence of the specified object.
     *
     * @param object the object to search for
     * @return the index of the first occurrence, or -1 if not found
     */
    int indexOf(Object object);

    /**
     * Returns the index of the last occurrence of the specified object.
     *
     * @param object the object to search for
     * @return the index of the last occurrence, or -1 if not found
     */
    int lastIndexOf(Object object);

    /**
     * Checks if the list contains the specified object.
     *
     * @param object the object to check
     * @return true if the object exists in the list, false otherwise
     */
    boolean exists(Object object);

    /**
     * Returns an array containing all elements in the list.
     *
     * @return an array of all list elements
     */
    Object[] toArray();

    /**
     * Removes all elements from the list.
     */
    void clear();

    /**
     * Returns the number of elements in the list.
     *
     * @return the size of the list
     */
    int size();
}
