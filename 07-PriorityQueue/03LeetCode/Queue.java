public interface Queue<E> {
	void enqueue(E e);
	E dequeue();
	boolean isEmpty();
	E getFront();
	int getSize();
}
