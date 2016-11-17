
/*
For example, given array S = [-1, 0, 1, 2, -1, -4],

backtracking approach:
-recursively call the function and increments the index.
-have a temporary array that will store three S[i].
-check the size of this array and if it is equal to 3 then check if it is unique and store into solution[][]

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]
*/

//backtracking works but slow
public class Solution {
    public static void threeSumHelper(int[] nums, List<Integer> a, List<List<Integer>> sol, int index, int sum)
    {
        if (a.size() == 3)
        {
            //System.out.println("a: " + a);
            // int sum = 0;
            // for (int i = 0; i < a.size(); ++i)
            //     sum += a.get(i);
            if (sum == 0 && !sol.contains(a))
            {
                ArrayList<Integer> t = new ArrayList<Integer>(a);
                sol.add(t);
            }
            return ;
        }
        if (index >= nums.length)
            return ;
        for (int i = index; i < nums.length; ++i)
        {
            a.add(nums[i]);
            threeSumHelper(nums, a, sol, i + 1, sum + nums[i]);
            a.remove(a.size() - 1);
        }
    }
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        //for (int i = 0; i < nums.length; ++i)
            //System.out.println(nums[i] + " ");
        List<List<Integer>> solution = new ArrayList<List<Integer>>();
        List<Integer> temp = new ArrayList<Integer>();
        threeSumHelper(nums, temp, solution, 0, 0);
        return (solution);
    }
}


public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
 
    if(nums == null || nums.length<3)
        return result;
 
    Arrays.sort(nums);
 
    for(int i=0; i<nums.length-2; i++){
        if(i==0 || nums[i] > nums[i-1]){
            int j=i+1;
            int k=nums.length-1;
 
            while(j<k){
                if(nums[i]+nums[j]+nums[k]==0){
                    List<Integer> l = new ArrayList<Integer>();
                    l.add(nums[i]);
                    l.add(nums[j]);
                    l.add(nums[k]);
                    result.add(l);
 
                    j++;
                    k--;
 
                    //handle duplicate here
                    while(j<k && nums[j]==nums[j-1])
                        j++;
                    while(j<k && nums[k]==nums[k+1])
                        k--;
 
                }else if(nums[i]+nums[j]+nums[k]<0){
                    j++;
                }else{
                    k--;
                }
            }
        }
 
    }
 
    return result;
}


public class Solution {
    public List<List<Integer>> threeSum(int[] num) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(num);
        int N = num.length;
        for (int i = 0; i < N-2 && num[i] <= 0; ++i)
        {
            if (i > 0 && num[i] == num[i-1])
                continue; // avoid duplicates
            int twosum = 0 - num[i];
            int l = i + 1, r = N - 1;
            while (l < r)
            {
                int sum = num[l] + num[r];
                if (sum < twosum) ++l;
                else if (sum > twosum) --r;
                else {
                    ArrayList<Integer> tmp = new ArrayList<Integer>();
                    tmp.add(num[i]); tmp.add(num[l]); tmp.add(num[r]);
                    res.add(tmp);
                    ++l; --r;
                    while (l < r && num[l] == num[l-1]) ++l;  // avoid duplicates
                    while (l < r && num[r] == num[r+1]) --r;  // avoid duplicates
                }
            }
        }
        return res;
    }
}