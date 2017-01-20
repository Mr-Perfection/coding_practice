Basic Calculator II
Difficulty: Medium

Implement a basic calculator to evaluate a simple expression string.

The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . The integer division should truncate toward zero.

You may assume that the given expression is always valid.

Some examples:
"3+2*2" = 7
" 3/2 " = 1
" 3+5 / 2 " = 5
Note: Do not use the eval built-in library function.

Credits:
Special thanks to @ts for adding this problem and creating all test cases.



public class Solution {
    public int calculate(String s) {
        Stack<Integer> val = new Stack<Integer>();
        Stack<Character> ops = new Stack<Character>();
        int i = s.length() - 1;
        while(i >= 0)
        {
            while(i >= 0 && s.charAt(i) == ' ') i--;
            if (i < 0) break ;
            char c = s.charAt(i);
            if ((c - '0') >= 0 && (c - '0') <= 9)
            {
                int j = i + 1;
                while(i >= 0 && (s.charAt(i) - '0') >= 0 && (s.charAt(i) - '0') <= 9) i--;
                int x;
                i += 1;
                x = Integer.parseInt(s.substring(i, j)); 
                if (!ops.isEmpty())
                {
                    char op = ops.pop();
                    switch (op)
                    {
                        case '+':
                            val.push(x + val.peek());
                        break;
                        case '-':
                            val.push(x - val.peek());
                        break;
                        case '*':
                            val.push(x * val.peek());
                        break;
                        default:
                            val.push(x / val.peek());
                        break;
                    }
                }
                else
                    val.push(x);
                // System.out.println(val);
                // System.out.println(ops);
            }
            else
                ops.push(c);
            i--;
        }
        return (val.peek());
    }
}




//correct solution... Interesting to see iterative approach... wow
public int calculate(String s) {
    if (s == null) return 0;
    s = s.trim().replaceAll(" +", "");
    int length = s.length();
    
    int res = 0;
    long preVal = 0; // initial preVal is 0
    char sign = '+'; // initial sign is +
    int i = 0;
    while (i < length) {
        long curVal = 0;
        while (i < length && (int)s.charAt(i) <= 57 && (int)s.charAt(i) >= 48) { // int
            curVal = curVal*10 + (s.charAt(i) - '0');
            i++;
        }
        if (sign == '+') {
            res += preVal;  // update res
            preVal = curVal;
        } else if (sign == '-') {
            res += preVal;  // update res
            preVal = -curVal;
        } else if (sign == '*') {
            preVal = preVal * curVal; // not update res, combine preVal & curVal and keep loop
        } else if (sign == '/') {
            preVal = preVal / curVal; // not update res, combine preVal & curVal and keep loop
        }
        if (i < length) { // getting new sign
            sign = s.charAt(i);
            i++;
        }
    }
    res += preVal;
    return res;