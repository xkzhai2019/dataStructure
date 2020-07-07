import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		System.out.println("pride and prejudice");
		
		ArrayList<String> words = new ArrayList<>();
		if(FileOperation.readFile("pride-and-prejudice.txt", words)) {
			long startTime = System.nanoTime();
			
			BSTSet<String> set = new BSTSet<>();
			for(String word:words)
				set.add(word);
			for(String word:words)
				set.contains(word);
			
			
			long endTime = System.nanoTime();
			
			double time = (endTime-startTime)/1000000000.0;
			System.out.println("Total different words: " + set.getSize());
			System.out.println("BSTSet: " + time + "s"); // 0.1126 s
			
			//--------单词量小，看不出差别；单词量越大，优势越明显
			
			startTime = System.nanoTime();
			
			Trie trie = new Trie();
			for(String word:words)
				trie.add(word);
			for(String word:words)
				trie.contains(word);
			
			
			endTime = System.nanoTime();
			
			time = (endTime-startTime)/1000000000.0;
			System.out.println("Total different words: " + trie.getSize());
			System.out.println("Trie: " + time + "s"); // 0.064 s
		}
	}
}
