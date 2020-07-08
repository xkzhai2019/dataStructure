public interface UF {
	  int getSize(); // 节点个数​
	  boolean isConnected(int p, int q); // 判断两个节点是否连接
	  void unionElements(int p,int q); // 合并两个集合
	}
