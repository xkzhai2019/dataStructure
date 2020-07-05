public class Main {

	public static void main(String[] args) {
		Integer[] nums = {-2,0,3,-5,2,-1};
		SegmentTree<Integer> segTree = new SegmentTree<>(nums,new Merger<Integer>() {
			@Override
			public Integer merge(Integer a, Integer b) {
				return a+b;
			}
			// (a,b)->a+b, lambda表达式
		});
		System.out.println(segTree); 
		// [-3,1,-4,-2,3,-3,-1,-2,0,null,null,-5,2,null,null,null,null,null,null,null,null,null,null,null]
		
		System.out.println(segTree.query(0, 2)); // 1
		System.out.println(segTree.query(2, 5)); // -1
		System.out.println(segTree.query(0, 5)); // -3
	}
}
