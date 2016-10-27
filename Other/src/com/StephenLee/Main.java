package com.StephenLee;

import java.util.*;


public class Main {

    static int count = 0;
    public static void main(String[] args) {

//        TrailingZeros(5);
        CountSteps(5);
    }



    public static void CountSteps(int number)
    {
        CountSteps(0,0,number);
        System.out.println(count);
    }


    public static void CountSteps(int x, int y, int N)
    {

        int s1 = sum(x+1, y);
        if(s1 < N)
            CountSteps(x+1,y,N);


        int s2 = sum(x,y+1);
        if(s2 < N)
            CountSteps(x,y+1, N);

        if(s1 == N || s2 == N) {
            count++;
        }
    }


    public static int sum(int x, int y)
    {
        return 1*x + 2*y;
    }
//Time: 2n, space: O(1)

    /***Good things too know:
     *  HashSet:It provides O(1) time for the basic operations, such as add, remove, contains, and size.
     *
     *  ArrayList: It provides
     *  O(1) time for get() method because it is index based data structure so access time is fast.
     *  O(1 - n) for insertion (add) method because consider the case when array is full, we need to copy contents to new array
     *  if array gets full which makes inserting an element into ArrayList of O(n) in worst case, while ArrayList also needs to update its index
     *  O(1 - n) for the same reason as insertion
     *
     *  LinkedList: It provides
     *  O(n) as LinkedList is not an index based data structure so you will need to traverse up to index ,
     *  where index <=n , n is size of linked list
     *  O(1) for insertion (Given a pointer to node we need to insert item) because we needn't to be re-size the array, you just need to update pointers
     *  O(1) for deletion for the same reason as insertion
     *  ****/


}
