# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):

    """
    function merge
        @param list1: a head node of list1 (or l1)
        @param list2: a head node of list2 (or l2)
        @return merged_list: sorted merged list of l1 and l2
    """
    def merge(self,list1,list2):
        # edge cases
        if not(list1):
            return list2
        if not(list2):
            return list1
        node1,node2 = list1,list2
        start,merged = None,None

        # loop through the node1 & node2 until either one reaches null
        while node1 and node2:
            temp = None
            # if node1 data is less than node2.data
            if node1.val < node2.val:
                temp = node1
                node1 = node1.next
            else:
                temp = node2
                node2 = node2.next

            if merged:
                merged.next = temp
                merged = merged.next
            else:
                merged = temp
                start = temp

        if node1: merged.next = node1
        if node2: merged.next = node2
        return start



    def partition(self,lists,start,end):
        # if start reaches end, return lists[start]
        if start == end: return lists[start]

        # if start is less than end, partition the lists
        if start < end:
            mid = (start+end) / 2
            l1 = self.partition(lists,start,mid)
            l2 = self.partition(lists,mid+1,end)
            return self.merge(l1,l2)
        else:
            return None

    def mergeKLists(self, lists):
        """
        :type lists: List[ListNode]
        :rtype: ListNode
        """
        return self.partition(lists,0,len(lists)-1)
