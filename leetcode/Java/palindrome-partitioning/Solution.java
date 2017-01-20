public class Solution {
    /* function is_palindrome
        @param: String s, a string input
        return boolean, a boolean value that checks if the string is palindrome
    */
    public static boolean is_palindrome(String s)
    {
        for (int i = 0; i < s.length() / 2 + 1; ++i)
        {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i))
                return (false);
        }
        return (true);
    }
    
    /* function add_palindrome
        @param String s, a string input
        @param int start, a beginning index
        @param ArrayList<String> partition, a list of strings that are palindromes
        @param List<List<String>> solution, a list of partitions
    */
    
    void add_palindrome(String s, int start, List<String> partition,
                        List<List<String>> solution)
    {
        //base case
        if (start == s.length())
        {
            List<String> temp = new ArrayList<String>(partition);
            solution.add(temp);
            return ;
        }
        
        //iterate through the string to get the substrings
        for (int i = start + 1; i <= s.length(); ++i)
        {
            String str = s.substring(start, i);
            if (is_palindrome(str))
            {
                partition.add(str);
                add_palindrome(s, i, partition, solution);
                partition.remove(partition.size() - 1);
            }
        }
    }
    
    //using Backtracking
    /*public static void partition_helper(List<List<String>> solution, List<String> temp, String s)
    {
        //base case: if string s is a palindrome, then return.
        if (is_palindrome(s))
        {
            temp.
            List<String> list = new LinkedList<
        }
    }*/
    
    /* function partition
        @param: String s, a string input
        @return List<List<String>> solution, the two dimensional list
    */
    public List<List<String>> partition(String s) {
        //initializations
        List<List<String>> solution = new ArrayList<List<String>>();
        List<String> temp = new ArrayList<String>();
        add_palindrome(s, 0, temp, solution);
        
        return (solution);
        
    }


}







public class Solution {
    
    /*
    function is_palindrome
    @param String str, a string value (from substrings)
    @return boolean, true or false whether is a palindrome?
    */
    public static boolean is_palindrome(String str)
    {
        int i = 0;
        int j = str.length() - 1;
        
        while (i < j)
        {
            if (str.charAt(i) != str.charAt(j))
                return (false);
            i++;
            j--;
        }
        return (true);
    }
    
    
    /*
    function partition_helper(int start, String s, List<String> list, List<List<String>> solution)
    @param int start, an index that starts from 0.. s.length
    @param String s, a string input
    @param List<String> list, a temporary list that will be stored into the solution
    @param List<List<String>> solution, the solution!
    
    */
    public static void partition_helper(int start, String s, List<String> list, List<List<String>> solution)
    {
        //base case: check if starting index is equal to length of s.
        if (start == s.length())
        {
            //then store list into new list and store into the solution
            List<String> temp = new ArrayList<String>(list);
            solution.add(temp);
            return ;
        }
        
        //iterate through the string s and get the substrings
        for (int i = start + 1; i <= s.length(); ++i)
        {
            String sub = s.substring(start, i);
            if (is_palindrome(sub))
            {
                list.add(sub);
                partition_helper(i, s, list, solution);
                list.remove(list.size() - 1);
            }
        }
    }
    
    public List<List<String>> partition(String s) {
        //initializations
        List<List<String>> solution = new ArrayList<List<String>>();
        List<String> list = new ArrayList<String>();
        partition_helper(0, s, list, solution);
        return (solution);
    }
}