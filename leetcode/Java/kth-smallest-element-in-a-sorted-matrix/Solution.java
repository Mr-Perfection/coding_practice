public class Solution {
    public int kthSmallest(int[][] arr, int k) {
        List<Integer> list = new ArrayList<Integer>();
        
        for (int i = 0; i < arr.length; ++i)
        {
            for (int j = 0; j < arr[0].length; ++j)
                list.add(arr[i][j]);
        }
        Collections.sort(list);
        return (list.get(k - 1));
        
    }
}