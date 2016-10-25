/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {// 1 2 3
    public static ListNode head;
    public void ft_reverse_list(ListNode head, ListNode a)
    {
        //System.out.println("ft_reverse_list: " + head.val);
	    if (a.next == null)
	    {
	        //System.out.println("if a.next: " + a.val);
	        Solution.head = a; //3
	        return ;
	    }
                
	    ft_reverse_list(head, a.next);  
	    //System.out.println("node: " + node.val);
	    //System.out.println("ft_reverse_list: " + a.val);
	    ListNode next = a.next;
	    next.next = a;
	    a.next = null;
    }
	public ListNode reverseList(ListNode a) {
	    /*
	        1->2->3->4->5->NULL GIVEN
	        5->4->3->2->1->NULL SOL
	        
	        approach:
	        NULL <- 1
	        NULL <- 1 <- 2
	        NULL <- 1 <- 2 <- 3....
	    */
	    ListNode node = a;
	    
	    ft_reverse_list(Solution.head, node);
	    //System.out.println("head value: " + Solution.head.val);
	    return (Solution.head);
	    
	}
}
