/**
 * 
 */
package textgen;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author UC San Diego MOOC team
 *
 */
public class MyLinkedListTester {

	private static final int LONG_LIST_LENGTH =10; 

	MyLinkedList<String> shortList;
	MyLinkedList<Integer> emptyList;
	MyLinkedList<Integer> longerList;
	MyLinkedList<Integer> list1;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		// Feel free to use these lists, or add your own
	    shortList = new MyLinkedList<String>();
		shortList.add("A");
		shortList.add("B");
		//shortList.get();
		emptyList = new MyLinkedList<Integer>();
		longerList = new MyLinkedList<Integer>();
		for (int i = 0; i < LONG_LIST_LENGTH; i++)
		{
			longerList.add(i);
		}
		//longerList.get();
		list1 = new MyLinkedList<Integer>();
		list1.add(65);
		list1.add(21);
		list1.add(42);
		//list1.get();
	}

	
	/** Test if the get method is working correctly.
	 */
	/*You should not need to add much to this method.
	 * We provide it as an example of a thorough test. */
	@Test
	public void testGet()
	{
		//longerList.get();
		//System.out.println(longerList.size());
		//longerList.get(5);
		//test empty list, get should throw an exception
		try {
			emptyList.get(0);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
			
		}
		
		// test short list, first contents, then out of bounds
		assertEquals("Check first", "A", shortList.get(0));
		assertEquals("Check second", "B", shortList.get(1));
		
		try {
			shortList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			shortList.get(2);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		// test longer list contents
		for(int i = 0; i<LONG_LIST_LENGTH; i++ ) {
			assertEquals("Check "+i+ " element", (Integer)i, longerList.get(i));
		}
		
		// test off the end of the longer array
		try {
			longerList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			longerList.get(LONG_LIST_LENGTH);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		}
		
		
		//assertEquals("","0123456789",longerList.getString(longerList));
		//System.out.println(longerList.getString(longerList));
	}
	
	
	/** Test removing an element from the list.
	 * We've included the example from the concept challenge.
	 * You will want to add more tests.  */
	@Test
	public void testRemove()
	{
		//list1.get();
		int a = list1.remove(1);
		//list1.get();
		assertEquals("Remove: check a is correct ", 65, a);
		assertEquals("Remove: check element 0 is correct ", (Integer)21, list1.get(0));
		assertEquals("Remove: check size is correct ", 2, list1.size());
		
		// TODO: Add more tests here
	}
	
	/** Test adding an element into the end of the list, specifically
	 *  public boolean add(E element)
	 * */
	@Test
	public void testAddEnd()
	{
		
        // TODO: implement this test
		longerList.add(50);
		assertEquals("same",(Integer)50,longerList.get(longerList.size()));
		
	}

	
	/** Test the size of the list */
	@Test
	public void testSize()
	{
		// TODO: implement this test
		//longerList.add(8,55);
		//assertEquals("same",(Integer)55,longerList.size());
		
	}

	
	
	/** Test adding an element into the list at a specified index,
	 * specifically:
	 * public void add(int index, E element)
	 * */
	@Test
	public void testAddAtIndex()
	{
        // TODO: implement this test
		try {
			longerList.add(0, null);
			fail("NullPointer");
		}
		catch (NullPointerException e) {
		
		}
		//System.out.println(longerList.size());
		longerList.add(0,10);
		assertEquals("chechequal",(Integer)10,longerList.get(0));
		//System.out.println(longerList.size());
		longerList.add(5,3);
		emptyList.add(0,1);
		assertEquals("Equal",(Integer)1,emptyList.get(0));
		//longerList.get();
		assertEquals("chechequal",(Integer)3,longerList.get(5));
		
		
		try{
			emptyList.add(1,4);
			fail("Check the bound");
		}
		catch(IndexOutOfBoundsException e){
			
		}
		//System.out.println(shortList.size());
		shortList.add(1,"C");
		assertEquals("chechequal","C",shortList.get(1));
		
		shortList.add(0,"D");
		assertEquals("chechequal","D",shortList.get(0));
		
		
	}
	
	/** Test setting an element in the list */
	@Test
	public void testSet()
	{
	    // TODO: implement this test
		try {
			longerList.set(0, null);
			fail("NullPointer");
		}
		catch (NullPointerException e) {
		
		}
		assertEquals("check","A",shortList.set(1,"Z"));
		assertEquals("check",(Integer)2,longerList.set(3, 4));
		//longerList.get();
	}
	
	
	
	// TODO: Optionally add more test methods.
	
}
