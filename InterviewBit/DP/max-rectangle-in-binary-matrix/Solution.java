public class Solution {
	public int maximalRectangle(ArrayList<ArrayList<Integer>> a) {
		int max_area = 0;
		int width = 0;	//width of the max_area
		int height = 0;	//height of the max_area
	    int rows = a.size();
	    int cols = a.get(0).size();
	    int[] d = new int[cols];
	    //initialize the array d with all zeros.
	    Arrays.fill(d, 0);
	    
	    //iterate through the rows and cols.
	    for (int i = 0; i < rows; ++i)
	    {
	    	//Use Histagram algorithm
	    	//iterate through the columns to get the row dp. dp[i] = dp[i] + 1 only if element in a is 1 else reset to 0.
	    	for (int j = 0; j < cols; ++j)
	    	{
	    		if(a.get(i).get(j) == 1)
	    			d[j] = d[j] + 1;
	    		else
	    			d[j] = 0;
	    	}
	    	//find the maximum area.
	    	width = 0;
	    	height = 0;
	    	for (int k = 0; k < cols; ++k)
	    	{
	    		height = Math.min(height, d[k]);
	    		if (d[k] == 0)
	    			width = 0;
	    		else
	    			width += 1;
	    	}
	    	max_area = Math.max(max_area, height * width);
	    }
	    return (max_area);
	}
}
