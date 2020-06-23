import java.util.Random;

public class Main {
	public static double costTime(Queue<Integer> queue,int nCount) {
		
		Random random = new Random();
		long startTime = System.nanoTime();
		for(int i = 0;i<nCount;i++) {
			queue.enqueue(random.nextInt(Integer.MAX_VALUE));
		}
		for(int i = 0;i<nCount;i++) {
			queue.dequeue();
		}
		
		long endTime = System.nanoTime();
		return (endTime-startTime) / 1000000000.0 ;
		
	}
	// 数组队列、循环队列、链表队列对比
	public static void main(String[] args) {
		int nCount = 200000;
		ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
		LoopQueue<Integer> loopQueue = new LoopQueue<>();
		LinkedListQueue<Integer> linkedQueue = new LinkedListQueue<>();
		
		System.out.println("ArrayQueue:"+costTime(arrayQueue,nCount)); //ArrayQueue:10.48
		System.out.println("LoopQueue:"+costTime(loopQueue,nCount)); // LoopQueue:0.015
		System.out.println("LinkedListQueue:"+costTime(linkedQueue,nCount)); // LoopQueue:0.017
	}

}
