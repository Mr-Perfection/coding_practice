/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 * 
 * 
 * 
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

Try solving it using constant additional space.

Example :

Input : 

                  ______
                 |     |
                 \/    |
        1 -> 2 -> 3 -> 4

Return the node corresponding to node 3. 
 */
public class Solution {
	public ListNode detectCycle(ListNode a) {
	    ListNode p1 = a;
	    ListNode p2 = a;
	    while(p2 != null && p2.next != null)
	    {
	        p1 = p1.next;
	        p2 = p2.next.next;
	        if (p1 == p2)
	            return (p1);
	    }
	    return (null);
	    
	}
}
