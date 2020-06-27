public class RecursingDel {
	  public ListNode removeElements(ListNode head, int val) {
		  // 如果头节点为空，返回空节点
		  if(head==null) {
			  return null;
		  }
		  
		  // 如果头节点不为空，删除更短链表中对应的元素，记返回的链表头节点为res
		  ListNode res = removeElements(head.next,val);
		  
		  // 如果头节点也是待删除元素，直接返回删除更短链表中对应元素后的链表
		  if(head.val == val) {
			  return res;
		  }
		  // 如果头节点不是待删除元素，将更短链表中对应元素删除后的链表头节点赋为当前头节点的下一节点
		  else {
			  head.next = res;
			  return head;
		  }
		  
		  // 简洁写法
		  // head.next = removeElements(head.next,val);
		  // return (head.val == val) ? head.next:head;
	    }
	    public static void main(String[] args) {
			int[] array = {6,2,3,4,6,5,6};
			ListNode head = new ListNode(array);
			
			System.out.println(head); // 6->2->3->4->6->5->6->NULL
			
			head = new RecursingDel().removeElements(head,6);
			System.out.println(head); // 2->3->4->5->NULL
			
		}
}
