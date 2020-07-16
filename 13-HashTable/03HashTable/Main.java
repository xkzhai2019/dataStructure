import java.util.ArrayList;
import java.util.Collections;

public class Main {

	public static void main(String[] args) {
		System.out.println("Pride and Prejudice");
		
		ArrayList<String> words = new ArrayList<>();
		if(FileOperation.readFile("pride-and-prejudice.txt", words)) {
			
			// Collections.sort(words);
			
			// Test BST
			long startTime = System.nanoTime();
			
			BST<String,Integer> bst = new BST<>();
			for(String word: words) {
				if(bst.contains(word))
					bst.set(word, bst.get(word)+1);
				else
					bst.add(word, 1);
			}
			
			for (String word:words)
				bst.contains(word);
			
			long endTime = System.nanoTime();
			
			double time = (endTime - startTime); // 1000000000.0;
			System.out.println("BST:"+time+" s"); // 1.392 s
			
			// Test AVL Tree
			startTime = System.nanoTime();
			
			AVLTree<String,Integer> avl = new AVLTree<>();
			for(String word: words) {
				if(avl.contains(word))
					avl.set(word, avl.get(word)+1);
				else
					avl.add(word, 1);
			}
			
			for (String word:words)
				avl.contains(word);
			
			endTime = System.nanoTime();
			
			time = (endTime - startTime) / 1000000000.0;
			System.out.println("AVL:"+time+" s"); // 0.0637 s
			
			// Test HashTable
			startTime = System.nanoTime();
			
			HashTable<String,Integer> ht1 = new HashTable<>(); // 0.06598 s
			HashTable<String,Integer> ht1_M = new HashTable<>(131071); // 0.0268 s
			
			HashTable2<String,Integer> ht2 = new HashTable2<>(131071); // 0.04590903 s
			
			HashTable3<String,Integer> ht3 = new HashTable3<>(); // 0.0385 s
			
			for(String word: words) {
				if(ht1.contains(word))
					ht1.set(word, ht1.get(word)+1);
				else
					ht1.add(word, 1);
			}
			
			for (String word:words)
				ht1.contains(word);
			
			endTime = System.nanoTime();
			
			time = (endTime - startTime) / 1000000000.0;
			System.out.println("HashTable :"+time+" s");
			
			
			startTime = System.nanoTime();
			for(String word: words) {
				if(ht1_M.contains(word))
					ht1_M.set(word, ht1_M.get(word)+1);
				else
					ht1_M.add(word, 1);
			}
			
			for (String word:words)
				ht1_M.contains(word);
			
			endTime = System.nanoTime();
			
			time = (endTime - startTime) / 1000000000.0;
			System.out.println("HashTable Set M:"+time+" s");
			
			startTime = System.nanoTime();
			for(String word: words) {
				if(ht2.contains(word))
					ht2.set(word, ht2.get(word)+1);
				else
					ht2.add(word, 1);
			}
			
			for (String word:words)
				ht2.contains(word);
			
			endTime = System.nanoTime();
			
			time = (endTime - startTime) / 1000000000.0;
			System.out.println("HashTable resize:"+time+" s");
			
			
			startTime = System.nanoTime();
			for(String word: words) {
				if(ht3.contains(word))
					ht3.set(word, ht3.get(word)+1);
				else
					ht3.add(word, 1);
			}
			
			for (String word:words)
				ht3.contains(word);
			
			endTime = System.nanoTime();
			
			time = (endTime - startTime) / 1000000000.0;
			System.out.println("HashTable dynamic M:"+time+" s");
			
		}
	}

}
