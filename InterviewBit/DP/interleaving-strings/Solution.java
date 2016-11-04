public class Solution {
    //bruteforce method
    public static int isInterleave_helper(String a, String b, String c, int indexa, int indexb, int indexc) 
    {
        //base cases
        if (indexc >= c.length())
            return (1); //true
        int ans = 0;
            //check if indexa is less than a.length() and if a[indexa] == c[indexc]
        if (indexa < a.length() && a.charAt(indexa) == c.charAt(indexc))
            ans |= (isInterleave_helper(a, b, c, indexa + 1, indexb, indexc + 1));
        //check if indexb is less than b.length() and if b[indexb] == c[indexc]
        if (indexb < b.length() && b.charAt(indexb) == c.charAt(indexc))
            ans |= (isInterleave_helper(a, b, c, indexa, indexb + 1, indexc + 1));
        //if nothing works, then this is false.
        return (ans);
            
    }
    public int isInterleave(String a, String b, String c) {
        return (isInterleave_helper(a, b, c, 0, 0, 0));
    }
}
