package linkedlist;
/**
*You are given two non-empty linked lists representing two non-negative integers. 
*The digits are stored in reverse order and each of their nodes contain a single digit. 
*Add the two numbers and return it as a linked list.

*You may assume the two numbers do not contain any leading zero, except the number 0 itself.
*
**/
public class AddNumbers {

	private class ListNode{
		int val;
		ListNode next;
		
		public ListNode(int val) {
			this.val = val;
		}
	}
	
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode result = new ListNode(0);
        ListNode head = result;
        while(l1 != null || l2 != null){
            int l1Val = 0;
            int l2Val = 0;
            
            if(l1 != null){
                l1Val = l1.val;
                l1 = l1.next;
            }
            if(l2 != null){
                l2Val = l2.val;
                l2 = l2.next;
            }
            int sum = l1Val + l2Val + carry;

            if(sum >= 10){
                carry = 1;
                sum = sum % 10;
            } else{
                carry = 0;
            }
            ListNode node = new ListNode(sum);
            result.next = node;
            result = result.next;
        }
        if(carry > 0){
            result.next = new ListNode(carry);
        } else{
            result.next = null;    
        }
        return head.next;
    }
}
