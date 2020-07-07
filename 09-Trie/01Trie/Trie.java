// 使用java自有Map类
import java.util.TreeMap;

public class Trie {
	// 私有类
	private class Node{
		public boolean isWord;
		public TreeMap<Character,Node> next;
		
		public Node(boolean isWord) {
			this.isWord = isWord;
			next = new TreeMap<>();
		}
		
		public Node() {
			this(false);
		}
	}
	
	private Node root;
	private int size;
	
	public Trie() {
		root = new Node();
		size = 0;
	}
	
	// 获得Trie中存储的单词数量
	public int getSize(){
		return size;
	}
	
	// 向Trie中添加一个新的单词word
	// 练习：递归写法
	public void add(String word) {
		Node cur = root;
		for(int i=0;i<word.length();i++) {
			char c = word.charAt(i);
			// 如果当前节点的下一层不包含该字符，则构造新的结点
			if(cur.next.get(c)==null) {
				cur.next.put(c, new Node());
			}
			// 否则获取下一层节点
			cur = cur.next.get(c);
		}
		// 添加单词结束后，判断当前节点是否是词尾节点，如果是，则无需进一步添加单词
		if(!cur.isWord) {
			cur.isWord = true;
			size ++ ;
		}
	}
	
	// 查询单词word是否在Trie中
	// 练习：递归写法
	public boolean contains(String word) {
		Node cur = root;
		for(int i=0;i<word.length();i++) {
			char c = word.charAt(i);
			if(cur.next.get(c)==null) {
				return false;
			}
			cur = cur.next.get(c);
		}
		// 如果节点是词尾节点，才能返回true
		return cur.isWord;
	}
}
