public class Solution {
    public static void save_parenthesis(ArrayList<String> solution, String str, int left, int right)
    {
        //depth first search algo.
        //1. base case: left == 0 and right == 0 and terminating case when left > right. this cant be possible
        //because there is no right before left.
        if (left > right)
            return ;
        if (left == 0 && right == 0)
            solution.add(str);
        //2. left > 0? then add '('.
        if (left > 0)
            save_parenthesis(solution, str + '(', left - 1, right);
        //3. right > 0 ? then add ')'.
        if (right > 0)
            save_parenthesis(solution, str + ')', left, right - 1);
    }
	public ArrayList<String> generateParenthesis(int n) {
	    ArrayList<String> solution = new ArrayList<String>();
	    String str = new String();
	    save_parenthesis(solution, str, n, n);
	    return (solution);
	}
}
