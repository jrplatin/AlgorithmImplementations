import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

/**
 * Sample test suite for BSTNode
 *
 * @author sshaik, eyeung
 */

public class BSTNodeImplTest {

    private BSTNode<Integer> tree1;
    private BSTNode<Integer> fullTree;
    private BSTNode<Integer> wikiTree;

    @Before
	public void createWikipediaTree() {
        wikiTree = new BSTNodeImpl<>(8);
        int[] insert = new int[]{3, 10, 1, 6, 14, 4, 7, 13};
        for (int i : insert) {
            wikiTree.insert(i);
        }
    }

    @Before
    public void createFullTree() {
        fullTree = new BSTNodeImpl<>(5);
        int[] insert = new int[]{3, 7, 2, 4, 6, 8};
        for (int i : insert) {
            fullTree.insert(i);
        }
    }

    @Test
    // BST: insert base cases
    public void testInsertLess(){
        tree1 =  new BSTNodeImpl<>(2);
        tree1 = tree1.insert(1);
        assertTrue(tree1.contains(2));
        assertTrue(tree1.contains(1));
        tree1 = tree1.insert(3);
        assertTrue(tree1.contains(3));
    }
    
    //BST: insert base case (test structure of tree)
    @Test 
    public void testInsertLessStructure(){
    	tree1 =  new BSTNodeImpl<>(2);
    	tree1 = tree1.insert(1);
    	tree1 = tree1.insert(3);
    	assertEquals((Integer)1, tree1.getLeftChild().getValue());
    	assertEquals((Integer)3, tree1.getRightChild().getValue());
    }
    
    //BST: Create tree through explicitly setting children
    @Test
    public void testInsertLessNode(){
    	tree1 = new BSTNodeImpl<>(2);
    	tree1.setLeftChild(new BSTNodeImpl<>(1));
    	tree1.setRightChild(new BSTNodeImpl<>(3));
    	assertTrue(tree1.contains(2));
    	assertTrue(tree1.contains(1));
    	assertTrue(tree1.contains(3));
    }

    @Test
    // BST: contains singleton
    public void testContainsSingleton() {
        tree1 = new BSTNodeImpl<>(1);
        assertTrue(tree1.contains(1));
    }

    @Test
    // BST: contains unbalanced
    public void testContainsUnbalanced() {
        int[] contained = new int[]{1, 3, 6, 7, 4, 8, 10, 13, 14};
        for (int i : contained) {
            assertTrue(wikiTree.contains(i));
        }
    }

    @Test
    // BST: contains false
    public void testContainsfalseUnbalanced() {
        assertFalse(wikiTree.contains(5));
        assertFalse(wikiTree.contains(100));
        assertFalse(wikiTree.contains(9));
    }


    @Test
    // BST: test size multilevel Complete
    public void testSize() {
        tree1 = new BSTNodeImpl<>(5);
        int[] insert = new int[]{3, 7, 2, 4, 6, 8};
        for (int i : insert) {
            tree1.insert(i);
        }
        assertEquals(7, tree1.size());
    }

    @Test
    // BST: test size unbalanced
    public void testSizeUnbalanced() {
        assertEquals(9, wikiTree.size());
    }

    @Test
    // BST: test first unbalanced
    public void testFirst() {
        assertEquals((Integer)1, wikiTree.first());
    }

    @Test
    // BST: test last unbalanced
    public void testLast() {
        assertEquals((Integer)14, wikiTree.last());
    }

    @Test
    // BST: test first no left children
    public void testFirstRLeaning() {
        tree1 = new BSTNodeImpl<>(1);
        for (int i = 2; i < 5; i++) {
            tree1.insert(i);
        }
        assertEquals((Integer)1, tree1.first());
    }

    @Test
    // BST: test last no right children
    public void testLastLLeaning() {
        tree1 = new BSTNodeImpl<>(5);
        for (int i = 4; i > 0; i--) {
            tree1.insert(i);
        }
        assertEquals((Integer)5, tree1.last());
    }

    
    // Basic behavior testing
    @Test
    // BST: insert recursive step
    public void testInsertMultiLevel() {
        tree1 = new BSTNodeImpl<>(5);
        int[] insert = new int[]{3, 7, 2, 4, 6, 8};
        for (int i : insert) {
            tree1.insert(i);
        }
        tree1.insert(1);
        for (int i : insert) {
            assertTrue(tree1.contains(i));
        }
    }


    // Traversal tests
    @Test
    // BST: test singleton inorder
    public void testInorderSingleton() {
        tree1 = new BSTNodeImpl<>(5);
        LinkedList<Integer> ll = tree1.getInorderTraversal();
        assertEquals(1, ll.size());
        assertEquals((Integer)5, ll.get(0));
    }


    @Test
    // BST: test multi-level inorder
    public void testInorderMultiLevel() {
        LinkedList<Integer> ll = fullTree.getInorderTraversal();
        Iterator<Integer> it = ll.iterator();
        int count = 2;
        while (it.hasNext()) {
            assertEquals((Integer) count++, it.next());
        }
    }

    @Test
    // BST: test unbalanced inorder
    public void testInorderUnbalanced() {
        LinkedList<Integer> ll = wikiTree.getInorderTraversal();
        int[] order = new int[]{1, 3, 4, 6, 7, 8, 10, 13, 14};
        Iterator<Integer> it = ll.iterator();
        int count = 0;
        while (it.hasNext()) {
            assertEquals((Integer) order[count++], it.next());
        }
    }

    // Edge case testing
    @Test
    // BST: size computed recursively
    public void testModifyChildNodes() {
        // Here we make sure it isn't a static variable
        tree1 = new BSTNodeImpl<>(5);
        tree1 = tree1.insert(3);
        tree1 = tree1.insert(7);
        assertEquals(3, tree1.size());
        tree1.getLeftChild().insert(8);
        assertEquals(4, tree1.size());
    }

    @Test(expected = NullPointerException.class)
    // BST: can't insert null
    public void testInsertNull() {
        tree1 = new BSTNodeImpl<>(5);
        tree1.insert(null);
    }
}
