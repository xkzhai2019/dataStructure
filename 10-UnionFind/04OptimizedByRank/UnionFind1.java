// Version 1.0
public class UnionFind1 implements UF {
	private int[] id;
	public UnionFind1(int size) {
		id = new int[size];
		
		// 初始化后，再进行合并操作
		for(int i=0;i<id.length;i++)
			id[i] = i;
	}
	
	@Override
	public int getSize() {
		return id.length;
	}
	
	// 查找元素p所对应的集合编号
	private int find(int p) {
		if(p<0 && p>=id.length)
			throw new IllegalArgumentException("p is out of bound.");
		// 第一版
		return id[p];
	}
	
	// 查看元素p和元素q是否所属同一集合
	@Override
	public boolean isConnected(int p, int q) {
		return find(p) == find(q); // 判断所属集合编号是否相同​
	}
	
	// 合并元素p和元素q所属的集合
	@Override
	public void unionElements(int p, int q) {
		int pID = find(p);
		int qID = find(q);
		// 如果两个元素原本就在同一集合，则无需合并
		if(pID==qID)
			return;
		// 遍历所有节点，将与p元素在同一集合内的元素的id改写为q元素的id
		for(int i= 0;i<id.length;i++) {
			if(id[i] == pID)
				id[i] = qID;
		}
	}
}
