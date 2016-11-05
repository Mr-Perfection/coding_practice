public class Solution {
	public int canJump(ArrayList<Integer> a) {
	    if (a == null || a.size() == 0)
	        return (0);
	    if (a.size() == 1)
	        return (1);
	    int max = a.get(0);
	    for (int i = 0; i < a.size(); ++i)
	    {
	        //if max is less than the index which means it is unreachable from current position AND current
	        //element is zero.
	        if (max <= i && a.get(i) == 0)
	            return (0);
	        //if current index i + current element A[i] > max, then replace to the new max.
	        if (i + a.get(i) > max)
	            max = i + a.get(i);
	        //finally, if max >= a.size() - 1 then jump to the end array is possible.
	        if (max >= a.size() - 1)
	            return (1);
	    }
	    return (0);
	}
}
