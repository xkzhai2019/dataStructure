import java.util.Random;

public class Main {

	public static void main(String[] args) {
		int n = 1000000;
		MaxHeap<Integer> maxHeap = new MaxHeap<>();
		Random random = new Random();
		for(int i= 0;i<n;i++)
			maxHeap.add(random.nextInt(Integer.MAX_VALUE)); // 随机添加整型数据进入堆
		
		
		int[] arr = new int[n];
		for (int i=0;i<n;i++)
			arr[i] = maxHeap.extractMax(); // 依次从堆中取出最大值存入数组中
		
		for(int i=1;i<n;i++) {
			if(arr[i-1]<arr[i])
				throw new IllegalArgumentException("Error"); // 如果数组中出现前一个元素小于后一个元素的情况，表明最大堆存在问题
		}
		
		System.out.println("Test MaxHeap completed.");

}
