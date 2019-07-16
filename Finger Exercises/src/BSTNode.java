/**
 * Interface for your implementation of a binary search tree. It is represented
 * by a single node which serves as the root of the tree.
 * @author carzheng
 *
 */
public interface BSTNode<E extends Comparable<E>> {

    /**
     * Inserts the specified element into the tree if not already present.
     * @param elt
     * @return The root element
     */
	public BSTNode<E> insert(E elt);

    /**
     * Returns {@code true} if this tree contains the specific element,
     * {@code false} otherwise.
     * @param elt - elt whose presence int he tree is to be tested
     * @return {@code true} if the tree contains the specific element
     */
	public boolean contains(E elt);

    /**
     * Returns the number of elements in the tree.
     * @return the number of elements in the tree
     */
    public int size();

    /**
     * Returns the first (smallest) element in the tree.
     * @return the first (smallest) element in the tree
     */
    public E first();

    /**
     * Returns the last (largest) element in the tree.
     * @return the last (largest) element in the tree
     */
    public E last();

    /**
     * Returns the left child of the node in the tree, if it exists,
     * {@code false} otherwise.
     * @return the left child of this node
     */
    public BSTNode<E> getLeftChild();
    
    /**
     * Returns the right child of the node in the tree, if it exists,
     * {@code false} otherwise.
     * @return the right child of this node
     */
    public BSTNode<E> getRightChild();

    /**
     * Sets the left child of this node to the input {@code BSTNode}.
     * @return the current node
     */
    public BSTNode<E> setLeftChild(BSTNode<E> leftChild);

    /**
     * Sets the right child of this node to the input {@code BSTNode}.
     * @return the current node
     */
    public BSTNode<E> setRightChild(BSTNode<E> rightChild);
    
    /**
     * Returns the valud of this node.
     * @return the value of this node
     */
    public E getValue();
    
    /**
     * Returns a {@link LinkedList} containing the inorder traversal of the tree
     * rooted at this node.
     * @return the inorder list of tree elements
     */
	public LinkedList<E> getInorderTraversal();
}
