// Time Complexity : O(1) // For each operation
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Nothing as such

class PeekingIterator implements Iterator<Integer> {

	Iterator<Integer> iterator = null;
	Integer next = null;

	public PeekingIterator(Iterator<Integer> iterator) {
		 iterator = iterator;
		 if (hasNext())
			  next = iterator.next();
	}

	public Integer peek() {
		 return next;
	}

	@Override
	public Integer next() {
		 Integer currVal = next;
		 if (iterator.hasNext())
			  next = iterator.next();
		 else
			  next = null;
		 return currVal;
	}

	@Override
	public boolean hasNext() {
		 return next != null || iterator.hasNext();
	}
}