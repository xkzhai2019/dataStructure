import java.util.ArrayList;

public class Main {

	public static double testMap(Map<String,Integer> map, String fileName) {
		long startTime = System.nanoTime();
		
		System.out.println(fileName);
		ArrayList<String> words = new ArrayList<>();
		if(FileOperation.readFile(fileName, words)) {
			System.out.println("Total words:" + words.size());
			
			for(String word:words) {
				if(map.contains(word)) {
					map.set(word, map.get(word)+1);
				}
				else
					map.add(word, 1);
			}
			System.out.println("Total different words: " + map.getSize());
            System.out.println("Frequency of PRIDE: " + map.get("pride"));
            System.out.println("Frequency of PREJUDICE: " + map.get("prejudice"));
		}
		long endTime = System.nanoTime();
		
		return (endTime-startTime)/1000000000.0;
	}
	public static void main(String[] args) {
		String fileName = "pride-and-prejudice.txt";
		LinkedListMap<String,Integer> listmap = new LinkedListMap<>();
		double time1 = testMap(listmap,fileName);
		System.out.println("LinkedList Map:" + time1 + "s"); // 10.56s

		BSTMap<String,Integer> bstmap = new BSTMap<>();
		double time2 = testMap(bstmap,fileName);
				
		
		System.out.println("BST Map:" + time2 + "s"); // 0.100s
	}

}
