public class LinkedListQueue<E> implements Queue<E> {
	private int size;
	private Node head; // 头节点，出队
	private Node tail; // 尾节点，入队
	
	// 私有节点类
	private class Node{
		private E e;
		private Node next;
		
		public Node(E e,Node next) {
			this.e = e;
			this.next = next;
		}
		
		public Node(E e) {
			this.e = e;
			next = null;
		}
		
		public Node() {
			this(null,null);
		}
		
		@Override
		public String toString() {
			return e.toString();
		}
	}
	
	public LinkedListQueue() {
		head = new Node();
		tail = new Node();
		size = 0;
	}
	
	@Override
	public int getSize() {
		return size;
	}
	
	@Override
	public boolean isEmpty() {
		return size == 0;
	}
	
	@Override
	// 从tail端入队
	public void enqueue(E e) {
		// 如果队列为空，head，tail均指向第一个入队元素
		if(isEmpty()) {
			tail = new Node(e);
			head = tail;
		}
		// 队列不为空，则添加到尾节点，并维护tail指向
		else {
			tail.next = new Node(e);
			tail = tail.next;			
		}
		size ++;	
	}
	
	@Override
	// 从head端出队,返回出队元素
	public E dequeue() {
		// 若队列为空，抛异常
		if(isEmpty())
			throw new IllegalArgumentException("dequeue Failed. The queue is empty.");
		// 队列不为空，删除头节点，维护head指向
		Node delNode = head;
		head = head.next;
		// 删除后，若队列为空，维护tail指向（若不维护，tail仍指向待删除元素）
		if(head == null) {
			tail = null;
		}
		delNode.next = null;
		size --;
		return delNode.e;
	}
	
	@Override
	public E getFront() {
		if(isEmpty())
			throw new IllegalArgumentException("Get Failed. The queue is empty.");
		return head.e;
	}
	
	@Override
	public String toString() {
		StringBuilder res = new StringBuilder();
		res.append("Queue: head ");
		Node cur = head;
		while(cur != null) {
			res.append(cur.e+"<-");				
			cur = cur.next;
		}
		res.append("tail");
		return res.toString();
	}
	
	public static void main(String[] args) {
		LinkedListQueue<Integer> queue = new LinkedListQueue<>();
		for(int i = 0;i<10;i++) {
			queue.enqueue(i);
			System.out.println(queue);
			if(i%3==2) {
				queue.dequeue();
				System.out.println(queue);
//				Queue: head 0<-tail
//				Queue: head 0<-1<-tail
//				Queue: head 0<-1<-2<-tail
//				Queue: head 1<-2<-tail
//				Queue: head 1<-2<-3<-tail
//				Queue: head 1<-2<-3<-4<-tail
//				Queue: head 1<-2<-3<-4<-5<-tail
//				Queue: head 2<-3<-4<-5<-tail
//				Queue: head 2<-3<-4<-5<-6<-tail
//				Queue: head 2<-3<-4<-5<-6<-7<-tail
//				Queue: head 2<-3<-4<-5<-6<-7<-8<-tail
//				Queue: head 3<-4<-5<-6<-7<-8<-tail
//				Queue: head 3<-4<-5<-6<-7<-8<-9<-tail
			}
		}
	}
	
}
