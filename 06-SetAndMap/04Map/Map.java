public interface Map<K,V> {
	// 1. 获取map中键值对个数
	public int getSize();
	// 2. 判断map是否为空
	public boolean isEmpty();
	// 3. 添加键值对
	public void add(K key,V value);
	// 4. 删除key对应的键值对，返回value
	public V remove(K key);
	// 5. 更新key对应的value
	public void set(K key,V value);
	// 6. 查询key对应的值
	public V get(K key);
	// 7. 判断是否包含指定的key
	public boolean contains(K key);
}
