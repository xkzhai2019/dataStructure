import java.util.ArrayList;

public class Main {
//	public static void main(String[] args) {
//		ArrayList<String> words = new ArrayList<>();
//		if(FileOperation.readFile("pride-and-prejudice.txt", words)) {
//			
//			System.out.println("Total words:"+words.size()); // 125901
//			
//			BSTSet<String> bst =  new BSTSet<>();
//			for(String word:words) {
//				bst.add(word);
//			}
//			
//			System.out.println("Total different words: "+bst.getSize()); // 6530
//		}
//		else {
//			throw new IllegalArgumentException("Read failed");
//		}
//	}
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
		  System.out.println("BST set:"+time1+"s"); // 0.1558 s
		  
		  System.out.println();
		  
		  LinkedListSet<String> linkedListSet = new LinkedListSet<>();
		  double time2 = testSet(linkedListSet, filename);
		  System.out.println("LinkedList set:"+time2+"s"); // 2.1550 s  
	}
}
