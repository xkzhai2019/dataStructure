import java.util.ArrayList;


public class LinkedListMap<K,V> implements Map<K,V> {
	private class Node{
		private K key;
		private V value;
		private Node next;
		
		public Node(K key, V value, Node next) {
			this.key = key;
			this.value = value;
			this.next = next;
		}
		
		public Node(K key,V value){
			this(key,value,null);
		}
		
		public Node() {
			this(null,null,null);
		}
		
		@Override
		public String toString() {
			return "Key: "+key.toString()+"Value:"+value.toString();
		}
	}
	
	private Node dummyHead;
	private int size;
	
	public LinkedListMap() {
		dummyHead = new Node();
		size = 0;
	}
	
	// 1. 获取map中键值对个数
	public int getSize(){
		return size;
	}
	
	// 2. 判断map是否为空
	public boolean isEmpty() {
		return size == 0;
	}
	// 私有成员函数，根据key找到所在节点
	private Node getNode(K key) {
		Node cur = dummyHead.next;
		while(cur!=null) {
			if(cur.key.equals(key)) {
				return cur;
			}
			cur = cur.next;
		}
		return null;
	}
	
	// 7. 判断是否包含指定的key
	@Override
	public boolean contains(K key) {
		Node node = getNode(key);
		return node != null;
	}
	
	// 6. 查询key对应的值
	@Override
	public V get(K key) {
		Node node = getNode(key);
		return node.value;
	}
	// 3. 添加新的键值对
	@Override
	public void add(K key, V value) {
		
		if(contains(key)) { // 如果已包含该键，更新该键对应的值
			set(key,value);
		}
		else { // 如果不包含该键，添加到链表头
			Node node = new Node(key,value);
			node.next = dummyHead.next;
			dummyHead.next = node;
			size++;
		}
	}
	// 5. 更新key对应的value
	@Override
	public void set(K key, V value) {
		Node node = getNode(key);
		
		if(node!=null) {
			node.value = value;
			Node preNode = dummyHead.next;
			while(preNode.next!=null) {
				// 找到待更新结点的前一结点
				if(preNode.next.key.equals(key)) {
					node.next = preNode.next.next;
					preNode.next = node;
					return;
				}
				preNode = preNode.next;
			}
		}
	}
	
	// 4. 删除key对应的键值对，返回value
	@Override
	public V remove(K key) {
		Node pre = dummyHead;
		Node delNode = new Node();
		// 从虚拟头节点出发，找到待删除元素的前一节点
		while(pre.next!=null) {
			if(pre.next.key.equals(key))
				break;
			pre = pre.next;
		}
		// 如果找到的前一节点不是最后一个元素，则执行删除操作
		if(pre.next!=null) {
			delNode = pre.next;
			pre.next = delNode.next;
			delNode.next = null;
			size --;
		}
		return delNode.value;
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
