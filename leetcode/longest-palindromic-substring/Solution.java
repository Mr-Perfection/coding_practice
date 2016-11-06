public class Solution {
    //Approach #1 time out... 
    public static boolean check_palindrome(String s)
    {
        for (int i = 0; i < s.length() / 2; ++i)
        {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i))
                return (false);
        }
        return (true);
    }
    // public static String longestPalindrome(String s, StringBuilder pal, int index)
    // {
    //     if (s.length() <= 0)
    //         return pal.toString();
    //     if (s.length() <= pal.length())
    //         return pal.toString();
    //     for (int i = index; i < s.length(); ++i)
    //     {
    //         if (check_palindrome(s.substring(index, i + 1)))
    //         {
    //             if (s.substring(index, i + 1).length() > pal.length())
    //                 pal = new StringBuilder(s.substring(index, i + 1));
    //         }
    //     }
    //     return longestPalindrome(s.substring(1), pal, index);
    // }

    //time out again... piece of shit
    public static String longestPalindrome2(String s)
    {
        StringBuilder pal = new StringBuilder();
        if (s.length() <= 0)
            return pal.toString();
        if (s.length() <= pal.length())
            return pal.toString();
        for (int i = 0; i < s.length(); ++i)
        {
            if (pal.length() >= s.length() - i)
                return (pal.toString());
            for (int j = s.length() - 1; j >= i; --j)
            {
                if (s.charAt(i) == s.charAt(j))
                {
                    if (check_palindrome(s.substring(i, j + 1)))
                        if (pal.length() < s.substring(i, j + 1).length())
                            pal = new StringBuilder(s.substring(i, j + 1));
                }
            }
        }
        return (pal.toString());
    }



    /*
        this function will expand from the center to left and right and check if str[left] = str[right].
        if they are equal, then update the palindrome
    */
    public static String start_from_center(String s, int left, int right)
    {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right))
        {
            left--;
            right++;
        }
        return (s.substring(left + 1, right));
    }

    public String longestPalindrome(String s) {
        /*
            ex) My approach:
            1)  "aba" => "aba" = "aba" (reverse string) =>"aba"
            2)  "aaba" => "aaba" != "abaa" => "aba" => "aba" = "aba" => "aba" hurray!
            3)  "abcd" => "abcd" != "dcba" => ... d = d => return "d" nah should return "a"
            
            My approach 2 (use recursion) => corrct but time out. n^3 worst case
            1: "ccd" => "c" check if its a palindrome => "cc" update the current palindrome string => "ccd" nope. =>
                "c", "cc" is > "c", nope. => "cd" not a palindrome nope!
            void longestPalindrome(String s, StingBuilder pal, int index) 
                //terminating conditions
                if s.length <= 0
                    return ;
                if s.length <= pal.length
                    return ;
                for i is index..s.length - 1
                    if checkpalindromme(s.substring(index, i))
                        if pal.isempty || s.substring(index, i).length is > pal.length
                            pal = new Stringbuilder(s.substring(index, i))
                        end
                    end
                end
                longestPalindrome(s.substring(1), pal, index) 
                
            end
            
            My approach #3
            DP approach:
        */
        StringBuilder pal = new StringBuilder(s.substring(0, 1));

        for (int i = 0; i < s.length() - 1; ++i)
        {
            String new_pal = new String(start_from_center(s, i, i));
            if (pal.length() < new_pal.length())
                pal = new StringBuilder(new_pal);
                
            String new_pal2 = new String(start_from_center(s, i, i + 1));
            if (pal.length() < new_pal2.length())
                pal = new StringBuilder(new_pal2);
        }
        return (pal.toString());
    }
}