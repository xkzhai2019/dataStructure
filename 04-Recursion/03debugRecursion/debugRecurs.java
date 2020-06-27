public class debugRecurs {
	  public ListNode removeElements(ListNode head, int val,int depth) {
		  String depthString = generateDepthString(depth);
		  
		  // 打印深度信息
		  System.out.print(depthString);
		  // 打印函数作用
		  System.out.println("Call: remove " + val + " in " + head);
		  
		  if(head==null) {
			  // 当头节点为空时，递归截止，开始返回，打印当前深度信息
			  System.out.print(depthString);
			  System.out.println("Return: " + head);
			  return null;
		  }
		  
		  // 头节点不为空时，递归删除子链表中对应的元素，深度+1
		  ListNode res = removeElements(head.next,val,depth+1);
		  
		  // 子链表删除完成后，打印深度信息和子链表删除后的结果
		  System.out.print(depthString);
	      System.out.println("After remove " + val + ": " + res);
	      
	      ListNode ret;
	      
		  if(head.val == val) {
			  ret = res;
		  }
		  else {
			  head.next = res;
			  ret = head;
		  }
		  // 打印深度信息和当前链表删除对应元素后的结果
		  System.out.print(depthString);
		  System.out.println("Return: " + ret);
		  return ret;
	    }
	  

	  
	    private String generateDepthString(int depth) {
			StringBuilder res = new StringBuilder();
			for(int i = 0;i<depth;i++) {
				res.append("--");
			}
	    	return res.toString();
	    }
		public static void main(String[] args) {
			int[] array = {1,2,3,4,6,5,6};
			ListNode head = new ListNode(array);
			
			System.out.println(head);
			
			head = new debugRecurs().removeElements(head,6,0);
			System.out.println(head);
//			1->2->3->4->6->5->6->NULL
//			Call: remove 6 in 1->2->3->4->6->5->6->NULL
//			--Call: remove 6 in 2->3->4->6->5->6->NULL
//			----Call: remove 6 in 3->4->6->5->6->NULL
//			------Call: remove 6 in 4->6->5->6->NULL
//			--------Call: remove 6 in 6->5->6->NULL
//			----------Call: remove 6 in 5->6->NULL
//			------------Call: remove 6 in 6->NULL
//			--------------Call: remove 6 in null
//			--------------Return: null
//			------------After remove 6: null
//			------------Return: null
//			----------After remove 6: null
//			----------Return: 5->NULL
//			--------After remove 6: 5->NULL
//			--------Return: 5->NULL
//			------After remove 6: 5->NULL
//			------Return: 4->5->NULL
//			----After remove 6: 4->5->NULL
//			----Return: 3->4->5->NULL
//			--After remove 6: 3->4->5->NULL
//			--Return: 2->3->4->5->NULL
//			After remove 6: 2->3->4->5->NULL
//			Return: 1->2->3->4->5->NULL
//			1->2->3->4->5->NULL	
		}
}
