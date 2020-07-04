import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;


import java.util.PriorityQueue;


public class Solution2 {
	private class Freq {
	//	private class Freq implements Comparable<Freq>{
		int e,freq;
		
		public Freq(int e,int freq) {
			this.e = e;
			this.freq = freq;
		}
		
//		@Override
//		public int compareTo(Freq another) {
//			if(this.freq < another.freq) {
//				return -1;
//			}
//			
//			else if (this.freq>another.freq)
//				return 1;
//			else
//				return 0;
//			
//		}
	}
	// 频次比较器
	private class FreqComparator implements Comparator<Freq>{
		@Override
		public int compare(Freq a, Freq b) {
			return a.freq-b.freq;
		}
	}
	
	public List<Integer> topKFrequent(int[] nums, int k){
		TreeMap<Integer,Integer> map = new TreeMap<>();
		for(int num:nums) {
			if (map.containsKey(num))
				map.put(num, map.get(num)+1);
			else
				map.put(num, 1);
		}
		
		// 使用频次比较器构造优先队列
		PriorityQueue<Freq> pq = new PriorityQueue<>(new FreqComparator());
 		// 匿名内部类
//		PriorityQueue<Freq> pq = new PriorityQueue<>(new Comparator<Freq>() {
//			@Override
//			public int compare(Freq a, Freq b) {
//				return a.freq-b.freq;
//			}
//		});
		
		for(int key:map.keySet()) {
			// 首先存储k个键值对
			if(pq.size()<k)
				pq.add(new Freq(key,map.get(key)));
			// 存储k个后，如果下一元素的频次比已存数据中最小频次要大
			// 最小频次的元素出队
			else if(map.get(key)>pq.peek().freq){
				pq.remove();
				pq.add(new Freq(key,map.get(key)));
			}
		}
		
		LinkedList<Integer> res = new LinkedList<>();
		while(!pq.isEmpty()) {
			res.add(pq.remove().e);
		}
		return res;
	}

}
