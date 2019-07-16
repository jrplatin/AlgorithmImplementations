import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class StudentImplTest {
	public StudentImpl studentTest;
	public StudentImpl studentTest2;
	public StudentImpl studentTest3;
	public StudentFactory sd;
	public Student sdFactoryStudentTest; 

	@Before
	public void createTestClass() {
		studentTest = new StudentImpl(10, "John");		
	}
	
	
	@Before
	public void createDifferentStudentImpl() {		
		studentTest3 = new StudentImpl(11, "John");
	}
	
	@Before
	public void createDuplicateIDClass() {
		studentTest2 = new StudentImpl(10, "Joe");
	}
	@Before
	public void createStudentFactory() {
		sd = new StudentFactoryImpl();
		
	}
	@Before
	public void createStudentFactoryAndInitializesdFactoryStudentTest() {
		sdFactoryStudentTest = sd.buildStudent("John", 10);
				
		
	}
	@Test
	public void testGetId() {
		assertEquals(10, studentTest.getStudentId());
	}
	@Test
	public void testGetName() {
		assertEquals("John", studentTest.getName());
	}
	@Test
	public void testHasCodeSameForSameId() {
		assertEquals(studentTest.hashCode(), studentTest2.hashCode());
	}
	@Test
	public void equalsIsTrueForSameInstance() {
		assertTrue(studentTest.equals(studentTest));
	}
	@Test
	public void testEqualsForNull() {
		assertFalse(studentTest.equals(null));
	}
	@Test
	public void testGetClassEquality() {
		assertFalse(studentTest.equals(10));
	}
	@Test
	public void testDifferentIdSameName() {
		assertFalse(studentTest.equals(studentTest3));
	}
	@Test
	public void testDifferentNameSameId() {
		assertTrue(studentTest.equals(studentTest2));
	}
	@Test
	public void testFactoryId() {
		assertEquals(10, sdFactoryStudentTest.getStudentId());
	}
	@Test
	public void testFactoryName() {
		assertEquals("John", sdFactoryStudentTest.getName());
	}
	
}
