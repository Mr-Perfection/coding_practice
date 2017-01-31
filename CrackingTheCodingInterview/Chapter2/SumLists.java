public class Node {
  int data = 0;
  Node next = null;
  public Node(int data) {
    this.data = data;
  }
  public Node() {}
}

int convertDataToValue(Stack<Integer> data) {

  int value = 0;
  while(!data.isEmpty())
    value = value * 10 + data.pop();
  return value;
}
// my approach
Node sumLists(Node node1, Node node2) {
  Stack<Integer> data1 = new Stack<Integer>();
  Stack<Integer> data2 = new Stack<Integer>();
  Node solution = new Node();
  Node runner = solution;
  int value = 0;

  while (node1) {
    data1.push(node1.data);
    node1.next;
  }
  while (node2) {
    data2.push(node2.data);
    node2.next;
  }
  value = convertDataToValue(data1) + convertDataToValue(data2);
  while (value > 0) {
    runner.next = new Node(value % 10);
    value /= 10;
  }
  return solution.next;
}

// book solution

LinkedListNode sumLists(LinkedListNode node1, LinkedListNode node2, int carry) {
  if (node1 == null && node2 == null && carry == 0) {
    return null;
  }

  LinkedListNode result = new LinkedListNode();
  int value = carry;
  if (node1 != null) {
    value += node1.data;
  }
  if (node2 != null) {
    value += node2.data;
  }
  result.data = value % 10;
  if (node1 != null || node2 != null) {
    LinkedListNode next = sumLists(node1 != null ? node1 : null,
                                   node2 != null ? node2 : null,
                                   value >= 10 ? 1 : 0);
    result.setNext(next);
  }
  return result;
}

int convertDataToValue(ArrayList<Integer> data) {

  int value = 0;
  while(!data.isEmpty())
    value = value * 10 + data.removeFirst();
  return value;
}

LinkedList<Integer> convertNodeToList(LinkedListNode node) {
  LinkedList<Integer> data = new LinkedList<Integer>();
  while (node1) {
    data.add(node1.data);
    node1.next;
  }
  return data;
}

LinkedListNode convertValueToData(int value) {
  if (value <= 0) return null;
  LinkedListNode node = new LinkedListNode(value % 10);
  LinkedListNode next = convertValueToList(value / 10);
  if (next == null) {
    return node;
  }
  next.next = node;
  return next;
}
LinkedListNode sumListsFollowUp(LinkedListNode node1, LinkedListNode node2) {

  LinkedList<Integer> data1 = null;
  LinkedList<Integer> data2 = null;
  LinkedListNode result = new LinkedListNode();
  LinkedListNode runner = result;
  int value = 0;

  data1 = convertNodeToData(data1);
  data2 = convertNodeToData(data2);
  value = convertDataToValue(data1) + convertDataToValue(data2);
  result.next = convertValueToList(value);
  return result.next;
}

//honestly, book kind of overcomplicates the problem.. Book solution

class PartialSum {
  public LinkedListNode sum = null;
  public int carry = 0;
}

LinkedListNode addLists(LinkedListNode l1, LinkedListNode l2) {
  int len1 = length(l1); //length() will get the length of a LinkedList
  int len2 = length(l2);
  ... Check solution from the book...

}
