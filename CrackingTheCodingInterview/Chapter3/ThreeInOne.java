// what is the size of an array?
// what do you mean by three stacks? Does that mean when first stack has overflow, that overflow goes to second stack and third stack?
// what is the size of each stack?
public class FixedStack {
  private int numberOfStacks = 3;
  private int stackCapacity;
  private int[] values;
  private int[] sizes;

  public FixedStack(int size) {
    stackCapacity = size;
    values = new int[size * numberOfStacks];
    sizes = new int[numberOfStacks];
  }

  // push value into stack
  public void push(int stackNum, int value) throws FullStackException {
    // check if there is space for new element
    if (isFull(stackNum)) {
      throw new FullStackException();
    }
    // increment stack pointer and update the top value
    sizes[stackNum]++;
    values[indexOfTop(stackNum)] = value;
  }

  public int pop(int stackNum) {
    if (isEmpty(stackNum)) {
      throw new EmptyStackException();
    }
    int topIndex = indexOfTop(stackNum);
    int value = values[topIndex]; //get top
    values[topIndex] = 0;
    sizes[stackNum]--;
    return value;
  }



  private int indexOfTop(int stackNum) {
    int offset = stackNum * stackCapacity;
    int size = sizes[stackNum];
    return offset + size - 1;
  }
  public boolean isFull(int stackNum) {
    return sizes[stackNum] == stackCapacity;
  }
  public boolean isEmpty(int stackNum) {
    return sizes[stackNum] == 0;

  }
}
