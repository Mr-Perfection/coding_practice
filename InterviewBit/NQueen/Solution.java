public class Solution {
	

	boolean isSafe(ArrayList<String> chessboard, int row, int col, int n)
    {
        int i, j;
 
        /* Check this row on left side */
        for (i = 0; i < col; i++)
            if (chessboard.get(row).charAt(i) == 'Q')
                return false;
 	
 		/* Check upper diagonal on left side */
        for (i=row, j=col; i>=0 && j>=0; i--, j--)
            if (chessboard.get(row).charAt(i) == 'Q')
                return false;

        /* Check lower diagonal on left side */
        for (i=row, j=col; j>=0 && i< n; i++, j--)
            if (chessboard.get(row).charAt(i) == 'Q')
                return false;
 
        return true;
    }
	
	public void ft_NQueens(ArrayList<ArrayList<String>> solution, ArrayList<String> chessboard, int n, int col)
	{
		//terminating condition
		if (col >= n)
		{
			ArrayList<String> possibility = new ArrayList<String>(chessboard);
			solution.add(possibility);
			return ;
		}
		//get to the last row first.
		//cache.add(chessboard.get(index));
		//check positions first
		//ft_NQueens(solution, chessboard, cache, n, index+1);
		//cache.remove(cache.size() - 1);
		
		for (int i = 0; i < n; ++i)
		{
			char[] arr = new char[n];
			arr = chessboard.get(i).toCharArray();
			if (isSafe(chessboard, i, col, n))
			{
				//place the queen into ith position in array
				arr[col] = 'Q';
				chessboard.remove(i);
				chessboard.add(i, new String(arr));
				ft_NQueens(solution, chessboard, n, col + 1);
				arr[col] = '.';
				chessboard.remove(i);
				chessboard.add(i, new String(arr));
			}
			
		}
	}
	public ArrayList<ArrayList<String>> solveNQueens(int n) {
	    
	    ArrayList<ArrayList<String>> solution = new ArrayList<ArrayList<String>>();
	    ArrayList<String> chessboard = new ArrayList<String>();
	    ArrayList<String> cache = new ArrayList<String>(); //to store the current value of string
	    //initialize the chessboard so that all the queens are located on the left.
	    StringBuilder sb = new StringBuilder();
	    int i = 0;
	    	    //create a string in the length n.
	    for (i = 0; i < n; ++i)
	    	sb.append(".");
	    //System.out.println("the row: " + sb.toString());
	    //create a chessboard with queens in it.
	    for (i = 0; i < n; ++i)
	    {
	    	//System.out.println("the chessboard: " + chessboard);
	    	String str = new String(sb.toString());
	    	chessboard.add(str);
	    }
	    // System.out.println("the chessboard: adf");
	    // System.out.println("the chessboard: " + chessboard);

	    ft_NQueens(solution, chessboard, n, 0);
	    return (solution);
	    
	}
}
