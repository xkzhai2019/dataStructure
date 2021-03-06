import java.util.ArrayList;
import java.util.Comparator;

public class BST<K extends Comparable<K>,V> {
	private class Node{
		private K key;
		private V value;
		private Node left,right;
		public Node(K key, V value) {
			this.key = key;
			this.value = value;
			left = null;
			right = null;
		}
		
		@Override
		public String toString() {
			return "Key: "+key.toString()+"Value:"+value.toString();
		}
	}
	private Node root;
	private int size;
	
	public BST() {
		root = null;
		size = 0;
	}
	

	public int getSize() {
		return size;
	}
	

	public boolean isEmpty() {
		return size == 0;
	}
	
	// 向二分搜索树中添加新的元素（key,value）

	public void add(K key, V value) {
		root = add(root,key,value);
	}
	
	// 私有添加方法，递归向以node为根结点的二分搜索树中添加键值对
	// 返回插入新结点后二分搜索树的根
	private Node add(Node node,K key,V value) {
		if(node==null) {
			node = new Node(key,value);
			size++;
			return node;
		}
		if(node.key.compareTo(key)>0) {
			node.left = add(node.left,key,value);
		}
		else if(node.key.compareTo(key)<0) {
			node.right = add(node.right,key,value);
		}
		else { // node.key.compareTo(key)==0
			node.value = value;
		}
		return node;
	}
	
	// 返回以node为根节点的二分搜索树中，key所在的节点
	private Node getNode(Node node,K key) {
		if(node==null) {
			return null;
		}
		if(node.key.compareTo(key)>0) {
			return getNode(node.left,key);
		}
		else if(node.key.compareTo(key)<0) {
			return getNode(node.right,key);
		}
		else { // node.key.compareTo(key)==0
			return node;
		}
	}
	

	public boolean contains(K key) {
		return getNode(root,key)!=null;
	}
	
	public V get(K key) {
		Node node = getNode(root,key);
		return (node == null)?null:node.value;
	}
	

	public void set(K key, V newValue) {
		Node node = getNode(root,key);
		if(node==null)
			throw new IllegalArgumentException(key+" doesn't exist!");
		node.value = newValue;
	}
	
	// 返回以node为根的二分搜索树的最小值所在的节点
	private Node minimize(Node node) {
		if(node.left==null) {
			return node;
		}
		return minimize(node.left);
	}
	
	// 删除掉以node为根的二分搜索树中的最小节点
    // 返回删除节点后新的二分搜索树的根
	private Node removeMin(Node node){
		if(node.left == null) {
			Node rightNode = node.right;
			node.right = null;
			size --;
			return rightNode;
		}
		
		node.left = removeMin(node.left);
		return node;
	}
	
	// 从二分搜索树中删除键为key的节点
	public V remove(K key) {
		Node node = getNode(root,key);
		if(node!=null) {
			root = remove(root,key);
		}
		return node.value;
	}

	// 删除掉以node为根的二分搜索树中键为key的结点
    // 返回删除节点后新的二分搜索树的根
	private Node remove(Node node,K key) {
		if(node==null) {
			return null;
		}
		if(node.key.compareTo(key)>0) {
			node.left = remove(node.left,key);
			return node;
		}
		else if(node.key.compareTo(key)<0) {
			node.right = remove(node.right,key);
			return node;
		}
		else { // node.key.compareTo(key)==0
			// 待删除结点右子树为空的情况
			if(node.right==null) {
				Node leftNode = node.left;
				node.left = null;
				size--;
				return leftNode;
			}
			// 待删除结点左子树为空的情况
			if(node.left==null) {
				Node rightNode = node.right;
				node.right = null;
				size--;
				return rightNode;
			}
			// 待删除节点左右子树均不为空的情况

            // 找到比待删除节点大的最小节点, 即待删除节点右子树的最小节点
            // 用这个节点顶替待删除节点的位置
			Node successor = minimize(node.right);
			successor.right = removeMin(node.right);
			successor.left = node.left;
			
			node.left = node.right = null;
			return successor;
		}
	}
	
	public static void main(String[] args){

        System.out.println("Pride and Prejudice");

        ArrayList<String> words = new ArrayList<>();
        if(FileOperation.readFile("pride-and-prejudice.txt", words)) {
            System.out.println("Total words: " + words.size()); // 125901

            BST<String, Integer> map = new BST<>();
            for (String word : words) {
                if (map.contains(word))
                    map.set(word, map.get(word) + 1);
                else
                    map.add(word, 1);
            }

            System.out.println("Total different words: " + map.getSize()); // 6530
            System.out.println("Frequency of PRIDE: " + map.get("pride")); // 53
            System.out.println("Frequency of PREJUDICE: " + map.get("prejudice")); // 11
        }

        System.out.println();
    }
}
