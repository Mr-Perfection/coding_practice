// my implementation time complexity: O(n), Space complexity O(n)
void removeDups(LinkedListNode node) {
  if (node == null) return ;
  HashMap<Integer, Boolean> dups = new HashMap<Integer, Boolean>();
  dups.put(node.data, true);
  while(node.next) {
    LinkedListNode current = node.next;
    LinkedListNode next = node.next.next;
    if (dups.get(current.data))
      node.next = next;
    else
      dups.put(node.data, true);
    node = node.next;
  }
}

void removeDups(LinkedListNode node) {
  if (node == null) return ;
  HashSet<Integer> set = new HashSet<Integer>();
  LinkedListNode previous = null;
  while(node != null){
    if (set.contains(node.data)) {
      previous.next = node.next;
    } else {
      set.add(node.data);
      previous = node;
    }
    node = node.next;
  }
}


// FOLLOW UP Question
void removeDupsWithoutBuffer(LinkedListNode node) {
  if (node == null) return ;

  while(node) {
    LinkedListNode current = node;
    while(current.next != null) {
      if (node.data == current.data)
        current.next = current.next.next;
      else
        current = current.next;
    }
    node = node.next;
  }
}
