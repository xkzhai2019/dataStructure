public interface Set<E> {
	// 1. 添加元素
	public void add(E e);
	
	// 2. 删除元素
	public void remove(E e);
	
	// 3. 判断是否为空
	public boolean isEmpty();
	
	// 4. 查看集合内元素个数
	public int getSize();
	
	// 5. 判断是否包含某元素
	public boolean contains(E e);

}
