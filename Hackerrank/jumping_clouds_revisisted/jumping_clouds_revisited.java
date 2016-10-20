import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
//https://www.hackerrank.com/challenges/jumping-on-the-clouds-revisited
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int c[] = new int[n];
        int E = 100; //max. energy
        int i = 0; //ith cloud
        for(int c_i=0; c_i < n; c_i++){
            c[c_i] = in.nextInt();
        }
        // first jump to (i + k) % n th cloud
        i = (i + k) % n;
        while (i != 0)
        {
            //cloud is thunderstorm. +2 damage
            if (c[i] == 1)
                E -= 2;
                
            E -= 1;
            i = (i + k) % n;
        }
        
        //what is 0th cloud? Thunderstorm?
        if(c[i] == 1)
            E -= 3;
        else
            E -= 1;
        System.out.println(E);
    }
}
