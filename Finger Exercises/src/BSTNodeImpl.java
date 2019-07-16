public class BSTNodeImpl<E extends Comparable<E>> implements BSTNode<E> {

	private BSTNode<E> left;
	private BSTNode<E> right;
	private E element;

	public BSTNodeImpl(E elt) {
		left = null;
		right = null;
		element = elt;
	}

	@Override
	public BSTNode<E> insert(E elt) {
		if (elt == null) {
			throw new NullPointerException("Cannot insert null element!");
		}
		if (elt.compareTo(element) == 1) {
			if (right == null) {
				right = new BSTNodeImpl<E>(elt);
			} else {
				right.insert(elt);
			}
		} else if (elt.compareTo(element) == -1) {
			if (left == null) {
				left = new BSTNodeImpl<E>(elt);
			} else {
				left.insert(elt);
			}
		}
		return this;
	}

	@Override
	public boolean contains(E elt) {
		if (elt.compareTo(element) == 1) {
			return right != null && right.contains(elt);
		} else if (elt.compareTo(this.element) == -1) {
			return left != null && left.contains(elt);
		} else {
			return true;
		}
	}

	@Override
	public int size() {
		if (right == null && left == null) {
			return 1;
		} else {
			int size = 1;
			if (right != null) {
				size += right.size();
			}
			if (left != null){
				size += left.size();
			}
			return size;
		}
	}

	@Override
	public E first() {
		if (this.left != null) {
			return left.first();
		} else {
			return element;
		}
	}

	@Override
	public E last() {
		if (right != null) {
			return right.last();
		} else {
			return element;
		}
	}

    @Override
    public BSTNode<E> getLeftChild() {
        return left;
    }

    @Override
    public BSTNode<E> getRightChild() {
        return right;
    }

	@Override
	public BSTNode<E> setLeftChild(BSTNode<E> leftChild) {
		left = leftChild;
		return this;
	}

	@Override
	public BSTNode<E> setRightChild(BSTNode<E> rightChild) {
		right = rightChild;
		return this;
	}

	@Override
	public E getValue() {
		return element;
	}

	@Override
	public LinkedList<E> getInorderTraversal() {
		LinkedList<E> finalList = null;
		if (left != null) {
			finalList = left.getInorderTraversal();
			finalList.add(element);
		} else {
			finalList = new LinkedListImpl<E>();
			finalList.add(element);
		}

		if (this.right != null) {
			finalList.concatenate(right.getInorderTraversal());
		}
		
		return finalList;
	}

}
