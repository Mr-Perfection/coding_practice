/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    
    /*
    n = 0
    n = 1
    1
    n = 2
   1         2     
    \       /    
     2     1     
   
    n = 3
   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
   n = 4
	



    */

   public static ArrayList<TreeNode> ft_helper(int m, int n)
   {
   		int i;
   		ArrayList<TreeNode> result = new ArrayList<TreeNode>();
   		if (m > n)
   		{
   			result.add(null);
   			return (result);
   		}
   		for (i = m; i < n; ++i)
   		{
   			ArrayList<TreeNode> ls = ft_helper(m, i-1);
        	ArrayList<TreeNode> rs = ft_helper(i+1, n);
        	for(TreeNode l: ls){
	            for(TreeNode r: rs){
	                TreeNode curr = new TreeNode(i);
	                curr.left=l;
	                curr.right=r;
	                result.add(curr);
	            }
	        }
   		}
   		return (result);
   }

   public ArrayList<TreeNode> generateTrees(int n) {
   		if (n == 0)
   			return (new ArrayList<TreeNode>());
   		return (ft_helper(1, n));
   }
	public ArrayList<TreeNode> generateTrees(int a) {
		int i;
		int n = a;
		int[] count = new int[n + 1];
		/****
		given value : 3
		DP approach:
		count[0] = 1 //no root
		count[1] = 1 //1 root
		count[2] = count[0] * count[1] //1 is a root
					+ count[1] * count[0] = 2 //2 is a root
		count[3] = count[0] * count[2] //1 is a root ,2 = 3 - 1 - 0
					+ count[1] * count[1] // 2 is root ,1 = 3 - 1 - 1
					+ count[2] * count[0] //3 is a root ,0 = 3 - 1 - 2
					= 2 + 2 + 1 = 5
		count[4] = count[0] * count[3] //1 is a root
					+ count[1] * count[2] //2 is a root
					+ count[2] * count[1] // 3 is root
					+ count[3] * count[0] // 4 is root
					= 5 + 2 + 5 = 12
		count[n] = sum(count[0..k]*count[k+1...n]) 0 <= k < n-1 k = 1 if n = 3

		****/
		Arrays.fill(count, 0);
		count[0] = 1;
		count[1] = 1;
		for (int i = 2; i <= n; i++) {
			for (int j = 0; j <= i - 1; j++) {
				count[i] = count[i] + count[j] * count[i - j - 1];
			}
		}
		return (count[n]);
	}
}
