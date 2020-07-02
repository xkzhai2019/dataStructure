// leetcode 804
public class BSTSetSolution {
	
	public int uniqueMorseRepresentations(String[] words) {
		 String[] codes = {".-","-...","-.-.","-..",".","..-.",
				 "--.","....","..",".---","-.-",".-..","--","-.",
				 "---",".--.","--.-",".-.","...","-","..-","...-",
				 ".--","-..-","-.--","--.."};
		 BSTSet<String> set = new BSTSet<>();
		 for(String word:words) {
			 StringBuilder res = new StringBuilder();
			 for(int i=0;i<word.length();i++) {
				 // 将单词索引为i位置的字母翻译成摩尔斯密码，追加到翻译结果中
				 res.append(codes[word.charAt(i)-'a']);
			 }
			 set.add(res.toString());
		 }
		 return set.getSize();
	 }
}
