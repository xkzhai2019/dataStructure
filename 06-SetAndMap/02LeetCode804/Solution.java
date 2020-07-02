import java.util.TreeSet;

// leetcode 804
public class Solution {
	 public int uniqueMorseRepresentations(String[] words) {
		 String[] codes = {".-","-...","-.-.","-..",".","..-.",
				 "--.","....","..",".---","-.-",".-..","--","-.",
				 "---",".--.","--.-",".-.","...","-","..-","...-",
				 ".--","-..-","-.--","--.."};
		 TreeSet<String> treeSet = new TreeSet<>();
		 for(String word:words) {
			 StringBuilder res = new StringBuilder();
			 for(int i=0;i<word.length();i++) {
				 // 将单词索引为i位置的字母翻译成摩尔斯密码，追加到翻译结果中
				 res.append(codes[word.charAt(i)-'a']);
			 }
			 treeSet.add(res.toString());
		 }
		 return treeSet.size();
	 }
}
