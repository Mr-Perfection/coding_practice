public class Solution {
	//my god.... im sooo stupiddd
	public static boolean ft_check_palindrome(String str)
	{
		int n = str.length() - 1;
		int i = 0;
		while (i < n) //make sure not to count the n
		{
			if (str.charAt(i) != str.charAt(n - i))
				return (false);
			i++;
		}
		return (true);
	}
	public static void ft_partition_helper( ArrayList<ArrayList<String>> solution, ArrayList<String> list, String str, int n, int start )
	{
		//terminating condition when the start index is equal to length of string n.
		if (start == n)
		{
			//do something
			ArrayList<String> temp = new ArrayList<String>(list);			
			solution.add(temp);
			return;
		}
		//goes all the way to n  aab\0
		for (int i = start; i <= n; ++i) //n = 3
		{
			String sub = str.substring(start, i); //aa, b
			//check if this string is palindrome
			if (ft_check_palindrome(sub))
			{
				list.add(sub);	//list: [aa, b]
				ft_partition_helper(solution, list, str, n, i + 1); // start = 2
				list.remove(list.size() - 1);
			}

		}
	}
	public ArrayList<ArrayList<String>> partition(String a) {
		//aab
		// aa, b 1
		// a, a, b 2
		//aababcc	    
		if (a == null || a.length() == 0)
			return (null);
		ArrayList<ArrayList<String>> solution = new ArrayList<ArrayList<String>>();
		ArrayList<String> list = new ArrayList<String>();
		ft_partition_helper(solution, list, a, a.length(), 0);
		return (solution);
	}
}
