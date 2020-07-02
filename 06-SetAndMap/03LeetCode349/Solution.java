import java.util.ArrayList;

/*
 * 349
给定两个数组，编写一个函数来计算它们的交集。

示例 1:

输入: nums1 = [1,2,2,1], nums2 = [2,2]
输出: [2]
示例 2:

输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
输出: [9,4]
说明:

输出结果中的每个元素一定是唯一的。
我们可以不考虑输出结果的顺序。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/intersection-of-two-arrays
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/

public class Solution {
	
	public static int[] intersection(int[] nums1, int[] nums2) {
		BSTSet<Integer> bstSet = new BSTSet<>();
		// 先将第一个数组的元素添加到集合中
		for(int num:nums1) {
			bstSet.add(num);
		}
		ArrayList<Integer> arr = new ArrayList<>();
		for(int num:nums2) {
			// 遍历第二个数组中的所有元素，如果存在于集合中，则将该元素添加到数组列表中
			// 同时从集合中移除该元素
			if(bstSet.contains(num)) {
				arr.add(num);
				bstSet.remove(num);
			}
		}
		int[] res = new int[arr.size()];
		for(int i = 0;i<arr.size();i++) {
			res[i] = arr.get(i);
		}
		return res;
    }
	public static void main(String[] args) {
		int[] nums1 = {4,9,5};
		int[] nums2 = {9,4,9,8,4};
		for(int num:intersection(nums1,nums2)) {
			System.out.println(num); // 9， 4
		}
	}

}
