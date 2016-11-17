public class Solution {
    public String longestCommonPrefix(String[] strs) {
        //get the string with the min length
        int index = 0;
        int length = Integer.MAX_VALUE;
        String s;
        if (strs == null || strs.length == 0)
            return "";

        if (strs.length <= 1)
            return (strs[0]);
        for (int i = 0; i < strs.length; ++i)
        {
            if (strs[i].length() < length)
            {
                length = strs[i].length();
                index = i;
            }
        }
        //get the string with the min. length.
        s = strs[index];
        //iterate through all elemenets with two loops to find when does the word stop matching
        int prefix = Integer.MAX_VALUE;
        for (int i = 0; i < strs.length; ++i)
        {
            if (i != index)
            {
                int temp = 0;
                for (int j = 0; j < s.length(); ++j)
                {
                    if (s.charAt(j) == strs[i].charAt(j))
                        temp++;
                    else
                        break;
                }
                prefix = Math.min(prefix, temp);
            }
            
        }
        return (s.substring(0, prefix));
    }
}