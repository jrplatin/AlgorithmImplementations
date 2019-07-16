import java.util.Iterator;

public class InterviewQuestionsImpl implements InterviewQuestions {

	@Override
	public <E extends Comparable<E>> BSTNode<E> invert(BSTNode<E> tree) {
		if(tree == null) {
			return null;
		}
		BSTNode temp;
        temp = invert(tree.getLeftChild());
        tree.setLeftChild(invert(tree.getRightChild()));
        tree.setRightChild(temp);        
        return tree;
	}
	
	@Override
	public LinkedList<LinkedList<String>> formatDocument(
			LinkedList<LinkedList<String>> document, int maxWords) {
		LinkedList<LinkedList<String>> list = new LinkedListImpl<LinkedList<String>>(); 
		if(maxWords < 1) {
			throw new IllegalArgumentException("Enter a valid maxwords length"); 
		}
		if (document == null) {
			return null; 
		}
		LinkedList<String> curLine = document.get(0); 
		Iterator<LinkedList<String>> lineIter = document.iterator();
		LinkedList<String> temp = null; 
		
		while(lineIter.hasNext()) {
			if(curLine.size() > maxWords) {
				temp = curLine.truncate(maxWords);
				list.add(curLine);
			
				
			}
			else if (curLine.size() < maxWords) {
				curLine.concatenate(lineIter.next());
			}
			else {
				list.add(curLine);
				lineIter.next();
			}
			
		}
		return list;
		
		
	}

	@Override
	public <E> E middleElement(LinkedList<E> list) {
		
		 LinkedListNode<E> slowP = list.getHeadNode();
		 LinkedListNode<E> fastP = list.getHeadNode();

	        if (list.getHeadNode() != null)
	        {
	            while (fastP != null && slowP.next() != null)
	            {
	                fastP = fastP.next().next();
	                slowP = slowP.next().next(); 
	            }
	            
	        }
        return (E) slowP; 
        
	}

}
