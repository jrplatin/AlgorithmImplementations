import java.util.Iterator;

/**
 * Interface for your implementation of a linked list node. It contains various
 * operations for adding/removing elements and interacting with other nodes. The
 * node is allowed to contain null as its value.
 * @author carzheng
 * 
 */
public interface LinkedListNode<E> extends Iterable<E> {

    /**
     * Returns the node that follows this node in the list.
     * @return the next node
     */
    public LinkedListNode<E> next();

    /**
     * Appends the specified element to the end of this list.
     * @param elt the element to append to the end of the list.
     * @return the head of the list with the element added
     */
    public LinkedListNode<E> add(E elt);

    /**
     * Appends the input list to the end of this list.
     * @param head the head of the list to append
     * @return the head of the concatenated list
     */
    public LinkedListNode<E> concatenate(LinkedListNode<E> head);

    /**
     * Truncates the list into two lists, where the node at {@code index} is
     * returned as the head of a new list. If the new list is empty, returns
     * {@code null}. The original list should no longer contain the
     * elements that were truncated off.
     * 
     * @param index the head of the list that is truncated off
     * @return the second of the two new lists (what was truncated off)
     * @throws IndexOutOfBoundsException if the index is out of range
     *         i.e. <tt>(index < 0 || index >= size())</tt>
     */
    public LinkedListNode<E> truncate(int index);

    /**
     * Returns the element at the specified position in this list.
     * @param index the position of the element to return
     * @return the element at the specified position in this list
     * @throws IndexOutOfBoundsException if the index is out of range
     *         i.e. <tt>(index < 0 || index >= size())</tt>
     */
    public E get(int index);

    /**
     * Returns {@code true} if this list contains the specified element.
     * @param elt element whose presence in this list is to be tested
     * @return {@code true}, if this list contains the specified element,
     *         {@code false} otherwise
     */
    public boolean contains(E elt);

    /**
     * Returns the number of elements in this list.
     * @return the number of elements in this list
     */
    public int size();

    /**
     * Removes the first occurrence of the specified element in this list, if
     * present. Returns the head of the resultant list. If the list is empty,
     * returns {@code null} and leaves the input unmodified.
     * 
     * Note that because the original head node may be deleted, usage of this
     * method will typically look like <tt>list = list.remove(elt)</tt>. On the
     * contrary, this type of assignment is allowed, but not required, for
     * methods like add().
     * @param elt the element to remove
     * @return the head of the list with the element removed, or {@code} null if
     *         the new list is empty.
     */
    public LinkedListNode<E> remove(E elt);

    /**
     * Returns an iterator over the elements in this linked list in the correct
     * order, from head to tail.
     * @return an iterator over the elements of the linked list, starting with
     *         this {@code LinkedListNode}.
     */
    public Iterator<E> iterator();
}
