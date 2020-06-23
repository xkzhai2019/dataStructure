import java.util.Random;


public class Main {

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
			
	}
}
