public interface Queue<E> {
	void enqueue(E e);
	E dequeue(); // 优先级最高元素出队
	boolean isEmpty();
	E getFront(); // 获取优先级最高元素
	int getSize();
}
