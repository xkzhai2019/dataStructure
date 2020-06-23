public class LoopQueue<E> implements Queue<E> {
	private E[] data;
	private int size;
	private int front,tail;
	
	public LoopQueue(int capacity) {
		data = (E[])new Object[capacity + 1];//循环队列要预留一个空间
		front = 0;
		tail = 0;
		size = 0;
 	}
	// 缺省构造
	public LoopQueue() {
		this(10);
	}
	
	@Override
	public boolean isEmpty() {
		return front == tail;
	}
	
	@Override
	public int getSize() {
		return size;
	}
	
	public int getCapacity() {
		return data.length - 1;
	}
	
	@Override
	public void enqueue(E e) {
		// 如果队列已满，扩容
		if(front == (tail + 1)%data.length) {
			resize(getCapacity()*2);
		}
		// 将元素添加到队尾
		data[tail] = e;
		// tail 向后移一位，循环移位
		tail = (tail + 1) % data.length;
		size++;
		
	}
	private void resize(int newCapacity) {
		E[] newData = (E[])new Object[newCapacity + 1];
		for(int i =0 ; i<size;i++) {
			// 新队列的首位存储旧队列的front
			newData[i] = data[(i+front)%data.length];
		}
		data = newData;
		front = 0;
		tail = size;
	}
	
	@Override
	public E dequeue() {
		if(isEmpty()) {
			throw new IllegalArgumentException("Dequeue failed. Queue is empty.");
		}
		// 取出队首元素，并将队首置空
		E res = data[front];
		data[front] = null;
		// front 向后移一位，循环
		front = (front + 1)%data.length;
		size--;
		
		// 当队列元素等于容量的1/4时，缩小一半队列容量
		if(size == getCapacity() / 4 && getCapacity() / 2 != 0){
			resize(getCapacity() / 2);
		}
		return res;
	}
	
	@Override
	public E getFront() {
		if(isEmpty()) {
			throw new IllegalArgumentException("Queue is empty.");
		}
		return data[front];
	}
	
	@Override
	public String toString() {
		StringBuilder res = new StringBuilder();
		res.append(String.format("LoopQueue: size = %d , capacity = %d\n", size, getCapacity()));
		res.append("front "+"[");
		// 从队首开始循环，直到队尾结束
		for(int i = front; i != tail ;i = (i+1)%data.length) {
			res.append(data[i]);
			// 未达到队尾时，添加间隔符
			if((i+1)%data.length != tail)
				res.append(",");
		}
		res.append("] tail");
		return res.toString();
	}
	
	public static void main(String[] args) {
		LoopQueue<Integer> queue = new LoopQueue<>();
		for(int i = 0;i<10;i++) {
			queue.enqueue(i);
			System.out.println(queue);
			if(i%3==2) {
				queue.dequeue();
				System.out.println(queue);
			}
		}
	    /*
	        LoopQueue: size = 1 , capacity = 10
	        front [0] tail
	        LoopQueue: size = 2 , capacity = 10
	        front [0,1] tail
	        LoopQueue: size = 3 , capacity = 10
	        front [0,1,2] tail
	        LoopQueue: size = 2 , capacity = 5
	        front [1,2] tail
	        LoopQueue: size = 3 , capacity = 5
	        front [1,2,3] tail
	        LoopQueue: size = 4 , capacity = 5
	        front [1,2,3,4] tail
	        LoopQueue: size = 5 , capacity = 5
	        front [1,2,3,4,5] tail
	        LoopQueue: size = 4 , capacity = 5
	        front [2,3,4,5] tail
	     */
	}
	
}
