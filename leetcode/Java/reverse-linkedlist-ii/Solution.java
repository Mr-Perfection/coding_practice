public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        //initially check if there exists head node or not.
        if (head == null || m == 0 || n == 0)
            return (head);
        //step 1: check if m > n
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        
        if (m >= n)  return (head);
        //step 2: get the node before m-th
        for (int i = m; i > 1; i--)
            pre = pre.next;
        //step 3: create a dummy node that will get the tail of the list.
        ListNode reverseTail = pre.next;
        pre.next = null; //do this so that now pre list is not relevent to the list we are trying to reverse
        ListNode curr = reverseTail;
        //step 4: iterate through n-m+1
        for (int i = n - m + 1; i > 0; i--)
        {
            //the last node of the reverse-list appended to the current-list
            if (i == 1)
            {
                reverseTail.next = curr.next;
            }
            ListNode tmp = curr.next;
            curr.next = pre.next;
            pre.next = curr;
            curr = tmp;
            
        }
        return (dummy.next);
        
    }
}