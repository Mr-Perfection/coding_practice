import java.lang.*;
import java.util.*;
public class BraceChecker {
  public boolean isValid(String braces) {
    Stack<Character> stack = new Stack<Character>();
    for (int i = 0; i < braces.length(); ++i)
    {
      if (braces.charAt(i) == '(' || braces.charAt(i) == '{' || braces.charAt(i) == '[') stack.push(braces.charAt(i));
      else if (braces.charAt(i) == ')')
      {
        if (stack.isEmpty() || stack.peek() != '(') return (false);
        else stack.pop();
      }
      else if (braces.charAt(i) == '}')
      {
        if (stack.isEmpty() || stack.peek() != '{') return (false);
        else stack.pop();
      }
      else
      {
        if (stack.isEmpty() || stack.peek() != '[') return (false);
        else stack.pop();
      }
    }
    if (!stack.isEmpty()) return (false);
    return (true);
  }
}