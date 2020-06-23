public class ArrayStack<E> implements Stack<E> {
	DynamicArray<E> Array;
	
	public ArrayStack(int capacity) {
		Array = new DynamicArray<>(capacity);
	}
	
	public ArrayStack() {
		Array = new DynamicArray<>();
	}
	
	
	@Override
	public int getSize() {
		return Array.getSize();
	}
	
	@Override
	public boolean isEmpty() {
		return Array.isEmpty();
	}
	
	@Override
	public void push(E e) {
		Array.addLast(e);		
	}
	
	@Override
	public E peek() {
		return Array.getLast();
	}
	
	@Override
	public E pop() {
		return Array.removeLast();
	}
	
	@Override
	public String toString() {
		StringBuilder res = new StringBuilder();
		res.append("Stack: ");
		res.append("[");
		for(int i = 0;i<Array.getSize();i++) {
			res.append(Array.get(i));
			if(i != Array.getSize() - 1)
				res.append(",");
		}
		res.append("] top");
		return res.toString();
	}

}
