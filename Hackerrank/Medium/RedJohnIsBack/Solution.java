import java.io.*;
import java.util.*;

public class Solution {
    
    static int is_prime(int n)
    {
        if (n == 2)
            return (1);
        if (n % 2 == 0)
            return (0);
        for (int i = 3; i * i <= n; i+=2)
        {
            if ( n % i == 0)
                return (0);
        }
        return (1);
            
    }
    //memoization
    static int ft_get_primes(int N, HashMap<Integer, Integer> cache)
    {
        //base case
        if (N <= 1)
            return (0);
        if (!cache.containsKey(N))
        {
            cache.put(N, ft_get_primes(N - 1, cache) + is_prime(N));
        }
        return (cache.get(N));    
        
        
    }
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        //understood the question wrong...:/
        HashMap<Integer, Integer> cache = new HashMap<Integer, Integer>();
        for (int t = 0; t < T; ++t)
        {
            int N = in.nextInt();
            //System.out.println(ft_get_primes(N - 1,cache));
            int[] store = new int[N + 1];
            Arrays.fill(store, 0);
            int i = 0;
            //starting value store[i]
            store[i] = 1;
            for (i = 1; i <= N; ++i)
            {
                store[i] += store[i - 1];
                if (i - 4 >= 0)
                    store[i] += store[i - 4]; //1 |  1 1 1 2 3 4 5
            }
            int res = store[N];
            System.out.println(ft_get_primes(res, cache));
            
        }
    }
}