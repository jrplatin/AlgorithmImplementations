import java.util.Iterator;

public interface LinkedList<E> extends Iterable<E> {
    
	 /**
     * Appends the specified element to the end of this list.
     * @param elt the element to append
     * @return this {@code LinkedList}
     */
    public LinkedList<E> add(E elt);

    /**
     * Adds all the elements in the input list to the end of this list.
     * @param list the list to append
     * @return this {@code LinkedList}
     */
    public LinkedList<E> concatenate(LinkedList<E> list);

    /**
     * Truncates the list into two lists at the specified index and returns the
     * list that was truncated off. The original list should no longer contain
     * the elements that were truncated off.
     * @param index the index of the head of the list to truncate
     * @return the second of the two new lists (what was truncated off)
     * @throws IndexOutOfBoundsException if the index is out of range
     *         i.e. <tt>(index < 0 || index >= size())</tt>
     */
    public LinkedList<E> truncate(int index);

    /**
     * Returns the element at the specified position in this list.
     * @param index the index of the element to return
     * @return the element at the specified position in this list
     * @throws IndexOutOfBoundsException If the index is out of range
     *         i.e. <tt>(index < 0 || index >= size())</tt>
     */
    public E get(int index);

    /**
     * Returns the head node of this linked list.
     */
    public LinkedListNode<E> getHeadNode();

    /**
     * Returns {@code true} if the list contains the specified element,
     * otherwise returns {@code false}.
     * @param elt the element whose presence is to be checked
     * @return {@code true} if this list contains the specified element
     */
    public boolean contains(E elt);

    /**
     * Returns the size of this list.
     * @return the number of elements in this list
     */
    public int size();

    /**
     * Removes the first occurrence of the specified element in this list,
     * if present.
     * @param elt the element to remove
     * @return this {@code LinkedList} with the element removed
     */
    public LinkedList<E> remove(E elt);

    /**
     * Returns an iterator over the elements in this linked list in order from
     * head to tail.
     * @return an iterator over the elements in this list.
     */
    public Iterator<E> iterator();
}
