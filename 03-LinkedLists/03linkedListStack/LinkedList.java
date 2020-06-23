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
	
	private Node dummyHead;
	private int size;
	
	public LinkedList() {
		dummyHead = new Node();
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
	
	// 在链表的index（0-based）位置添加新的元素e
	// 使用虚拟链表头，可以不单独处理链表头的插入操作
	public void add(int index,E e) {
		if(index<0 || index >size)
			throw new IllegalArgumentException("Add failed. Index is illegal. ");
		
		// 从虚拟链表头开始，找到索引位置的前一位
		Node pre = dummyHead;
		for(int i=0;i<index;i++) {
			pre = pre.next;
		}
		Node newNode = new Node(e);
		
		newNode.next = pre.next;
		pre.next = newNode;
		
		// pre.next = new Node(e,pre.next);
		size ++;
	}
	
	// 在链表头插入新元素e
	public void addFirst(E e) {
		add(0,e);
	}
	
	// 在链表尾添加新元素e
	public void addLast(E e) {
		add(size,e);
	}
	// 在链表中查找元素
	public boolean contains(E e) {
		Node cur = dummyHead.next;
		while(cur!=null) {
			if(cur.e.equals(e))
				return true;
			cur = cur.next;
		}
		return false;
	}
	
	// 获得链表的第index(0-based)个位置的元素
	public E get(int index) {
		if(index<0 || index >=size)
			throw new IllegalArgumentException("Get failed. Index is illegal. ");
		Node cur = dummyHead.next;
		for(int i = 0;i<index;i++) {
			cur = cur.next;
		}
		return cur.e;
	}
	
	// 获得链表的第一个元素
	public E getFirst() {
		return get(0);
	}
	
	// 获得链表的最后一个元素
	public E getLast() {
		return get(size-1);
	}
	
	// 修改链表的第index（0-based）个位置的元素为e
	public void set(int index,E e) {
		if(index<0 || index >=size)
			throw new IllegalArgumentException("Set failed. Index is illegal. ");
		Node cur = dummyHead.next;
		for(int i=0;i<index;i++) {
			cur = cur.next;
		}
		cur.e = e;
	}
	
	// 从链表中删除index(0-based)位置的元素, 返回删除的元素
	public E remove(int index) {
		if(index<0 || index >=size)
			throw new IllegalArgumentException("Set failed. Index is illegal. ");
		// 从虚拟链表头开始，找到索引前一位的结点
		Node pre = dummyHead;
		for(int i = 0;i<index;i++) {
			pre = pre.next;
		}
		Node cur = pre.next;
		pre.next = cur.next;
		cur.next = null;
		
		size--;
		
		return cur.e;
		
	}
	
	// 从链表删除第一个元素，返回删除的元素
	public E removeFirst() {
		return remove(0);
	}
	
	// 删除链表尾的元素，返回删除的元素
	public E removeLast() {
		return remove(size-1);
	}
	// 从链表中删除元素e
	public void removeElement(E e) {
		Node pre = dummyHead;
		while(pre.next!=null) {
			if(pre.next.e.equals(e))
				break;
			pre = pre.next;
		}
		if(pre.next!=null) {
			Node delNode = pre.next;
			pre.next = delNode.next;
			delNode.next = null;
			size --;
		}
		else {
			// throw new IllegalArgumentException("Remove failed. The element is not included in list.");			
		}
		
	}
	
	@Override
	public String toString() {
		StringBuilder res = new StringBuilder();
		Node cur = dummyHead.next;
		while(cur!=null) {
			res.append(cur+"-->");
			cur = cur.next;
		}
		res.append("NULL");
		return res.toString();
	}
}

