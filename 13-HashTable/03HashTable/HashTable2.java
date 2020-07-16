import java.util.TreeMap;

public class HashTable2<K,V> {
	
	private static final int upperTol = 10;
	private static final int lowerTol = 2;
	private static final int initCapacity = 7;
	
	private TreeMap<K,V>[] hashtable; // 一个TreeMap数组
	private int M; // 数组长度
	private int size; // 哈希表中存储的元素个数
	
	public HashTable2(int M) {
		this.M = M;
		size = 0;
		hashtable = new TreeMap[M];
		for(int i = 0; i<M; i++)
			hashtable[i] = new TreeMap<>();
	}
	
	public HashTable2() {
		this(initCapacity);
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
			
			if(size >= upperTol*M ) {
				resize(M*2);
			}
		}
	}
	
	public V remove(K key) {
		TreeMap<K,V> map = hashtable[hash(key)];
		V ret = null;
		if(map.containsKey(key)) {
			ret = map.remove(key);
			size--;
			
			if(size < lowerTol * M && M/2 >= initCapacity) {
				resize(M/2);
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
