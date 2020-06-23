public class Main {

	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<>();
		for(int i = 0;i<5;i++) {
			list.addFirst(i);
			System.out.println(list);
		}
		/*
		 * 0-->NULL
		 * 1-->0-->NULL
		 * 2-->1-->0-->NULL
		 * 3-->2-->1-->0-->NULL
		 * 4-->3-->2-->1-->0-->NULL
		 */
		list.set(2, 10);
		System.out.println(list);
		// 4-->3-->10-->1-->0-->NULL
		
		list.add(2, 2);
		System.out.println(list);
		// 4-->3-->2-->10-->1-->0-->NULL
		
		System.out.println(list.contains(6)); // false
		
		list.removeLast();
		System.out.println(list); // 4-->3-->2-->10-->1-->NULL
		
		list.removeFirst();
		System.out.println(list); // 3-->2-->10-->1-->NULL
		
		list.removeElement(10);
		System.out.println(list); // 3-->2-->1-->NULL
		
		list.removeElement(6);
		System.out.println(list); // 3-->2-->1-->NULL
	}

}
