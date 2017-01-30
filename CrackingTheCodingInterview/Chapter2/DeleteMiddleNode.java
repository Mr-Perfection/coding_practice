public class Node {
  int data = 0;
  Node next = null;
  public Node(int data) {
    this.data = data;
  }
  public Node() {
  }
}

/*
  TODO:
    replace dest node with src node (dest.next node)
      - overwrite dest.data with src.data
      - dereference  the src and referecne dest.next as src.next
*/
void deleteMiddleNode(Node dest) {
  if (dest == null) return ;
  Node src = dest.next;
  dest.data = src.data;
  dest.next = src.next;
}


// book solution
boolean deleteMiddleNode(Node n) {
  if (n == null || n.next == null)
   return false;
  Node next = n.next;
  n.data = next.data;
  n.next = next.next;
  return true;
}
