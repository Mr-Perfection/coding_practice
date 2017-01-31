// is there only one node that is intersecting between list1 and list2?

// bruteforce soluction O(n^2)
LinkedListNode intersection(LinkedListNode node1, LinkedListNode node2) {
  LinkedListNode temp = null;
  while (node1 != null node2 != null) {
    temp = node2;
    while (temp) {
      if (node1 == node2) {
        return node1;
      }
      temp = temp.next;
    }
    node1 = node1.next;
  }
  return null;
}

// my solution with some hints O(A + B) A for length of shorter linkedlist and b for the other
LinkedListNode intersection(LinkedListNode node1, LinkedListNode node2) {
  if (node1 == null || node2 == null) return null;

  int length1 = getLength(node1);
  int length2 = getLength(node2);
  LinkedListNode trimmed = null;
  LinkedListNode node = null;
  if (length1 > length2) {
    node = node1;
    trimmed = trimLongerList(node, length1 - length2);
  }
  else if (length1 < length2) {
    node = node2;
    trimmed = trimLongerList(node2, length2 - length1);
  }
  return findIntersection(node, trimmed);
}

int getLength(LinkedListNode node) {
  int length = 0;
  while (node) {
    length++;
    node = node.next;
  }
  return length;
}

LinkedListNode trimLongerList(LinkedListNode node, int trimLength) {
  while (trimLength > 0) {
    node = node.next;
    trimLength--;
  }
  return node;
}

LinkedListNode findIntersection(LinkedListNode node, LinkedListNode trimmed) {
  while (node != null && trimmed != null) {
    if (node == trimmed) {
      return node;
    }
    node = node.next;
    trimmed = trimmed.next;
  }
  return null;
}






// book solution better approach
/*
  Run through each linked list to get the lengths and the tails.
  Compare the tails. If they are different (by reference, not by value), return immediately.There is no intersection
  Set two pointers to the start of each linked list.
  On the longer linked list, advance its pointer by the difference in lengths.
  Now, traverse on each linked list until the pointers are the same.

  Similar approach to mine but slightly better because this checks the tails. if the tails of the lists are different, then they are not intersecting
*/
LinkedListNode findIntersection(LinkedListNode list1, LinkedListNode list2) {
  if (list1 == null || list2 == null) return null;

  // get tails and sizes
  Result result1 = getTailAndLength(list1);
  Result result2 = getTailAndLength(list2);

  // if different tail nodes, then there is no intersection
  if (result1.tail != result2.tail) {
    return null;
  }

  // set pointers to the start of each linkedlist
  LinkedListNode shorter = result1.length < result2.length ? list1 : list2;
  LinkedListNode longer = result1.length < result2.length ? list2 : list1;

  // advance the pointer for the longer linked list by difference in length
  longer = getKthNode(longer, Math.abs(result1.length - result2.length));
  // move both pointers until there is a collision
  while (shorter != longer) {
    shorter = shorter.next;
    longer = longer.next;
  }
}

public class Result {
  LinkedListNode tail;
  int length;
  public Result(LinkedListNode tail, int length) {
    this.tail = tail;
    this.length = length;
  }
}

Result getTailAndLength(LinkedListNode list ) {
  if (list == null) return null;
  int length = 1;
  LinkedListNode current = list;
  while (current.next != null) {
    length++;
    current = current.next;
  }
  return new Result(current, length);
}


LinkedListNode getKthNode(LinkedListNode head, int k) {
  LinkedListNode current = head;
  while (k > 0 && current != null) {
    current = current.next;
    k--;
  }
  return current;
}
