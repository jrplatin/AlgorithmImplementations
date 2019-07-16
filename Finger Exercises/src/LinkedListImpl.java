import java.util.Collections;
import java.util.Iterator;

public class LinkedListImpl<E> implements LinkedList<E> {

	private LinkedListNode<E> head;
	
	public LinkedListImpl() {
	}

	public LinkedListImpl(E elt) {
		add(elt);
	}
	
	@Override
	public LinkedList<E> add(E elt) {
		if (head == null) {
			head = new LinkedListNodeImpl<E>(elt);
		} else {
			head.add(elt);
		}
		return this;
	}
	
	@Override
	public LinkedList<E> concatenate(LinkedList<E> list) {
		if (head == null || head.size() == 0) {
			return this;
		}
		head.concatenate(list.getHeadNode());
		return this;
	}

	@Override
	public LinkedList<E> truncate(int index) {
		if (head == null) {
			return null;
		}
		LinkedListNode<E> newHead = head.truncate(index);
		LinkedListImpl<E> secondList = new LinkedListImpl<E>();
		secondList.head = newHead;
		return secondList;
	}

	@Override
	public E get(int index) {
		if (head == null) {
			throw new IndexOutOfBoundsException();
		}
		return head.get(index);
	}

	@Override
	public LinkedListNode<E> getHeadNode() {
		return head;
	}

	@Override
	public boolean contains(E elt) {
		return head.contains(elt);
	}

	@Override
	public int size() {
		if (head == null){
			return 0;
		} else {
			return head.size();
		}
	}

	@Override
	public Iterator<E> iterator() {
		if (head == null) {
			return Collections.emptyIterator();
		}
		return head.iterator();
	}

	@Override
	public LinkedList<E> remove(E elt) {
		if (head != null){
			head = head.remove(elt);
		}
		return this;
	}

}
