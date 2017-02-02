// what is the size of each stack?

public class SetOfStacks {
  LinkedList<Stack> stacks;

  public SetOfStacks() {}

  public void push(int value) {
    Stack last = getLastStack();
    if (last != null && !last.isFull()) {
      last.push();
    } else {
      Stack stack = new Stack();
      stack.push(value);
      stacks.add(stack);
    }
  }

  public Integer pop() {
    Stack last = getLastStack();
    if (last == null ) {
      throw new EmptyStackException();
    }
    Integer value = last.pop();
    // remove the last stack from the list
    if (last.isEmpty()) {
      stacks.removeLast();
    }
    return value;
  }

  public Stack getLastStack() {
    if (stacks.size == 0) {
      return null;
    }
    return stacks.getLast();
  }

  public Integer popAt(int index) throws FullStackException{
    if (index < 0 || index >= stacks.size()) {
      throw new FullStackException("Index out of bound.");
    }
    Stack stack = stacks.get(index);
    Integer value = stack.pop();
    if (stack != getLastStack()) {
      // shift the stack elements to left
      shiftStacksLeft(index);
    }
    if (stack.isEmpty()) {
      stacks.remove(index);
    }
    return value;
  }

  public void shiftStacksLeft(int index) {
    Stack stack = stacks.get(index);
    Stack last;
    for (int i = index + 1 ; i < stacks.size(); ++i) {
      Stack s1 = stacks.get(i - 1);
      Stack s2 = stacks.get(i);
      int value = s2.pop();
      s1.addLast(value);
    }
    last = getLastStack();
    if (last.isEmpty()) {
      stacks.removeLast();
    }
  }
}

public class Stack extends LinkedList<Integer> {
  int capacity;
  int size;

  public Stack(int capacity) {
    this.capacity = capacity;
    size = 0;
  }

  public void push(int value) throws FullStackException {
    if (isFull()) {
      throw new FullStackException();
    }
    super.push(value);
    size++;
  }

  public Integer pop() {
    if (size == 0) {
      throw new EmptyStackException();
    }
    Integer value = super.pop();
    size--;
    return value;
  }

  public boolean isFull() {
    if (capacity == size) {
      return true;
    }
    return false;
  }
}

public class FullStackException extends RunTimeException{
  public FullStackException() {
    this("Stack is full!");
  }
  public FullStackException(String exception) {
    super( exception);
  }
}


// chck book solution. Dont need to have a perfect code.
