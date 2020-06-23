import java.util.Stack;

// "{}[]()[()]" --> true
// "{[}]" --> false
public class Solution {
	public static boolean isValid(String s) {
		Stack<Character>  stack = new Stack<>();
		if(s == null) 
			return false;
		for(int i = 0;i<s.length();i++) {
			char c = s.charAt(i);
			if(c == '(' || c == '[' || c=='{') {
				stack.push(c);
			}
			else {
				if(c == ')' && stack.pop() != '(') 
					return false;
				if(c == ']' && stack.pop() != '[')
					return false;
				if(c=='}' && stack.pop() != '{')
					return false;
			}
		}
		
		return stack.isEmpty();
	}
	
	public static void main(String[] args) {
		String s = "[()][](] {}";
		System.out.println(isValid(s)); // false
		System.out.println(new Solution().isValid("[]{}()")); // true
        System.out.println(new Solution().isValid("[()]{}()")); // true
	}
}