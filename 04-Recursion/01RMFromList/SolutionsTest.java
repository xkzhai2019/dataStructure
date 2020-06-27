public class SolutionsTest {
    public ListNode removeElements(ListNode head, int val) {
    	// 如果头节点不为空，且数据恰好为需要删除的元素，则删除头节点
    	// 使用while循环，处理前面多个节点均为待删除元素的情况
        while(head!=null && head.val == val) {
        	ListNode delNode = head;
        	head = head.next;
        	delNode.next = null;
        	// head = head.next;
        }
        
        // 如果头节点为空，则直接返回空节点
        if(head == null){
        	return null;
        }
        
        // 如果头节点不为空，且不为待删除元素，则遍历余下的链表元素
        // 需找到待删除元素的前一节点
        ListNode prev = head;
        while(prev.next!=null) {
        	if(prev.next.val == val) {
        		ListNode delNode = prev.next;
        		prev.next = delNode.next;
        		delNode.next = null;
        		// prev.next = prev.next.next;
        	}
        	else {
        		prev = prev.next;
        	}
        }
    	return head;
    }
    
    public ListNode removeElements2(ListNode head, int val) {
        ListNode dummyHead = new ListNode(-1);  
        dummyHead.next = head;
	  
        ListNode prev = dummyHead;
        while(prev.next!=null) {
        	if(prev.next.val == val) {
        		prev.next =  prev.next.next;
        	}
        	else {
        		prev = prev.next;
        	}
        }
    	return dummyHead.next;
    }
    
    public static void main(String[] args) {
		int[] array = {1,2,6,3,4,5,6};
		ListNode head = new ListNode(array);
		ListNode head1 = null;
		ListNode head2 = null;
		
		System.out.println(head);
		// 初始链表，1->2->6->3->4->5->6->NULL
		
		head1 = new SolutionsTest().removeElements(head,6);
		System.out.println(head1);
		// 删除值为6后的链表，1->2->3->4->5->NULL
		
		head2 = new SolutionsTest().removeElements2(head,6);
		System.out.println(head2);
		// 1->2->3->4->5->NULL
	}
    
}
