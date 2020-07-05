//给定一个整数数组  nums，求出数组从索引 i 到 j  (i ≤ j) 范围内元素的总和，包含 i,  j 两点。
//
//update(i, val) 函数可以通过将下标为 i 的数值更新为 val，从而对数列进行修改。
//
//示例:
//
//Given nums = [1, 3, 5]
//
//sumRange(0, 2) -> 9
//update(1, 2)
//sumRange(0, 2) -> 8
//说明:
//
//数组仅可以在 update 函数下进行修改。
//你可以假设 update 函数与 sumRange 函数的调用次数是均匀分布的。
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/range-sum-query-mutable
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class NumArray3 {
	
	private int[] sum; // sum[i] 存储前i个元素和，sum[0] = 0
	 					// sum[i] 存储nums[0...i-1]的和
	private int[] data;
	
	public NumArray3(int[] nums) {
		data = new int[nums.length];
		for(int i=0;i<nums.length;i++) {
			data[i] = nums[i];
		}
		sum = new int[nums.length+1];
		sum[0] = 0;
		for(int i=1;i<sum.length;i++) {
			sum[i] = sum[i-1] + nums[i-1];
		}
	}
	
	public void update(int index,int val) {
		data[index] = val;
		for(int i=index+1;i<sum.length;i++) {
			sum[i] = sum[i-1] + data[i-1];
		}
	}
	
	public int sumRange(int i,int j) {
		return sum[j+1] - sum[i];
	}

}
