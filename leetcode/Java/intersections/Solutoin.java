public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        //bruteforce method: O(n^2)
        /*
            iterate through two arrays and find any matching pairs.
        */
        /*
            use hashset and list. itereate through first array and store it into the hashset.
            then iterate through the second array and check if set contains the value or not.
            create another set that will filter through the list.
        */
        Set<Integer> set1 = new HashSet<Integer>();
        Set<Integer> set2 = new HashSet<Integer>();
        List<Integer> list = new ArrayList<Integer>();
        List<Integer> sol = new ArrayList<Integer>();
        if (nums1.length == 0 || nums2.length == 0)
            return (new int[0]);
        for (int i = 0; i < nums1.length; ++i)
            set1.add(nums1[i]);
        for (int i = 0; i < nums2.length; ++i)
        {
            if (set1.contains(nums2[i]))
                list.add(nums2[i]);
        }
        for (int i = 0; i < list.size(); ++i)
        {
            
            if (!set2.contains(list.get(i)))
            {    
                set2.add(list.get(i));
                sol.add(list.get(i));
            }
        }
        int[] solution = new int[sol.size()];
        for (int i = 0; i < sol.size(); ++i) solution[i] = sol.get(i);
        return (solution);
        
    }
}