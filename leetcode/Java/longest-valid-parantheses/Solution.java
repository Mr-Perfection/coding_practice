public class Solution {

    public static int longestValidParentheses(String s) {
	Stack<int[]> stack = new Stack<int[]>();
	int result = 0;
 	//iterate through the string
	for(int i=0; i<=s.length()-1; i++)
	{
		char c = s.charAt(i);
		//left parenthesis
		if(c == '(')
		{	
			//0: indicates '(',  1: indicates ')'
			int[] a = {i,0};
			stack.push(a);
		}else{
			//if stack is empty and peeked element is ')'
			if(stack.empty() || stack.peek()[1] == 1)
			{
				int[] a = {i, 1};
				stack.push(a);
			}else{
				//if the previous stacked element is '(' then pop.
				stack.pop();
				int currentLen = 0;
				//if stack is empty then set current length to i + 1
				if(stack.empty()){
					currentLen = i + 1;
				}else{
					//not empty, then i - previous index
					currentLen = i - stack.peek()[0] + 1;
				}
				result = Math.max(result, currentLen);
			}
		}
	}
 
	return result;
}
}

/*
test case:
	(())(
	
	stack:
	(
	(
	
	((
	((
	
	(()
	(
	1

	(())

	4

	(())(
	(
	4
*/