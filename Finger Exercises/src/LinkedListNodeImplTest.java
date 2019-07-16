import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

public class LinkedListNodeImplTest {
	
	 private LinkedListNode<Integer> list;
	 private LinkedListNode<Integer> list2;

	@Before 
	public void setUpList() {
		list = new LinkedListNodeImpl<>(1);
		list.add(3);
		
		list.add(5);
		
	}
	@Before 
	public void setUpListList2() {
		list2 = new LinkedListNodeImpl<>(10);
			
	}
	@Test 
	public void testInsert() {
		list.add(0); 
		list.add(-1);
		assertEquals(5, (int) list.size());
		assertEquals(1, (int) list.get(0));
		assertEquals(3, (int) list.get(1));
		assertEquals(5, (int) list.get(2));
		assertEquals(0, (int) list.get(3));
		assertEquals(-1, (int) list.get(4));
		
	}
	
	
	
    @Test(expected = NullPointerException.class)
	public void testInsertNull() {
		list.add(0); 
		list.add(null);
		
	}
	@Test 
	public void testNext() {
		assertEquals(3, (int) list.next().get(0));	
		
	}
	@Test 
	public void testConc() {
		assertEquals(3, (int) list.size());
		list.concatenate(list2); 
		assertEquals(4, list.size());	
		assertEquals(10, (int) list.get(3));	
		
	}
	@Test 
	public void testTrunc() {
		list.truncate(2);
		assertEquals(1, (int) list.get(0));	
		assertEquals(3, (int) list.get(1));	
		assertEquals(2, (int) list.size());

		
	}
	@Test 
	public void testContains() {
	
		assertTrue(list.contains(3));	
		assertTrue(list.contains(5));
		assertFalse(list.contains(123123));
	
		
	}
	@Test 
	public void testRemoveNotHead() {
	
		assertEquals(1, (int) list.remove(1).get(0));
	
		
	}
	@Test 
	public void testRemoveHead() {
	
		assertEquals(3, (int) list.remove(0).get(0));
	
		
	}
	
	@Test 
	public void testDuplicates() {
		list.add(1);
		assertEquals(3, (int) list.remove(1).get(0));
		assertTrue(list.contains(1)); 
	
		
	}
	@Test 
	public void testIterator() {
	
		Iterator<Integer> it = list.iterator();
		assertTrue(it.hasNext());
		assertEquals(1, (int) it.next());
		assertEquals(3, (int) it.next());
		assertEquals(5, (int) it.next());


		
	}
}
