/**
 * Contains methods to solve common interview questions involving linked lists and BSTs.
 * @author carzheng
 * 
 */
public interface InterviewQuestions {

    /**
     * Example of binary tree inversion:
     * 		    1                   1
     * 	 	 /	   \			 /	   \
     *      2	    3     =>    3	    2
     *	   / \     / \         / \     / \
     *    4   5   6   7       7   6   5   4
     * @param tree
     * @return The inverted BST
     */
    public <E extends Comparable<E>> BSTNode<E> invert(BSTNode<E> tree);

    /**
     * @param maxWords
     * @param document
     * @return A document that adheres to the criteria specified in the writeup
     */
    public LinkedList<LinkedList<String>> formatDocument(
            LinkedList<LinkedList<String>> document, int maxWords);

    /**
     * @param list
     * @return The element at the middle of the list. Regardless of whether the list is of even
     * or odd length, return the ceil(n/2) element.
     */
    public <E> E middleElement(LinkedList<E> list);
}
