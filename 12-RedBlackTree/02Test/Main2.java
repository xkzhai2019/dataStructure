import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Main2 {

	public static void main(String[] args) {
		int n = 20000000;
		
		Random random = new Random();
		
		ArrayList<Integer> testData = new ArrayList<>();
		for(int i = 0;i<n;i++)
			testData.add(random.nextInt(Integer.MAX_VALUE));
		
		// Test BST
		long startTime = System.nanoTime();
		
		BST<Integer,Integer> bst = new BST<>();
		for(Integer x: testData)
			bst.add(x, null);
		long endTime = System.nanoTime();
		double time = (endTime - startTime) / 1000000000.0;
		System.out.println("BST:"+time+" s"); // 54.3 s
		
		// Test AVL
		startTime = System.nanoTime();
		
		AVLTree<Integer,Integer> avl = new AVLTree<>();
		for(Integer x: testData)
			avl.add(x, null);
		endTime = System.nanoTime();
		time = (endTime - startTime) / 1000000000.0;
		System.out.println("AVLTree:"+time+" s"); // 55.54 s
		
		// Test RBTree
		startTime = System.nanoTime();
		
		RBTree<Integer,Integer> rbt = new RBTree<>();
		for(Integer x: testData)
			rbt.add(x, null);
		endTime = System.nanoTime();
		time = (endTime - startTime) / 1000000000.0;
		System.out.println("RBTree:"+time+" s"); // 55.33 s
	}

}
