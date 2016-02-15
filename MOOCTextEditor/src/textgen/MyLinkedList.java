package textgen;

import java.util.AbstractList;


/** A class that implements a doubly linked list
 * 
 * @author UC San Diego Intermediate Programming MOOC team
 *
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	LLNode<E> head;
	LLNode<E> tail;
	LLNode<E> e;
	int size;

	/** Create a new empty LinkedList */
	public MyLinkedList() {
		// TODO: Implement this method
		head = new LLNode<E>(null);
		tail = new LLNode<E>(null);
		tail.prev = head;
		head.next = tail;
		size = 1;
		
				
	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element ) 
	{
		// TODO: Implement this method
		if(element==null){
			throw new NullPointerException();
		}
		LLNode<E> tmp = new  LLNode<E>(element);
		
		if(size==-1){
			tail.prev = tmp;
			head.next = tmp;
			//System.out.println("prev"+tmp.prev+"data"+tmp.data+"next"+tmp.next);
			size++;
		}
		else{
			tmp.prev=tail.prev;
			tail.prev.next = tmp;
			tail.prev = tmp;
			tmp.next =tail;
			//System.out.println(tmp.prev.data);
			size++;
		}
		
		return true;
	}
	
	
	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index) 
	{
		// TODO: Implement this method.
		int j=0;
		if(size==-1 && index==0 || index>size || index<0){
			throw new IndexOutOfBoundsException();
		}
		
		for(LLNode<E> e = head.next; e!=tail; e = e.next){
			if(index==j){
				//System.out.println(e.data);
				return e.data;
			}
			j++;
		}
		return null;
	}

	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element ) 
	{
		// TODO: Implement this method
		if(element == null){
			throw new NullPointerException();
		}
		if(size!=-1 && index>size  || index<0){
			throw new IndexOutOfBoundsException();
		}
		int j=-1;
		LLNode<E> tmp = new LLNode(null) ;
		//LLNode<E> e   = new LLNode<E>(null);
		if(index==0){
			tmp.next=head.next;
			head.next=tmp;
			tmp.data=element;
			size++;
		}
		else{
			
			for(e = head; e!=tail; e = e.next){
				if(index==j){
					//System.out.println(e.data);
					//System.out.println(e.prev.data+" "+index);
					tmp.prev=e;
					tmp.next=e.next;
					e.next = tmp;
					tmp.data=e.data;
					e.data=element;
					
					
					//System.out.println(e.prev.data+" "+e.data+" "+e.next.data);
				}
				j++;
				
			}
			size++;
		}
		
		
		
	}


	/** Return the size of the list */
	public int size() 
	{
		// TODO: Implement this method
		return size;
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 * 
	 */
	public E remove(int index) 
	{
		int j=1;
		LLNode<E> tmp = new LLNode(null) ;
		if(size==-1 && index==0 || index>size || index<0){
			throw new IndexOutOfBoundsException();
		}
		if(index==1){
			E tp = head.next.data;
			head.next = head.next.next;
			head.next.prev = head;
			return tp;
		}
		for(LLNode<E> e = head.next; e!=tail; e = e.next){
				if(index==j){
					//System.out.println(e.data);
					E tp = e.data;
					e.prev.next=e.next;
					e.next.prev= e.prev;
					return tp;
				}
				j++;
			}
		
		return null;
	}

	/**
	 * Set an index position in the list to a new element
	 * @param index The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E set(int index, E element) 
	{
		int j=1;
		if(element == null){
			throw new NullPointerException();
		}
		if(size==0 && index==0 || index>size || index<0){
			throw new IndexOutOfBoundsException();
		}
		
		for(LLNode<E> e = head.next; e!=tail; e = e.next){
			if(index==j){
				//System.out.println(e.data);
				E tmp = e.data;
				//System.out.println(e.pre);
				e.data=element;
				//System.out.println(e.pre);
				return  tmp;
			}
			j++;
		}
		
		return null;
	}

	public String getString(MyLinkedList<Integer> lst){
		LLNode<Integer> curr;
        String ret = "";
if (lst.head.data == null)
	curr = lst.head.next;
else
	curr = lst.head;

while (curr != null && curr.data != null)
{
	ret += curr.data;
	curr = curr.next;
}
        return ret;
	}

	
}

class LLNode<E> 
{
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	// TODO: Add any other methods you think are useful here
	// E.g. you might want to add another constructor

	public LLNode(E e) 
	{
		this.data = e;
		this.prev = null;
		this.next = null;
	}
	
	
	

}
