public class Node {
  int data = 0;
  Node next = null;
  public Node(int data) {
    this.data = data;
  }
  public Node() {
  }
}

// honetsly, I didnt understand the question well.
// ask interviewer wtf is going on with partitioning stufff.
// based on my understanding. cheated a little... didnt understand the question and the example is a bit off.
/*
  TODO:
    - create a temp1 list that is for the nodes that have values less than partition
    - create a temp2 list that is for the nodes that have values greater than equal to partition
    - combine them together temp1 + temp2 in order
*/
Node partition(Node head, int partition) {
  if (head == null) return null;
  Node tempStart1 = new Node();
  Node tempEnd1 = null;
  Node tempStart2 = new Node();
  Node tempEnd2 = null;
  Node node = head;

  while(node != null) {
    Node next = node.next;
    if (node.data < partition) {
      tempStart1.next = node;
      tempEnd1 = node;
    } else {
      tempStart2.next = node;
      tempEnd2 = node;
    }
    node.next = null;
    node = next;
  }
  // what if tempStart1 is null? handle the edge case
  if (tempStart1 == null) {
    return tempStart2;
  }
  tempEnd2.next = null;
  tempEnd1.next = tempStart2.next;
  return tempStart1.next;
}




// book solution....
Node partition(Node node, int partition) {
  Node beforeStart = null;
  Node afterStart = null;
  Node beforeEnd = null;
  Node afterEnd = null;

  // partition list
  while (node != null) {
    Node next = node.next;
    node.next = null;
    if (node.data < partition) {
      if (beforeStart == null) {
        beforeStart = node;
        beforeEnd = beforeStart;
      } else {
        beforeEnd.next = node;
        beforeEnd = node;
      }
    } else {
      // insert node into end of after list
      if (afterStart == null) {
        afterStart = node;
        afterEnd = afterStart;
      } else {
        afterEnd.next = node;
        afterEnd = node;
      }
    }
    node = next;
  }

  if (beforeStart == null) {
    return afterStart;
  }

  beforeEnd.next = afterStart;
  return beforeStart;
}
