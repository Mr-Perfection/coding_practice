public class Solution {
    /*
        my approach (recursion):
            for index is from 0 to str1.length - 1 2) iterate througth the entire substring s1.
                        max = Math.max(max, function(s.subString(index + 1), "", index) + 1)
            
        errr...
        Made a mistake in my understanding... duhhh!
        So I assumed only first letter cannot be repeated which is not in this case.
        "abcb" here b is already appearing twice! So it should be "abc" as a return value.
        
        My approach 2 (Iterative):
        for index is from 0 to str1.length
            use hashset[] to keep track of whether the letters are unique or not. if unique or hashset is empty, then store the arr[i].
            if not unique, then stop counting the count and set it to the max value. Then, restart count = 1 with storing arr[i] into hashset[]
                
    */
    // public static int find_length(String s, char c)
    // {
    //     if (s.length() <= 0)
    //         return (0);
    //     if (c == s.charAt(0))
    //         return (0);
    //     return (find_length(s.substring(1), c) + 1);
    // }
    
    public int lengthOfLongestSubstring(String s) {
        //approach 1
        // int ans = 0;
        // for (int i = 0; i < s.length(); ++i)
        // {
        //     ans = Math.max(ans, find_length(s.substring(i + 1), s.charAt(i)) + 1);
        // }
        //approach 2
        HashSet<Character> set = new HashSet<Character>();
        int count = 0;
        int max = 0;
        for (int i = 0; i < s.length();++i)
        {
            count = 0;
            for (int j = i; j < s.length(); ++j)
            {
                //check set is empty or already has the value s.charAt(i) or not.
                if (set.isEmpty() || !set.contains(s.charAt(j)))
                {
                    set.add(s.charAt(j));
                    count += 1;
                }
                else
                    break;
            }
            max = Math.max(max, count);
            set.clear();
        }
        return (max);
        
    }
    public int lengthOfLongestSubstring(String s) {
        //approach 1
        // int ans = 0;
        // for (int i = 0; i < s.length(); ++i)
        // {
        //     ans = Math.max(ans, find_length(s.substring(i + 1), s.charAt(i)) + 1);
        // }
        //O(n) approach
        HashSet<Character> set = new HashSet<Character>();
        int count = 0;
        int max = 0;
        for (int i = 0; i < s.length();++i)
        {
            count = 0;
            for (int j = i; j < s.length(); ++j)
            {
                //check set is empty or already has the value s.charAt(i) or not.
                if (set.isEmpty() || !set.contains(s.charAt(j)))
                {
                    set.add(s.charAt(j));
                    count += 1;
                }
                else
                    break;
            }
            max = Math.max(max, count);
            set.clear();
        }
        return (max);
        
    }
}