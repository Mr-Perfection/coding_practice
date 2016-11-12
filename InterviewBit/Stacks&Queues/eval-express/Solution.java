public class Solution {
    public static boolean check_expression(String c)
    {
        if (c.charAt(0) == '+' || c.charAt(0) == '-' || c.charAt(0) == '*' || c.charAt(0) == '/')
            return (true);
        else
            return (false);
    }
    public static int evaluate(int num1, int num2, String c)
    {
        if (c.charAt(0) == '+')
            return (num1 + num2);
        else if (c.charAt(0) == '-')
            return (num1 - num2);
        else if (c.charAt(0) == '*')
            return (num1 * num2);
        else
            return (num1 / num2);
    }
	public int evalRPN(ArrayList<String> a) {
	    int i = 0;
	    Stack<String> nums = new Stack<String>();
	    int total = Integer.MIN_VALUE;
	    boolean prec = false;
	    while (i < a.size())
	    {
	        if (check_expression(a.get(i)))
	        {
	            if (!nums.empty())
	            {
	                if (total == Integer.MIN_VALUE)
	                {
	                    
	                    int num2 = Integer.parseInt(nums.pop());
	                    int num1 = Integer.parseInt(nums.pop());
	                    System.out.println("num1: "  + num1);
                        System.out.println("num2: "  + num2);
	                    total = evaluate(num1, num2, a.get(i));
	                    //System.out.println("total: "  + total);
	                    if (!nums.empty())
	                        prec = true;
	                    else
	                        prec = false;
	                }
	                else
	                {
	                    int num1 = Integer.parseInt(nums.pop());
	                    if (prec == true)
	                        total = evaluate(num1, total, a.get(i));   
	                    else
	                        total = evaluate(total, num1, a.get(i));  
	                    //if there exists the element
	                    if (!nums.empty())
	                        prec = true;
	                    else
	                        prec = false;
	                    
	                }
	            }
	        }
	        else
	        {
	            //System.out.println("a.get(i): "  + a.get(i));
	            nums.push(a.get(i));
	        }
	        i++;
	    }
	    //while a[i] != +, -, *. /, push to the stack.
	    return total;
	}
}
