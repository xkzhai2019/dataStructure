// Version 2.0
public class UnionFind2 implements UF {
	private int[] parent;
	public UnionFind2(int size) {
		parent = new int[size];
		
		for(int i=0;i<size;i++)
			parent[i] = i;
	}
	
	@Override
	public int getSize() {
		return parent.length;
	}
	
	// 查找过程，查找元素p所对应的集合编号
	// O(h)复杂度，h为树的高度
	private int find(int p) {
		
		if(p<0 && p>=parent.length)
			throw new IllegalArgumentException("p is out of bound.");
		// 查找元素p所在根节点(parent指向自己)
		while(p!=parent[p]) {
			p = parent[p];
		}
		return p;
	}
	
	// 查找元素p和元素q是否所属同一集合
	// O(h)复杂度，h为树的高度
	@Override
	public boolean isConnected(int p, int q) {
		return find(p)==find(q);
	}
	
	// 合并元素p和元素q所属的集合
	// O(h)复杂度，h为树的高度
	@Override
	public void unionElements(int p, int q) {
		int pRoot = find(p);
		int qRoot = find(q);
		// 如果元素p,q的根结点相同，则无需合并
		if(pRoot==qRoot)
			return;
		// 否则将元素p的根结点的parent指向元素q的根节点
		parent[pRoot] = qRoot;
	}
	
}
