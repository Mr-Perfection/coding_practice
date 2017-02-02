// can i use other data structure?
public class MyStack {
  private LinkedList<Integer> buff = new LinkedList<Integer>();
  private int minValue;
  private int size;

  public MyStack() {
    minValue = Math.MAX_VALUE;
    size = 0;
  }

  public int min(int value ) {
    if (isEmpty()) {
      throw new EmptyStackException();
    }
    return minValue;
  }

  public void push(int value){
    buff.addLast(value);
    setMin(value);
    size++;
  }

  public int pop() {
    if (isEmpty()) {
      throw new EmptyStackException();
    }
    int value = buff.removeLast();
    int tmp = size;
    int _minValue = Math.MAX_VALUE;
    while (--tmp >= 0) {
      int el = buff.get(tmp);
      _minValue =  el < _minValue ? el : _minValue;
    }
    minValue = _minValue;
    size--;
    return value;
  }

  private boolean isEmpty(){
    return buff.isEmpty();
  }

  private void setMin(int value ) {
    if (minValue > value) {
      minValue = value;
    }
  }
}


// book solution. subclass of Stack smart!
public class StackwithMin extends Stack<Integer> {
  Stack<Integer> stack;
  public StackwithMin() {
    stack = new Stack<Integer>();
  }

  public void push(int value ) {
    if (value <= min()) {
      stack.push(value);
    }
    super.push(value);
  }
  public Integer pop() {
    int value = super.pop();
    if (value == min()) {
      stack.pop();
    }
    return value;
  }
  public int min() {
    if (stack.isEmpty()) {
      throw new EmptyStackException();
    }
    return stack.peek();
  }
}
