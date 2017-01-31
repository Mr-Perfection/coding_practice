/*
  does the node contain character as a data?
  is linkedlist singly linedlist or doubly?
  is the character unicode or ASCII? Unicode has 256 character, ASCII 128
  is the character case-insensitive?
  is the data always an alphabet?
*/

/*
  TODO:
    -create a integer table that will count the occurences of letters
*/

int getCharValue(char c) {
  int value = Character.GetNumericValue(c);
  int a = Character.GetNumericValue('a');
  int z = Character.GetNumericValue('z');
  int A = Character.GetNumericValue('A');
  int Z = Character.GetNumericValue('Z');
  if (value >= a && value <= z) {
    return value - a;
  }
  if (value >= A && value <= Z) {
    return value - A + a;
  }
  return -1;
}
// wrong... what did i just do lol
boolean palindrome(LinkedListNode node){
  int[] table = new int[52]; //since you don't need to return any characters, reduce the size of array to only num alphabats both lower and upper
  int oneOdd = 0; //only one or less odd number of occurences is allowed to be palindrome
  while (node) {
    int value = getCharValue(node.data);
    if (value != -1) {
      table[value]++;
    }
    node = node.next;
  }
  for (int i = 0;i < table.length ; ++i ) {
    if (table % 2 != 0) {
      oneOdd++;
    }
  }
  if (oneOdd <= 1) {
    return true;
  }
  return false;
}


// simple way: create a copy of linkedlist in a reverse order and check if they match half way
boolean palindrome(LinkedListNode node) {
  LinkedListNode reversedNode = reverseNode(node);
  while (node != null) {
    if (node.data != reverseNode.data) {
      return false;
    }
    node = node.next;
    reversedNode = reversedNode.next;
  }
  return true;
}

LinkedListNode reverseNode(LinkedListNode node) {
  if (node == null) return null;
  LinkedListNode next = reverseNode(node.next);
  if (next == null)
    return node;
  next.next = node;
  node.next = null;
  return node;
}

// use stack to store the entire LinkedList's data and compare it by iterating the list from the beginning
boolean isPalindrome(LinkedListNode node) {
  Stack<Integer> stack = new Stack<Integer>();
  LinkedListNode runner = node;
  while (runner) {
    stack.push(runner.data);
    runner = runner.next;
  }
  while (!stack.isEmpty() || node) {
    int val = stack.pop();
    if( val != node.data)
      return false;
    node = node.next;
  }
  return true;
}

//book's way... I like this... Basically, reducing O(n) to O(n/2) for time complex. SMART
boolean isPalindrome(LinkedListNode head) {
  Stack<Integer> stack = new Stack<Integer>();
  LinkedListNode fast = head;
  LinkedListNode slow = head;

  //in this way, we know that we get the half of nodes
  while(fast != null && fast.next != null) {
    stack.push(slow.data);
    slow = slow.next;
    fast = fast.next.next;
  }

  if (fast != null) {
    slow = slow.next;
  }

  while (slow != null) {
    int val = stack.pop().intValue();
    if( val != slow.data) {
      return false;
    }
    slow = slow.next;
  }
  return true;
}
//book's way... Less maintainable
LinkedListNode reverseAndClone(LinkedListNode node) {
  LinkedListNode head = null;
  while(node != null) {
    LinkedListNode n = new LinkedListNode(node.data);
    n.next = head;
    head = n;
    node = node.next;
  }
  return head;
}
boolean isEqual(LinkedListNode one, LinkedListNode two) {
  while (one != null && two != null) {
    if (one.data != two.data) {
      return false;
    }
    one = one.next;
    two = two.next;
  }
  return one == null && two == null;
}
boolean isPalindrome(LinkedListNode node ) {
  LinkedListNode reversed = reverseAndClone(node);
  return isEqual(node, reversed);
}
