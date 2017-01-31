
// time complexity O(n) n is the length of list + k (traversed nodes before slow and fast nodes intersect) and spac complex. O(1)
LinkedListNode loopDetection(LinkedListNode node) {
  if (node == null || node.next == null) return null;
  LinkedListNode slow = node;
  LinkedListNode fast = node;

  while (fast != null && fast.next != null) {
    if (slow == fast) {
      break;
    }
    slow = slow.next;
    fast = fast.next.next;
  }
  if (fast == null || fast.next == null) {
    return null;
  }
  while (fast != slow) {
    fast = fast.next;
    slow = slow.next;
  }
  return slow;
}

// this algorithm should detect the existance of the loop and return the beginning of the loop.
// use HashSet
// Time: O(n) as n is the length of a list. Space: O(n)

LinkedListNode loopDetection(LinkedListNode node) {
  if (node == null || node.next == null) return null;

  HashSet<Integer> loopNodes = new HashSet<LinkedListNode>();

  while (node != null) {
    if (!loopNodes.add(node)) {
      return node;
    }
    node = node.next;
  }
  return null;
}
