import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

public class InterviewQuestionsImplTest {
	  private BSTNode<Integer> tree1;
	  private InterviewQuestions intImpl; 
	  private LinkedList<Integer> list; 
	  
	  @Before
	  public void setupTreeAndInterview() {
		  tree1 = new BSTNodeImpl<>(1);
	        int[] insert = new int[]{2,3,4,5,6,7};
	        for (int i : insert) {
	            tree1.insert(i);
	        }
	        intImpl = new InterviewQuestionsImpl(); 
	  }
	  @Before
	  public void setUpLinkedList() {
		  list = new LinkedListImpl<Integer>(1); 
	  }
	  @Test
	  public void testInvert () {
		 assertEquals((int) tree1.getValue(), 1);
		 assertEquals(tree1.getLeftChild(), 3);
		 assertEquals(tree1.getRightChild(), 2);
		 assertEquals(tree1.getRightChild().getRightChild(), 4);
		 assertEquals(tree1.getLeftChild().getLeftChild(), 7);

	  }
	  @Test
	  public void testMiddleElementEven () {
		list.add(10);
		list.add(5);
		list.add(122);
		assertEquals(5, (int) intImpl.middleElement(list)); 
		
		 
	  }
	  @Test
	  public void testMiddleSingelton () {
		assertEquals(1,  (int) intImpl.middleElement(list));

	  }
	  @Test
	  public void testMiddleElementOdd() {
		  list.add(10);
		  list.add(14);
			 assertEquals(10,  (int) intImpl.middleElement(list));

	  }
	  @Test
	  public void testTypicalFormat () {
		  LinkedList<LinkedList<String>>  doc = new LinkedListImpl<LinkedList<String>>();
		  LinkedList<String> line1 = new LinkedListImpl<String>();
		  line1.add("CIS 121 is the final");
		  LinkedList<String> line2 = new LinkedListImpl<String>();
		  line2.add("course");
		  LinkedList<String> line3 = new LinkedListImpl<String>();
		  line3.add("in the introductory");
		  LinkedList<String> line4 = new LinkedListImpl<String>();
		  line4.add("computer science sequence at the University of Pennsylvania");
		  doc.add(line1);
		  doc.add(line2);
		  doc.add(line3);
		  doc.add(line4); 
		  
		  LinkedList<LinkedList<String>>  newDoc = new LinkedListImpl<LinkedList<String>>();
		  LinkedList<String> line11 = new LinkedListImpl<String>();
		  line11.add("CIS 121 is the");
		  LinkedList<String> line22 = new LinkedListImpl<String>();
		  line22.add("final course in the");
		  LinkedList<String> line33 = new LinkedListImpl<String>();
		  line33.add("introductory computer science sequence ");
		  LinkedList<String> line44 = new LinkedListImpl<String>();
		  line44.add("at the University of Pennsylvania");
		  
		  newDoc.add(line11);
		  newDoc.add(line22);
		  newDoc.add(line33);
		  newDoc.add(line44); 
		  
		  assertEquals(intImpl.formatDocument(doc, 4), newDoc);
		  
	  }
	  @Test	  
	  public void testShortMaxWordLongDoc () {
		  LinkedList<LinkedList<String>>  doc = new LinkedListImpl<LinkedList<String>>();
		  LinkedList<String> line1 = new LinkedListImpl<String>();
		  line1.add("CIS 121 is the final");
		  LinkedList<String> line2 = new LinkedListImpl<String>();
		  line2.add("course");
		  LinkedList<String> line3 = new LinkedListImpl<String>();
		  line3.add("in the introductory");
		  LinkedList<String> line4 = new LinkedListImpl<String>();
		  line4.add("computer science sequence at the University of Pennsylvania");
		  doc.add(line1);
		  doc.add(line2);
		  doc.add(line3);
		  doc.add(line4); 
		  
		  LinkedList<LinkedList<String>>  newDoc = new LinkedListImpl<LinkedList<String>>();
		  LinkedList<String> line11 = new LinkedListImpl<String>();
		  line11.add("CIS 121");
		  LinkedList<String> line22 = new LinkedListImpl<String>();
		  line22.add("is");
		  LinkedList<String> line33 = new LinkedListImpl<String>();
		  line33.add("the");
		  LinkedList<String> line44 = new LinkedListImpl<String>();
		  line44.add("final");
		  LinkedList<String> line55 = new LinkedListImpl<String>();
		  line55.add("course");
		  
		  newDoc.add(line11);
		  newDoc.add(line22);
		  newDoc.add(line33);
		  newDoc.add(line44); 
		  newDoc.add(line55); 
		  
		  assertEquals(intImpl.formatDocument(doc, 1), newDoc);
	  }
	  @Test	
	  public void testShortDocLongMaxWord () {
		  LinkedList<LinkedList<String>>  doc = new LinkedListImpl<LinkedList<String>>();
		  LinkedList<String> line1 = new LinkedListImpl<String>();
		  line1.add("CIS 121 is the final");		  
		  doc.add(line1);
		 
		  LinkedList<LinkedList<String>>  newDoc = new LinkedListImpl<LinkedList<String>>();
		  LinkedList<String> line11 = new LinkedListImpl<String>();
		  line11.add("CIS 121 is the final");
	
		  
		  newDoc.add(line11);
	
		  
		  assertEquals(intImpl.formatDocument(doc, 100), newDoc);
	  }
	  
	  @Test(expected = IllegalArgumentException.class)
	  public void testBadInput () {
		  LinkedList<LinkedList<String>>  doc = new LinkedListImpl<LinkedList<String>>();
		  LinkedList<String> line1 = new LinkedListImpl<String>();
		  line1.add("CIS 121 is the final");		  
		  doc.add(line1);
		 
		  LinkedList<LinkedList<String>>  newDoc = new LinkedListImpl<LinkedList<String>>();
		  LinkedList<String> line11 = new LinkedListImpl<String>();
		  line11.add("CIS 121 is the final");
	
		  
		  newDoc.add(line11);
	
		  
		  assertEquals(intImpl.formatDocument(doc, -123), newDoc);
	  }
	  @Test(expected = IllegalArgumentException.class)
	  public void testNullDoc () {
		  LinkedList<LinkedList<String>>  doc = new LinkedListImpl<LinkedList<String>>();
		  LinkedList<String> line1 = new LinkedListImpl<String>();
		  line1.add("CIS 121 is the final");		  
		  doc.add(line1);
		 
		  LinkedList<LinkedList<String>>  newDoc = new LinkedListImpl<LinkedList<String>>();
		  LinkedList<String> line11 = new LinkedListImpl<String>();
		  line11.add("CIS 121 is the final");
	
		  
		  newDoc.add(line11);
	
		  
		  assertEquals(intImpl.formatDocument(null, -123), newDoc);
	  }
}

