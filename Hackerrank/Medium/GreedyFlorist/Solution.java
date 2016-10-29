import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); //the number of flowers
        int k = in.nextInt(); //the number of people in the group.
        int[] a = new int[n]; //collection of flowers
        int[] flowers = new int[k]; //number of flowers per friend
        int i, j;
        int answer = 0;
        for (i = 0; i < n; ++i)
        	a[i] = in.nextInt();
        //sort the array.
        Arrays.sort(a);
        
        Arrays.fill(flowers, 0);
        //each person has to choose flowers
        //2 5 6
        j = 0;
        for (i = n - 1; i >= 0; --i)
        {
            answer += (flowers[j] + 1) * a[i];
            flowers[j] += 1; //add the formula (x + 1) x represents flowers[j]
            j = (j + 1) % k; //because there can be more flowers than friends
        }
        System.out.println(answer);
    }
}