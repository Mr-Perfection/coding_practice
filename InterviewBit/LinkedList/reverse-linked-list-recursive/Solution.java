/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
 
 /*
    
 */
public class Solution {
	public ListNode reverseBetween(ListNode a, int m, int n) {
	    
	    //if index m and n are the same, then there is no diff in list.
	    if(m == n)
	       return (a);
	    int i = 0;
	    //pointer that will iterate through the entire list.
	    ListNode p = a;
	    //the first part of the list that will contain linked list starting at m. will ignore the first node.
	    ListNode first = new ListNode(0);
	    ListNode second = new ListNode(0);
	    ListNode prev = null;
	    //iterate throughthe entire linkedlist
	    while (p != null)
	    {
	        //keep track on which node you are at
	        ++i;
	        //store the prev list so that you can always append the reversed list with the prev.
	        if (i == m - 1)
	            prev = p;
	        if (i == m)
	            first.next = p;
	        //this will link second node to be the second part of the list after m-th element.
	        if (i == n)
	        {
	         second.next = p.next;
	         p.next = null; //set the next node of current p node as null.
	        }
	        p = p.next;
	    }
	    //edge case: if first.next is null, then should just return the root (a) node.
	    if (first.next == null)
	        return (a);
	    
	    //reverse the p node [M, N]
	    ListNode p1 = first.next;
	    ListNode p2 = p1.next;
	    ListNode tmp = null;
	    //initially assign the p1.next to the N + 1 th element. Eventually, the rest will be reversed.
	    p1.next = second.next;
	    while (p1 != null && p2 != null)
	    {
	        tmp = p2.next;
	        p2.next = p1;
	        p1 = p2;
	        p2 = tmp;
	    }
	    //check if p1 is the first
	    if (prev != null)
	        prev.next = p1;
	    else
	        return (p1);
	   
	    return (a);
	    
	    
	}
}
