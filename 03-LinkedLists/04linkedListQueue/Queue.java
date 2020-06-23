public interface Queue<E> {
	
	int getSize(); // 返回队列大小
	boolean isEmpty(); // 判断队列是否为空
	
	E getFront(); // 取出队首元素
	void enqueue(E e); // 入队
	E dequeue(); // 出队
}
