/*
 * Complete the function below.
 */
    

    static int fact(int n)
    {
     return (n <= 1)? 1 :n * fact(n-1);
    }
    // Construct a count array where value at every index
  // contains count of smaller characters in whole string
    static void populateAndIncreaseCount (int[] count, char[] str)
    {
          int i;
         for( i = 0; i <= str[i]; ++i )
           ++count[ str[i] ];
         for( i = 1; i < 256; ++i )
           count[i] += count[i-1];
    }
    static void updatecount (int[] count, char ch)
    {
        int i;
        for( i = ch; i < 256; ++i )
            --count[i];
    }


    static int findRank (char[] str)
    {
      int len = str.length;
      int mul = fact(len);
      int rank = 1;
      int i;
      int[] count = new int[256];
      // Populate the count array such that count[i] contains count of 
      // characters which are present in str and are smaller than i
      populateAndIncreaseCount( count, str );

      for (i = 0; i < len; ++i)
      {
          mul /= len - i;

          // count number of chars smaller than str[i]
          // fron str[i+1] to str[len-1]
          rank += count[ str[i] - 1] * mul;

          // Reduce count of characters greater than str[i]
          updatecount (count, str[i]);
      }

      return rank;
    }
    static int[] get_ranks(String[] words) {
        int[] ans = new int[words.length];
        for(int i = 0; i < words.length; ++i)
        {
            String word = words[i];  
            ans[i] = findRank(word.toCharArray());
        }
        return ans;

    }

