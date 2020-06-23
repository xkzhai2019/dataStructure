public interface Stack<E> {
	
	int getSize(); // 返回栈中元素个数
	boolean isEmpty(); // 判断栈是否为空
	
	E peek(); // 返回栈顶元素
	E pop(); // 出栈
  	void push(E e); // 入栈
	
}
