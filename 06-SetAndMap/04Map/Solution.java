import java.util.ArrayList;

/*
给定两个数组，编写一个函数来计算它们的交集。

示例 1:

输入: nums1 = [1,2,2,1], nums2 = [2,2]
输出: [2,2]

示例 2:

输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
输出: [4,9]
说明：

输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
我们可以不考虑输出结果的顺序。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/intersection-of-two-arrays-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/

public class Solution {
    public static int[] intersect(int[] nums1, int[] nums2) {
        LinkedListMap<Integer,Integer> linkedListMap = new LinkedListMap<Integer,Integer>();
        // 遍历第一个数组中的元素，将元素及其出现的次数存入映射中
        for(int num:nums1) {
        	// 如果是之前添加的元素，将元素出现的次数+1
        	if(linkedListMap.contains(num)) {
        		linkedListMap.set(num, linkedListMap.get(num)+1);
        	}
        	else
        		// 如果之前没有添加过，以出现次数为1添加进映射中
        		linkedListMap.add(num, 1);
        }
        
        ArrayList<Integer> arr = new ArrayList<>();
        for(int num:nums2) {
        	// 遍历第二个数组中的元素，如果包含在映射中，加入数组列表中
        	if(linkedListMap.contains(num)) {
        		// 如果该元素的次数大于等于1，加入数组列表，同时将出现次数减1
        		if(linkedListMap.get(num)>=1) {
        			arr.add(num);
        			linkedListMap.set(num, linkedListMap.get(num)-1);
        		}
        		// 如果该元素的次数是0，则将其从映射中移除
        		else
        			linkedListMap.remove(num);
        	}
        }
        int[] res = new int[arr.size()];
		for(int i = 0;i<arr.size();i++) {
			res[i] = arr.get(i);
		}
		return res;
    }
	public static void main(String[] args) {
		int[] nums1 = {1,2,2,2,1};
		int[] nums2 = {2,2};
		for(int num:intersect(nums1,nums2)) {
			System.out.println(num); // 2,2 
		}
	}
}
