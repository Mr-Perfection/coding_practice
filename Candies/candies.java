import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        
        /*
            3  
            1 #1  
            2 #1 
            2 #1
        */
        /**
        approach:
        
        -first iterate through the arr[] array i..n-1
        -if arr[i] > arr[i -1]
        -then students[i] = students[i-1] + 1
        -else students[i] = 1
        -then secondly iterate through the arr[] array n-2...i
        -if arr[i] > arr[i+1]
        -then students[i] = Math.max(students[i], students[i + 1] + 1)
        -Add all students[] elements and there is a solution
        **/
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int arr[] = new int[n];
        int i = 0;
        int students[] = new int[n]; //values are candies amount
        //store all the rating scores into the array
        for(i = 0; i < n; ++i)
        {
            arr[i] = in.nextInt();
            students[i] = 1; //initialize to 1
        } // EOF for loop
        
        //iterate through the array
        for(i = 1; i < n; ++i)
        {
            //if there ith element is greater than i -1 th element, then ith student should get one more candie
            if(arr[i] > arr[i-1])
                students[i] = students[i-1] + 1;
            else
                students[i] = 1;
                
        }
        
        for(i = n - 2; i >= 0; --i)
        {
            if(arr[i] > arr[i+1])
                students[i]=Math.max(students[i], students[i+1] + 1);
        }

        /*for(int i = 1; i < n; ++i)
        {
            //if true, just go to the next element
            //if (arr[i - 1] == arr[i]) 
            //   continue;
            // check the next student has a greater score.
            //if (students[i] == students[i + 1])
            
            //check if this student has equal amount of candies as the previous student
            if ( arr[i] > arr[i - 1])
            {
                if (students[i] <= students[i - 1])
                {
                    students[i] = students[i - 1] + 1;
                }
            }
            else if(arr[i] < arr[i - 1])
            {
                if (students[i] >= students[i - 1])
                {
                    students[i - 1] = students[i] + 1;
                }
            }
            
        }
        */
        
        //solution
        int solution = 0;
        for(i = 0; i < n; ++i)
        {
            //System.out.println(students[i]);
            solution += students[i];
        }
        System.out.println(solution);
    }
    /*
2
4
2
6
1
7
8
9
2
1

1
2
1
2
1
2
3
4
2
1


1   O
2   O
1   O
2   O
1   O
2   O
3
2
1
1

    
    
    **/
}