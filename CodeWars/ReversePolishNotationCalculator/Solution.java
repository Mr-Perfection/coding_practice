import java.lang.*;
import java.util.*;

    /*
      
    5 1 2 + 4 * + 3 -
    
    5 1 2
    exp: 1 + 2
    5
    5 4
    exp: (1 + 2) * 4
    5
    exp: (1 + 2) * 4 + 5
    
    3
    exp: (1 + 2) * 4 + 5 - 3
    
    5 + ((1 + 2) * 4) - 3
    */
import java.lang.*;
import java.util.*;

//just one test case does not pass...
/*
  shouldWorkWithComplexExpressions(CalcTest)
✘ Should work with complex expressions expected:&lt;7.0&gt; but was:&lt;-0.14285714285714285&gt;

*/
import java.lang.*;
import java.util.*;

public class Calc {
  public double evaluate(String expr) {
    if (expr == null || expr.length() == 0)
      return (0);
    LinkedList<Double> num = new LinkedList<Double>();
    Double solution = Double.MAX_VALUE;
    int i = 0;
    boolean neg = false;
    Double number = 0.0;
    while (i < expr.length())
    {
      if (expr.charAt(i) - '0' >= 0 && expr.charAt(i) - '0' <= 9)
      {
        int start = i;
        while ( i < expr.length() && expr.charAt(i) != ' ')
          i++;
        if (start == expr.length() - 1)
          num.add(Double.parseDouble(expr.substring(start)));
        else
          num.add(Double.parseDouble(expr.substring(start,i)));
      }
      else if (expr.charAt(i) == '+' || expr.charAt(i) == '-' || 
                expr.charAt(i) == '*' || expr.charAt(i) == '/')
      {
        if (solution == Double.MAX_VALUE)
              solution = num.removeLast();
        switch(expr.charAt(i))
        {
          case '+':
              solution = num.removeLast() + solution;
          break;
          case '-':
              solution = num.removeLast() - solution;
          break;
          case '*':
            solution = num.removeLast() * solution;
          break;
          default:
            solution = num.removeLast() / solution;
          break;
        } 
      }
      i++;
    }
    if (solution == Double.MAX_VALUE)
      solution = num.removeLast();
    return solution;
  }
}


//I had to google it... similar approach but instead of creating a solution variable which keeps track of the result
//push it into the deque or stack and use the last two elements for the operations.

public class Calc {
  public double evaluate(String expr) {
    if (expr == null || expr.length() == 0)
      return (0);
    LinkedList<Double> num = new LinkedList<Double>();
    int i = 0;
    boolean neg = false;
    Double number = 0.0;
    while (i < expr.length())
    {
      if (expr.charAt(i) - '0' >= 0 && expr.charAt(i) - '0' <= 9)
      {
        int start = i;
        while ( i < expr.length() && expr.charAt(i) != ' ')
          i++;
        if (start == expr.length() - 1)
          num.add(Double.parseDouble(expr.substring(start)));
        else
          num.add(Double.parseDouble(expr.substring(start,i)));
      }
      else if (expr.charAt(i) == '+' || expr.charAt(i) == '-' || 
                expr.charAt(i) == '*' || expr.charAt(i) == '/')
      {
        
        Double first = num.removeLast();
        Double second = num.removeLast();
        switch(expr.charAt(i))
        {
          case '+':
              num.add(second + first);
          break;
          case '-':
              num.add(second - first);
          break;
          case '*':
              num.add(second * first);
          break;
          default:
              num.add(second / first);
          break;
        }
      }
      i++;
    }
    return num.removeLast();
  }
}