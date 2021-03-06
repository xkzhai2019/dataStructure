import java.util.ArrayList;
import java.util.Comparator;

public class AVLTree<K extends Comparable<K>,V> {
	private class Node{
		private K key;
		private V value;
		private Node left,right;
		public int height; // 节点的高度信息
		
		public Node(K key, V value) {
			this.key = key;
			this.value = value;
			left = null;
			right = null;
			height = 1;
		}
		
		@Override
		public String toString() {
			return "Key: "+key.toString()+"Value:"+value.toString();
		}
	}
	private Node root;
	private int size;
	
	public AVLTree() {
		root = null;
		size = 0;
	}
	

	public int getSize() {
		return size;
	}
	

	public boolean isEmpty() {
		return size == 0;
	}
	
	// 判断该二叉树是否是一棵二分搜索树
	public boolean isBST(){
		ArrayList<K> keys = new ArrayList<>();
		// 将树中元素中序遍历添加到列表中
		inOrder(root,keys);
		// 查看是否生成了有序列表
		for(int i=1;i<keys.size();i++)
			if(keys.get(i-1).compareTo(keys.get(i))>0)
				return false;
		return true;
	}
	
	private void inOrder(Node node,ArrayList<K> keys) {
		if(node==null)
			return;
		inOrder(node.left,keys);
		keys.add(node.key);
		inOrder(node.right,keys);
	}
	
	// 判断该二叉树是否是一个平衡二叉树
	public boolean isBalanced() {
		return isBalanced(root);
	}
	
	// 判断以Node为根的二叉树是否是一棵平衡二叉树，递归算法
	private boolean isBalanced(Node node) {
		if(node==null)
			return true;
		// 判断每个节点的平衡因子是否为-1，0，1​
		int balanceFactor = getBalanceFactor(node);
		if(Math.abs(balanceFactor)>1)
			return false;
		return isBalanced(node.left) && isBalanced(node.right);
	}
	 
	// 获得节点node的高度
	private int getHeight(Node node) {
		if(node==null)
			return 0;
		return node.height;
	}
	
	// 获得节点node的平衡因子
	private int getBalanceFactor(Node node) {
		if(node==null)
			return 0;
		return getHeight(node.left)-getHeight(node.right);
	}
	
	// 对节点y进行右旋转操作，返回旋转后新的根节点x
	//	     y                         x
	//    	/ \                       /  \
	//     x   T4  向右旋转 (y)       z     y
	//    / \     -------------->   / \   / \
	//   z  T3                     T1 T2 T3  T4
	//  / \
	// T1  T2
	private Node rightRotate(Node y) {
		Node x = y.left;
		Node T3 = x.right;
		
		// 向右旋转过程
		x.right = y;
		y.left = T3;
		
		// 更新height
		y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
		x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;
		
		return x;
	}
	
	// 对节点y进行左旋转操作，返回旋转后新的根节点x
	//	     y                               x
	//    	/ \                             /  \
	//     T1  x         向左旋转 (y)       y     z
	//    	  / \     -------------->     / \   / \
	//       T2  z                       T1 T2 T3  T4
	//  		/ \
	// 		   T3  T4
	private Node leftRotate(Node y) {
		Node x = y.right;
		Node T2 = x.left;
		
		// 向左旋转过程
		x.left = y;
		y.right = T2;
		
		// 更新height
		y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
		x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;
		
		return x;
	}
	
	// 向二分搜索树中添加新的元素（key,value）
	public void add(K key, V value) {
		root = add(root,key,value);
	}
	
