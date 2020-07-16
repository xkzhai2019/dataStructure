import java.util.TreeMap;

public class HashTable3<K,V> {
	
	private static final int upperTol = 10;
	private static final int lowerTol = 2;
	private  int capacityIndex = 0;
	
	private final int[] capacity = {53,97,193,389,769,1543,3079,6151,12289,24593,
			49157,98317,196613,393241,786433,1572869,3135739};
	
	
	private TreeMap<K,V>[] hashtable; // 一个TreeMap数组
	private int M; // 数组长度
	private int size; // 哈希表中存储的元素个数
	
//	public HashTable(int M) {
//		this.M = M;
//		size = 0;
//		hashtable = new TreeMap[M];
//		for(int i = 0; i<M; i++)
//			hashtable[i] = new TreeMap<>();
//	}
	// 不再让用户指定M值
	public HashTable3() {
		this.M = capacity[capacityIndex];
		size = 0;
		hashtable = new TreeMap[M];
		for(int i = 0; i<M; i++)
			hashtable[i] = new TreeMap<>();
	}
	
	
	private int hash(K key) {
		return (key.hashCode() & 0x7fffffff) % M;
	}
	
	public int getSize() {
		return size;
	}
	
	public void add(K key,V value) {
		
		TreeMap<K,V> map = hashtable[hash(key)];
		
		if(map.containsKey(key)) // 如果包含，则更新旧值
			map.put(key, value);
		else { // 否则，添加新值
			map.put(key, value);
			size ++ ;
			
			// 索引值不能超出静态数值的长度
			if(size >= upperTol*M && (capacityIndex + 1)< capacity.length) {
				capacityIndex ++;
				resize(capacity[capacityIndex]);
			}
		}
	}
	
	public V remove(K key) {
		TreeMap<K,V> map = hashtable[hash(key)];
		V ret = null;
		if(map.containsKey(key)) {
			ret = map.remove(key);
			size--;
			
			// 索引值不能小于0
			if(size < lowerTol * M && (capacityIndex - 1)>=0) {
				capacityIndex--;
				resize(capacity[capacityIndex]);
			}
		}
		return ret;
	}
	
	public void set(K key,V value) {
		TreeMap<K,V> map = hashtable[hash(key)];
		if(!map.containsKey(key)) 
			throw new IllegalArgumentException(key+"does not exist!");
		map.put(key, value);
	}
	
	public boolean contains(K key) {
		return hashtable[hash(key)].containsKey(key);
	}
	
	public V get(K key) {
		return hashtable[hash(key)].get(key);
	}
	
	private void resize(int newM) {
		TreeMap<K,V>[] newHashTable = new TreeMap[newM];
		for(int i=0;i<newM;i++)
			newHashTable[i] = new TreeMap<>();
		
		int oldM = M; // 记录原哈希表的M值，用作遍历元素
		this.M = newM; // 将哈希表的M值重设为新的M值，用作计算新元素的hash值
		
		for(int i=0;i<oldM;i++) {
			TreeMap<K,V> map = hashtable[i];
			for(K key:map.keySet()) {
				newHashTable[hash(key)].put(key, map.get(key));
			}
		}
		
		this.hashtable = newHashTable; // 将旧哈希表更新为新的哈希表
	}
}
