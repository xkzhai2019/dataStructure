import java.util.TreeMap;

class WordDictionary {
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

    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new Node();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        Node cur = root;
		for(int i=0;i<word.length();i++) {
			char c = word.charAt(i);
			if(cur.next.get(c)==null) {
				cur.next.put(c, new Node());
			}
			cur = cur.next.get(c);
		}
		if(!cur.isWord) {
			cur.isWord = true;
		}
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return match(root,word,0);
    }

    // 私有匹配函数
    // 从node出发，依次查找是否存在word在index处的字符
    private boolean match(Node node,String word,int index){
        // 如果word中的字符全部查找完毕，则根据尾节点的isWord返回是否存在word
        if(index==word.length()){
            return node.isWord;
        }
        char c = word.charAt(index);
        // 如果c是字符，直接通过key值查询
        if(c!='.'){
            // 如果不存在这样的字符，则返回false
            if(node.next.get(c)==null){
                return false;
            }
            // 如果存在，则向下继续查找word下一位置的字符
            return match(node.next.get(c),word,index+1);
        }
        else{ // 如果word在index处的字符是通配符.,遍历node的所有子节点
            for(char nextChar: node.next.keySet()){
                // 递归查找word下一位置字符
    			if(match(node.next.get(nextChar),word,index+1))
    				return true;
            }
            // 所有键查询完毕，依然查不到，则返回false
    		return false;
        }

    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
