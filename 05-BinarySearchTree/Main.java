public class Main {

	public static void main(String[] args) {
		BST<Integer> bst = new BST<>();
		int[] nums = {5,3,6,8,4,2};
		for(int num:nums) {
			bst.addElement(num);
		}
        /////////////////
        //      5      //
        //    /   \    //
        //   3    6    //
        //  / \    \   //
        // 2  4     8  //
        /////////////////
        bst.preOrder(); // 5, 3, 2, 4, 6, 8
        System.out.println(); 

       // System.out.println(bst);
        
       // System.out.println();
        
        bst.inOrder(); // 2,3,4,5,6,8
        System.out.println();
        
        bst.postOrder(); // 2, 4, 3, 8, 6, 5
        System.out.println();
        
        bst.preOderNR(); // 5, 3, 2, 4, 6, 8
        System.out.println();
        
        bst.levelOrder(); // 5, 3, 6, 2, 4, 8
        
        System.out.println(bst.getSize()); // 6
        
        System.out.println();
        
        //bst.removeMin();
        bst.removeMin2();
        bst.levelOrder(); // 5, 3, 6, 4, 8
        
        System.out.println();
        bst.removeMax2();
        bst.levelOrder(); // 5, 3, 6, 4
        
        System.out.println();
        System.out.println("size:"+bst.getSize()); // size: 4
        System.out.println("Max:"+bst.maxmum()); // Max: 6
        System.out.println("Min:"+bst.minimum()); // Min: 3
        
        /////////////////
        //      5      //
        //    /   \    //
        //   3    6    //
        //   |         //
        //   4         //
        /////////////////
        
        System.out.println();
        bst.removeElement(5); 
        
		/////////////////
		//      6      //
		//    /       //
		//   3        //
		//   |         //
		//   4         //
		/////////////////
        
        bst.levelOrder();   // 6, 3, 4    
        System.out.println("size:"+bst.getSize());// size: 3
	}

}
