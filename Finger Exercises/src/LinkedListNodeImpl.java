import java.util.Iterator;

public class LinkedListNodeImpl<E> implements LinkedListNode<E> {
	
	private E element;
	private  LinkedListNode<E> next;
	
    public LinkedListNodeImpl(E value) {
    	element = value;
    	next = null;
    }
	
	@Override
	public LinkedListNode<E> next() {
		return next;
	}

	@Override
	public LinkedListNode<E> add(E elt) {
		if(elt == null) {
			throw new NullPointerException();
		}
		if(next == null) {
			next = new LinkedListNodeImpl<E>(elt);
		}
		else {
			next.add(elt);
		}
		return this;
	}

	@Override
	public LinkedListNode<E> concatenate(LinkedListNode<E> head) {
		if(next == null) {
			next = head;
		}
		else {
			next.concatenate(head);
		}
		return this;
	}

	@Override
	public LinkedListNode<E> truncate(int index) {
		if(index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException("Index is out of range");
		}
		else if (index == 0) {
			return this;
		}
		else if (index == 1) {
			LinkedListNode<E> temp;
			temp = next;
			next = null;
			return temp;
		}
		else {
			return next.truncate(index-1);
		}
	}
	
	@Override
	public E get(int index) {
		if(index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException("Index is out of range");
		}
		else if (index == 0) {
			return element;
		}
		else {
			return next.get(index-1);
		}
	}

	@Override
	public boolean contains(E elt) {
		if(elt.equals(element)) {
			return true;
		}
		else {
			if(next == null) {
				return false;
			}
			else {
				return next.contains(elt); 
			}
		}
	}

	@Override
	public int size() {
		if(next == null) {
			return 1;
		}
		else {
			return (1 + next.size());
		}
	}

	@Override
	public LinkedListNode<E> remove(E elt) {
		if(!contains(elt)) {
			return this; 
		}
		if(element == elt) {
			return next;
		}
		else if (next == null && element != elt) {
			return this;
		}
		else {
			next = next.remove(elt);
			return this; 
		}
		
	}
	//counter; 
	@Override
	public Iterator<E> iterator() {
		return new Iterator<E>() {
			int counter = 0;
			public E next() {
				E el = get(counter); 
				counter++; 
				return el;
				
			}
			public boolean hasNext() {
				return counter < size(); 
				
			}
		};
	}
}