	// 私有添加方法，递归向以node为根结点的二分搜索树中添加键值对
	// 返回插入新结点后二分搜索树的根
	private Node add(Node node,K key,V value) {
		// 如果节点为空，直接添加新节点即可
		if(node==null) {
			node = new Node(key,value);
			size++;
			return node;
		}
		// 如果添加的节点值小于根节点，则向根节点的左子树中添加
		if(node.key.compareTo(key)>0) {
			node.left = add(node.left,key,value);
		}
		else if(node.key.compareTo(key)<0) {
			node.right = add(node.right,key,value);
		}
		else { // node.key.compareTo(key)==0
			node.value = value;
		}
		// 更新height
		// 不管添加在哪一个位置，根结点的高度，始终等于左右子树的较大高度+1
		node.height = 1+ Math.max(getHeight(node.left), getHeight(node.right));
		// 计算平衡因子
		int balanceFactor = getBalanceFactor(node);
//		if(Math.abs(balanceFactor)>1)
//			System.out.println("unbalanced:"+ balanceFactor);
		
		// 平衡维护，右旋转
		// LL
		if(balanceFactor>1 &&  getBalanceFactor(node.left)>=0) {
			return rightRotate(node);
		}
		
		// 平衡维护，左旋转
		// RR
		if(balanceFactor< -1 &&  getBalanceFactor(node.right)<=0) {
			return leftRotate(node);
		}
		
		// LR
		if(balanceFactor>1 && getBalanceFactor(node.left)<0) {
			node.left = leftRotate(node.left);
			return rightRotate(node);
		}
		
		// RL
		if(balanceFactor< -1 &&  getBalanceFactor(node.right)>0) {
			node.right = rightRotate(node.right);
			return leftRotate(node);
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
	
	// 从二分搜索树中删除键为key的节点
	public V remove(K key) {
		Node node = getNode(root,key);
		if(node!=null) {
			root = remove(root,key);
			return node.value;
		}
		return null;
	}

	// 删除掉以node为根的二分搜索树中键为key的结点
    // 返回删除节点后新的二分搜索树的根
	private Node remove(Node node,K key) {
		if(node == null) {
			return null;
		}
		Node retNode;
		
		if(node.key.compareTo(key)>0) {
			node.left = remove(node.left,key);
			retNode = node;
			//return node;
		}
		else if(node.key.compareTo(key)<0) {
			node.right = remove(node.right,key);
			retNode = node;
		}
		else { // node.key.compareTo(key)==0
			// 待删除结点右子树为空的情况
			if(node.right == null) {
				Node leftNode = node.left;
				node.left = null;
				size--;
				retNode = leftNode;
			}
			// 待删除结点左子树为空的情况
			else if(node.left == null) {
				Node rightNode = node.right;
				node.right = null;
				size--;
				retNode = rightNode;
			}
			
			else{// 待删除节点左右子树均不为空的情况

	            // 找到比待删除节点大的最小节点, 即待删除节点右子树的最小节点
	            // 用这个节点顶替待删除节点的位置
				Node successor = minimize(node.right);
				successor.right = remove(node.right,successor.key);
				successor.left = node.left;
				
				node.left = node.right = null;
				retNode = successor;
			}
		}
		 // 若删除后，节点为空，则需要直接返回null
		if (retNode == null)
			return null;
		
		// 更新height
		retNode.height = 1+ Math.max(getHeight(retNode.left), getHeight(retNode.right));
		// 计算平衡因子
		int balanceFactor = getBalanceFactor(retNode);
				
		// 平衡维护，右旋转
		// LL
		if(balanceFactor>1 &&  getBalanceFactor(retNode.left)>=0) {
			return rightRotate(retNode);
		}
				
		// 平衡维护，左旋转
		// RR
		if(balanceFactor< -1 &&  getBalanceFactor(retNode.right)<=0) {
			return leftRotate(node);
		}
				
		// LR
		if(balanceFactor>1 && getBalanceFactor(retNode.left)<0) {
			retNode.left = leftRotate(retNode.left);
			return rightRotate(retNode);
		}
				
		// RL
		if(balanceFactor< -1 &&  getBalanceFactor(retNode.right)>0) {
			retNode.right = rightRotate(retNode.right);
			return leftRotate(retNode);
		}
		
		return retNode;
	}
	
	public static void main(String[] args){

        System.out.println("Pride and Prejudice");

        ArrayList<String> words = new ArrayList<>();
        if(FileOperation.readFile("pride-and-prejudice.txt", words)) {
            System.out.println("Total words: " + words.size()); // 125901

            AVLTree<String, Integer> map = new AVLTree<>();
            for (String word : words) {
                if (map.contains(word))
                    map.set(word, map.get(word) + 1);
                else
                    map.add(word, 1);
            }

            System.out.println("Total different words: " + map.getSize()); // 6530
            System.out.println("Frequency of PRIDE: " + map.get("pride")); // 53
            System.out.println("Frequency of PREJUDICE: " + map.get("prejudice")); // 11
            
            System.out.println("is BST: " + map.isBST()); // true
            System.out.println("is Balanced: "+ map.isBalanced()); // true
            
            for(String word: words) {
            	map.remove(word);
            	if(!map.isBST() || !map.isBalanced())
            		throw new RuntimeException("Error");
            }
        }

        System.out.println();
    }
}

