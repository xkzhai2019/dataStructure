public class LinkedListStack<E> implements Stack<E> {
	// 私有成员变量LinkedList用来存储栈元素
	private LinkedList<E> list;
	
	public LinkedListStack() {
		list = new LinkedList<E>();
	}
	
	@Override
	public int getSize() {
		return list.getSize();
	}
	
	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}
	@Override
	public void push(E e) {
		list.addFirst(e);	
	}
	
	@Override
	public E pop() {
		return list.removeFirst();
	}
	
	@Override
	public E peek() {
		return list.getFirst();
	}
	
	@Override
	public String toString() {
		StringBuilder res = new StringBuilder();
		res.append("Stack: Top ");
		res.append(list);
		return res.toString();
	}
	
	public static void main(String[] args) {
		LinkedListStack<Integer> stack = new LinkedListStack<>(); 
		for(int i = 0;i<5;i++) {
			stack.push(i);
			System.out.println(stack);
			// Stack: Top 0-->NULL
			// Stack: Top 1-->0-->NULL
			// Stack: Top 2-->1-->0-->NULL
			// Stack: Top 3-->2-->1-->0-->NULL
			// Stack: Top 4-->3-->2-->1-->0-->NULL
		}
		stack.pop();
		System.out.println(stack);
		// Stack: Top 3-->2-->1-->0-->NULL
	}
}
