public class Node {
  int data = 0;
  Node next = null;
  public Node(int data) {
    this.data = data;
  }
  public Node() {
  }
}

// misunderstood the question... I thought it meant get kth node from the linkedlist starting from the beginning.
// it is kth node from the last node
public static Node returnKthToLast(Node head, int k) {
  Node list = new Node(0);
  while(--k >= 0 && head != null) {
    head = head.next;
  }
  list.next = head;
  return list.next;
}

//  ask interviewer if k to the last means kth elements from the last element to clarify.
// time complex. O(2n) = O(n), space complex. = O(1)
// i did this slightly differently because i was considering k = 0 too as a first kth node.
public static Node returnKthToLast(Node head, int k) {
  if (head == null) return null;
  Node p1 = head;
  Node p2 = head;
  int size = 0;

  // get the total size of the list
  while (p1) {
    size++;
    p1 = p1.next;
  }
  // forgot to check here if k + 1 > size what if
  if (k + 1 > size) return null;
  //loop  size - k - 1 times to get size - k th node
  for (int i = 0; i < size - k - 1; ++i)
    p2 = p2.next;

  return p2;
}


// Book solution.... hmm, what do you think?
public static Node returnKthToLast(Node head, int k) {
  if (head == null) return null;
  Node p1 = head;
  Node p2 = head;

  for (int i = 0;i < k ; ++i ) {
    if (p1 == null) return null;
    p1 = p1.next;
  }
 //loop through p1 and p2 at the same to get size - kth
  while (p1) {
    p2 = p2.next;
    p1 = p1.next;
  }
  return p2;
}
