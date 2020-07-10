import java.util.ArrayList;

public class Main {

	public static double  testSet(Set<String> set,String filename) {
		long startTime = System.nanoTime();
		ArrayList<String> words = new ArrayList<>();
		if(FileOperation.readFile(filename, words)) {
			
			System.out.println("Total words:"+words.size());
			
			for(String word:words) {
				set.add(word);
			}
			
			System.out.println("Total different words: "+set.getSize()); 
		}
		
		long endTime = System.nanoTime();
		
		return (endTime - startTime)/ 1000000000.0;
	}
	
	public static void main(String[] args) {
		  String filename = "pride-and-prejudice.txt";
		  BSTSet<String> bst = new BSTSet<String>();
		  double time1 = testSet(bst,filename);
		  System.out.println("BST set:"+time1+"s"); // 0.1135 s
		  
		  System.out.println();
		  
		  LinkedListSet<String> linkedListSet = new LinkedListSet<>();
		  double time2 = testSet(linkedListSet, filename);
		  System.out.println("LinkedList set:"+time2+"s"); // 2.1766 s  
		  
		  System.out.println();
		  
		  AVLSet<String> avlSet = new AVLSet<>();
		  double time3 = testSet(avlSet, filename);
		  System.out.println("AVL set:"+time3+"s"); // 0.0569 s  
	}
}
