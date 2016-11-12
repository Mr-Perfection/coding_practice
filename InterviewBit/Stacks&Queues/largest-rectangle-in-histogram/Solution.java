public class Solution {
	public int largestRectangleArea(ArrayList<Integer> a) {
	    //2 1 5 6 2 3 => 5 * 2 = 10
	    // 2 3 1 5 4 3 => 3 * 3 = 9  
	    if (a == null || a.size() == 0)
	        return (0);
	    int i = 0, max  = 0;
	    Stack<Integer>  stack = new Stack<Integer>();
	    while (i < a.size())
	    {
	        //check if stack is empty. If not empty, check if current ith element is greater or equal to 
	        //a[top element of stack]
	        if (stack.isEmpty() || a.get(i) >= a.get(stack.peek()))
	        {
	            stack.push(i);
	            i++;   
	        }
	        else
	        {
	            //if a.get(i) element starts to decrease then track the max area
	            int p = stack.pop();
	            //get the height from the stack element which is the previous height.
	            int height = a.get(p);
	            //get the width i - stack.peek() - 1 if stack is not empty
	            int width = stack.isEmpty() ? i : i - stack.peek() - 1;
	            //keep on saving the max
	            max = Math.max(max, height * width);
	        }
	    }
	    //there could be some elements left in the stack 
	    while (!stack.isEmpty())
	    {
	    	int p = stack.pop();
	    	int height = a.get(p); 
	    	int width = stack.isEmpty() ? i : i - stack.peek() - 1;
	    	max = Math.max(max, height * width);
	    }
	    return (max);
	}
}
