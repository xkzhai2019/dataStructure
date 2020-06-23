public class LinkedList<E> {
	
	private class Node{
		private E e;
		private Node next;
		
		public Node(E e, Node next) {
			this.e = e;
			this.next = next;
		}
		
		public Node(E e){
			this(e,null);
		}
		
		public Node() {
			this(null,null);
		}
		
		@Override
		public String toString() {
			return e.toString();
		}
	}
	
	private Node head;
	private int size;
	
	public LinkedList() {
		head = new Node();
		size = 0;
	}
	
	// 获取链表中的元素个数
	public int getSize(){
		return size;
	}
	
	// 返回链表是否为空
	public boolean isEmpty() {
		return size == 0;
	}
	
	// 在链表头添加新的元素e
	public void addFirst(E e){
		Node  node = new Node(e,null);
		node.next = head;
		head = node;
		// head = new Node(e,head);
		size ++;
	}
	
	// 在链表的index（0-based）位置添加新的元素e
	// 非常规应用
	public void add(int index,E e) {
		if(index<0 || index >=size)
			throw new IllegalArgumentException("Add failed. Index is illegal. ");
		if (index == 0) {
			Node node = new Node(e);
			node.next = head;
			head = node;
		}
		else {
			// 从链表头开始，找到索引位置的前一位
			Node pre = head;
			for(int i=0;i<index - 1;i++) {
				pre = pre.next;
			}
			Node newNode = new Node(e);
			
			newNode.next = pre.next;
			pre.next = newNode;
			
			// pre.next = new Node(e,pre.next);
			size ++;
		}
	}
	
	// 在链表尾添加新元素e
	public void addLast(E e) {
		add(size,e);
	}
	
}
