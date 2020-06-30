import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BST<E extends Comparable<E>> {
	private class Node{
		public E e;
		public Node left;
		public Node right;
		public Node(E e) {
			this.e = e;
			left = null;
			right = null;
		}
	} 
	private Node root;
	private int size;
	
	public BST() {
		root = null;
		size = 0;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	public int getSize() {
		return size;
	}
	
	// 公有方法添加元素
	public void addElement(E e) {
		// 调用私有添加方法向根结点所在树添加元素
		root = addElement(root, e);
	}
	// 私有方法，向以node结点为根的二分搜索树中添加元素
	private Node addElement(Node node,E e) {
		if(node==null) {
			node = new Node(e);
			size++;
			return node;
		}
		if(e.compareTo(node.e)<0) {
			// 递归实现，添加元素小于node，向node的左子树中添加元素
			node.left = addElement(node.left,e);
		}
		if(e.compareTo(node.e)>0) {
			// 递归实现，添加元素大于node，向node的右子树中添加元素
			node.right = addElement(node.right,e);
		}
		return node;
	}
	
	// 查看二分搜索树中是否包含元素e
	public boolean contains(E e){
		// 调用私有方法
		return contains(root,e);
	}
	
	// 查看以node 为根的二分搜索树中是否包含元素e
	private boolean contains(Node node,E e) {
		if(node==null) {
			return false;
		}
		if(e.equals(node.e))
			return true;
		if(e.compareTo(node.e)<0) {
			return contains(node.left,e);
		}
		else
			return contains(node.right,e);
	}
	
	// 前序遍历二分搜索树
	public void preOrder() {
		preOrder(root);
	}
	
	// 前序遍历以node为根的二分搜索树
	private void preOrder(Node node) {
		if(node==null) {
			return;
		}
		System.out.println(node.e);
		preOrder(node.left);
		preOrder(node.right);
	}
	
	// 中序遍历
	public void inOrder() {
		inOrder(root);
	}
	
	private void inOrder(Node node) {
		if(node==null) {
			return;
		}
		inOrder(node.left);
		System.out.println(node.e);
		inOrder(node.right);
	}
	
	// 后序遍历
	public void postOrder() {
		postOrder(root);
	}
	private void postOrder(Node node) {
		if(node==null) {
			return;
		}
		postOrder(node.left);
		postOrder(node.right);
		System.out.println(node.e);
	}
	
	// 前序遍历，非递归写法
	public void preOderNR() {
		if(root==null) {
			return;
		}
		Stack<Node> stack = new Stack();
		stack.push(root);
		while(!stack.isEmpty()) {
			Node node = stack.pop();
			System.out.println(node.e);
			if(node.right!=null) {
				stack.push(node.right);				
			}
			if(node.left!=null) {
				stack.push(node.left);				
			}
		}
	}
	
	// 层序遍历，广度优先遍历
	public void levelOrder() {
		if(root==null) {
			return;
		}
		Queue<Node> queue = new LinkedList<>();
		// 根节点入队
		queue.add(root);
		
		// 队列不为空时
		while(!queue.isEmpty()) {
			// 队首元素出队，记为cur节点
			Node cur = queue.remove();
			
			System.out.println(cur.e);
			// cur节点的左孩子不为空时，入队
			if(cur.left!=null) {
				queue.add(cur.left);
			}
			// cur节点的右孩子不为空时，入队
			if(cur.right!=null) {
				queue.add(cur.right);
			}
		}
 	}
	//  删除二分搜索树中的最小值,返回删除后的根结点
	public Node removeMin(){
		// 如果根节点为空，抛异常（可选操作）
		if(root==null) {
			throw new IllegalArgumentException("Remove failed. The tree is empty.");
		}
		// 删除根节点所在树的最小值，并返回删除后的根结点
		root = removeMin(root);
		return root;
	}
	
	// 从以node 为根的二分搜索树中删除最小值,返回删除后的根结点
	private Node removeMin(Node node) {
		// 如果节点左孩子为空，说明该节点即为最小值，直接删除
		if(node.left==null) {
			node = node.right;
			size--;
		}
		// 如果节点左孩子不为空，递归从以左孩子为根结点的二分搜索树中删除最小值，并返回删除后的根节点
		else {
			node.left = removeMin(node.left);
		}
		return node;
	}
	
	//  删除二分搜索树中的最大值,返回删除后的根结点
	public Node removeMax(){
		if(root==null)
			throw new IllegalArgumentException("Remove failed. The tree is empty.");
		else {
			root = removeMax(root);
			return root;
		}
	}
	
	// 从以node 为根的二分搜索树中删除最大值,返回删除后的根结点
	private Node removeMax(Node node) {
		if(node.right==null) {
			node = node.left;
			size--;
		}
		else {
			node.right =removeMax(node.right);
		}
		return node;
	}
	
	// 找到二分搜索树中的最小值
	public E minimum(){
		if(size==0)
			throw new IllegalArgumentException("The tree is empty.");
		else {
			// 调用私有最小值函数
			// 找到以root为根节点的二分搜索树中的最小值所在节点
			Node minNode = minimum(root);
			return minNode.e;			
		}
	}
	
	// 找到以node为结点的二分搜索树的最小值所在结点
	private Node minimum(Node node) {
		// 如果node节点的左孩子为空，表明node即为最小值所在节点
		if(node.left==null) {
			return node;
		}
		else // node节点的左孩子不为空，则递归查找node节点左子树中的最小值所在节点
			return minimum(node.left);
	}
	
	// 找到二分搜索树中的最大值
	public E maxmum(){
		if(size==0)
			throw new IllegalArgumentException("The tree is empty.");
		else {
			// 调用私有最大值函数
			// 找到以root为根节点的二分搜索树中的最大值所在节点
			Node maxNode = maxmum(root);
			return maxNode.e;			
		}
	}
		
	// 找到以node 为结点的二分搜索树的最大值所在结点
	private Node maxmum(Node node) {
		// 如果node节点的右孩子为空，表明node即为最大值所在节点
		if(node.right==null) {
			return node;
		}
		else // node节点的右孩子不为空，则递归查找node节点右子树中的最大值所在节点
			return maxmum(node.right);
	}
		
	// 移除最小值所在节点,返回移除的元素
	public E removeMin2(){
		if(size==0) {
			throw new IllegalArgumentException("The tree is empty.");
		}
		// 找到以root为根节点的二分搜索树的最小值所在节点
		Node res = minimum(root);
		// 调用私有移除方法
		// 移除以root结点为根的二分搜索树的最小值所在节点，返回移除后的根结点
		root = removeMin2(root);
		return res.e;
	}
		
	// 移除以node结点为根的二分搜索树的最小值，返回移除后的根结点
	public Node removeMin2(Node node) {
		if(node.left==null) {
			node = node.right;
			size--;
		}
		else
			node.left = removeMin2(node.left);
		return node;
	}
		
	// 移除最大值的第二种实现，返回移除的元素
	public E removeMax2() {
		if(size==0)
			throw new IllegalArgumentException("The tree is empty.");
		Node delNode = maxmum(root);
		root = removeMax2(root);
		return delNode.e;
	}
		
	// 移除以node为根的二分搜索树的最大值，返回移除后的根结点
	private Node removeMax2(Node node) {
		if(node.right==null) {
			node = node.left;
			size--;
		}
		else {
			node.right = removeMax2(node.right);
		}
		return node;
	}
	
	// 移除二分搜索树中的任意元素e
	public void removeElement(E e) {
		// 如果树为空，则抛异常（可选择操作）
		if(size==0)
			throw new IllegalArgumentException("The tree is empty.");
		// 调用私有方法，从以root为根的二分搜索树中删除元素e
		root = removeElement(root,e);
	}
	// 从以node为根结点的二分搜索树种删除元素e，返回删除后的根结点
	private Node removeElement(Node node,E e) {
		// 如果node为空，表明没有找到该元素
		if(node==null) {
			return null;
		}
		// 如果node节点就是要删除的元素
		// 分三种情况分别处理
		if(e.equals(node.e)) {			
			// 待删除结点左子树为空的情况
			if(node.left==null) {
				Node rightNode = node.right;
				node.right = null;
				size--;
				return rightNode;
			}
			// 待删除结点右子树为空的情况
			if(node.right==null) {
				Node leftNode = node.left;
				node.left = null;
				size--;
				return leftNode;
			}
			// 待删除结点左右子树均不为空的情况
			// 找到待删除节点右子树中的最小值作为新的节点
			Node minNode = minimum(node.right);
			// 新节点的右子树为待删除节点右子树中删掉最小值的树
			minNode.right = removeMin2(node.right);
			// 新节点的左子树为待删除节点的左子树
			minNode.left = node.left;
			// 待删除节点的左右子树清空
			node.left = node.right = null;
			// 返回新节点作为根节点
			return minNode;
			
		}
		// 如果要删除的元素小于node节点的元素，向node的左子树递归
		else if(e.compareTo(node.e)<0) {
			node.left = removeElement(node.left,e);
			return node;
		}
		else { // e.compareTo(node.e)>0
			node.right =  removeElement(node.right,e);
			return node;
		}
	}
		

	@Override
	public String toString() {
		StringBuilder res = new StringBuilder();
		generateBSTString(root,0,res);
		return res.toString();
	}
	
	// 生成以node为根结点，深度为depth的描述二叉树字符串
	private void generateBSTString(Node node,int depth,StringBuilder res) {
		if(node==null) {
			res.append(generateDepthString(depth) + "null\n");
            return;
		}
		res.append(generateDepthString(depth)+node.e+"\n");
		generateBSTString(node.left,depth+1,res);
		generateBSTString(node.right,depth+1,res);
	}
	private String generateDepthString(int depth) {
        StringBuilder res = new StringBuilder();
        for(int i = 0 ; i < depth ; i ++)
            res.append("--");
        return res.toString();
	}
	
	
}
