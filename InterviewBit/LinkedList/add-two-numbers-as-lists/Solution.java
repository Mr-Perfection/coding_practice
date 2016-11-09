/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    /*cant handle large list :/*/
    // int convertListToInt(ListNode a)
    // {
    //     int result = 0;
    //     int mult = 1;
    //     while(a != null)
    //     {
    //         result = result + a.val * mult;
    //         mult *= 10;
    //         a = a.next;
    //     }
    //     return (result);
    // }
// 	public ListNode addTwoNumbers(ListNode a, ListNode b) {
	    
// 	   // int num_a = convertListToInt(a);
// 	   // int num_b = convertListToInt(b);
// 	    ListNode sol = new ListNode(0);
// 	    ListNode ans = sol;
// 	    //num_a will be added with num_b and return the answer in integer.
// 	    num_a += num_b;
// 	    while(num_a > 0)
// 	    {
// 	        sol.next = new ListNode(num_a % 10);
// 	        num_a /= 10;
// 	        sol = sol.next;
// 	    }
// 	   // System.out.println("result: " + num_a);
// 	    return (ans.next);
// 	}
    public ListNode addTwoNumbers(ListNode a, ListNode b) {
	    
	    ListNode sol = new ListNode(0);
	    ListNode p1 = a;
	    ListNode p2 = b;
	    ListNode curr = null;
	    int one = 0;
	    //add list a to the sol.
	    sol.next = a;
	    curr = sol;
	    //need to get the last node in list a.
	    while (p2 != null)
	    {
	        //check if p1 (or node in list a) is not null
	        if (curr.next != null)
	        {
	            //check if the p1 + p2 is >= 10
	            int value = curr.next.val + p2.val + one;
	            if (value > 9)
	            {
	                curr.next.val = value % 10;
	                one = 1;
	            }
	            else
	            {
	                curr.next.val = value;
	                one = 0;
	            }
	        }
	        //if it reaches end of solution list, then append what is left in p2
	        else
	        {
	            int value = p2.val + one;
	            if (value > 9)
	            {
	                curr.next = new ListNode(value % 10);
	                one = 1;
	            }
	            else
	            {
	                curr.next = new ListNode(value);
	                one = 0;
	            }
	        }
	        curr = curr.next;
	        p2 = p2.next;
	    }
	    
	    //check if one is still 1. if it is, then keep going until one becomes zero
	    while (one == 1)
	    {
	        if (curr.next != null)
	        {
	            int value = curr.next.val + one;
	            if (value > 9)
	            {
	                curr.next.val = value % 10;
	                one = 1;
	            }
	            else
	            {
	                curr.next.val = curr.next.val + one;
	                one = 0;
	            }
	            
	        }
	        else
	        {
	            curr.next = new ListNode(one);
	            one = 0;
	        }
	        curr = curr.next;
	        
	    }
	    
	    return (sol.next);
	}
}
