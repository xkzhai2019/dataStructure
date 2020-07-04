//给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
//
//示例 1:
//
//输入: nums = [1,1,1,2,2,3], k = 2
//输出: [1,2]
//示例 2:
//
//输入: nums = [1], k = 1
//输出: [1]
//说明：
//
//你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
//你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/top-k-frequent-elements
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

import java.util.TreeMap;
import java.util.LinkedList;
import java.util.List;

public class Solution {
	// 频次分布类，存储元素及其出现次数
	// 最前面的元素频次最低（最小堆）
	private class Freq implements Comparable<Freq>{
		int e,freq;
		
		public Freq(int e,int freq) {
			this.e = e;
			this.freq = freq;
		}
		
		@Override
		public int compareTo(Freq another) {
			if(this.freq<another.freq) {
				return 1;
			}
			
			else if (this.freq>another.freq)
				return -1;
			else
				return 0;
			
		}
	}
	public List<Integer> topKFrequent(int[] nums, int k){
		// 1. 将数组中的元素及其出现次数存储到映射中
		TreeMap<Integer,Integer> map = new TreeMap<>();
		for(int num:nums) {
			if (map.containsKey(num))
				map.put(num, map.get(num)+1);
			else
				map.put(num, 1);
		}
		
		// 2. 建立存储私有频率分布类对象的优先队列
		PriorityQueue<Freq> pq = new PriorityQueue<>();
		for(int key:map.keySet()) {
			
			if(pq.getSize()<k)
				// 首先存储k个键值对
				pq.enqueue(new Freq(key,map.get(key)));
			else if(map.get(key)>pq.getFront().freq){
				// 存储k个后，如果下一元素的频次比已存数据中最小频次要大
				// 最小频次的元素出队
				pq.dequeue();
				pq.enqueue(new Freq(key,map.get(key)));
			}
		}
		
		// 3. 将优先队列的元素依次取出放入链表中
		LinkedList<Integer> res = new LinkedList<>();
		while(!pq.isEmpty()) {
			res.add(pq.dequeue().e);
		}
		return res;
	}
}
