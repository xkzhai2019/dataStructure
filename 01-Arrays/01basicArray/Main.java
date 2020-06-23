
public class Main {

	public static void main(String[] args) {
		int[] arr = new int[10];
		
		//软编码: length
		for(int i = 0;i<arr.length;i++) {
			arr[i] = i;
		}
		
		int[] scores = new int[] {10,99,96};
		for(int i = 0;i<scores.length;i++) {
			System.out.println(scores[i]);
		}
		System.out.println("-----------");
		
		//增强for循环
		for(int score: scores) {
			System.out.println(score);
		}
		System.out.println("-----------");
		
		//改
		scores[0] = 96;
		for(int score: scores) {
			System.out.println(score);
		}
		
		Array array = new Array(20);
		for(int i = 0;i<10;i++) {
			array.addLast(i);
		}
		System.out.println(array);
		// Array: size = 10, capacity = 20 
		// [0,1,2,3,4,5,6,7,8,9]
		
		array.add(1, 100);
		System.out.println(array);
		// Array: size = 11, capacity = 20 
		// [0,100,1,2,3,4,5,6,7,8,9]
		
		array.addFirst(-1);;
		System.out.println(array);
		// Array: size = 12, capacity = 20 
		// [-1,0,100,1,2,3,4,5,6,7,8,9]
		
		array.set(0, -2);
		System.out.println(array);
		// Array: size = 12, capacity = 20 
		// [-2,0,100,1,2,3,4,5,6,7,8,9]
		
		System.out.println(array.contains(10));
		// false
		
		System.out.println(array.find(2));
		// 4
		
		array.removeFirst();
		System.out.println(array);
		// Array: size = 11, capacity = 20 
		// [0,100,1,2,3,4,5,6,7,8,9]
		
		array.remove(1);
		System.out.println(array);
		// Array: size = 10, capacity = 20 
		// [0,1,2,3,4,5,6,7,8,9]
		
		array.removeElement(100);
		System.out.println(array);
		// Array: size = 10, capacity = 20 
		// [0,1,2,3,4,5,6,7,8,9]
	}
}
