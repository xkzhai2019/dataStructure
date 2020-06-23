import java.util.Random;

public class Main {
	public static double costTime(Stack<Integer> stack,int nCount) {
		
		Random random = new Random();
		long startTime = System.nanoTime();
		for(int i = 0;i<nCount;i++) {
			stack.push(random.nextInt(Integer.MAX_VALUE));
		}
		for(int i = 0;i<nCount;i++) {
			stack.pop();
		}
		
		long endTime = System.nanoTime();
		return (endTime-startTime) / 1000000000.0 ;
		
	}

	public static void main(String[] args) {
		ArrayStack<Integer> stack = new ArrayStack<>(); 
		for(int i = 0;i<5;i++) {
			stack.push(i);
			System.out.println(stack);
			// Stack: [0] top
			// Stack: [0,1] top
			// Stack: [0,1,2] top
			// Stack: [0,1,2,3] top
			// Stack: [0,1,2,3,4] top
		}
		stack.pop();
		System.out.println(stack); // Stack: [0,1,2,3] top
		
		int nCount = 100000;
		ArrayStack<Integer> arraystack = new ArrayStack<>(); 
		LinkedListStack<Integer> linkedstack = new LinkedListStack<>(); 
		
		System.out.println("ArrayStack:"+costTime(arraystack,nCount)); // 0.015
		System.out.println("LinkedListStack:"+costTime(linkedstack,nCount)); // 0.010
			
	}
}
