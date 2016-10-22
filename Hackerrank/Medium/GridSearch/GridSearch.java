import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();   //Get # of inputs
        int i,j,m, k,R_a = 0,C_a = 0,R_b = 0,C_b = 0;
        boolean matchFlag = true;

        for(i = 0; i < T; ++i)//Create test cases
        {
            

            if(sc.hasNextInt())
                R_a = sc.nextInt();    //get # of elements (rows) in a String_a array
            if(sc.hasNextInt())
                C_a = sc.nextInt();    //get # of characters per row
            List<String> array_a = new ArrayList<>(R_a);  //create new array_a for all the inputs 
            
        
            for(j = 0; j<R_a; ++j)
            {   
                
                if(sc.hasNext())
                {   
                    String integers = sc.next();
                    if(!integers.isEmpty())
                    {
                        if(integers.length() == C_a)   //check if it matches with C
                        {
                            array_a.add(integers);    //Store integers into element of array.
                            //System.out.println(array_a.get(j));
                        }   //EOF check integers length
                    }//EOF check null integers
                    //System.out.println(j);
                }
            }//For loop for rows array_a

            k = 0;   //initialize k every test case
            int x = R_a; //set x to the total rows of array_a
            if(sc.hasNextInt())
                R_b = sc.nextInt();    //get # of elements (rows) in a matrix 
            if(sc.hasNextInt())
                C_b = sc.nextInt();    //get # of characters per row
            List<Integer> matches = new ArrayList<Integer>();
            
            for(m = 0; m<R_b; ++m)
            {   
                if(sc.hasNext())
                {   
                    String integers = sc.next();
                    
                    
                    
                    if(integers.length() == C_b)   //check if it matches with C
                    {

                         
                        while(k < array_a.size())
                        {
                            int match = array_a.get(k).indexOf(integers);

                            // System.out.println(array_a.get(k));
                            // System.out.println(integers);

                           // System.out.println(k);  
                            //System.out.println(match);  

                            if(match == -1) //if the array_A row does not contain the integers
                            {
                                //System.out.println("inside"+match);  
                                

                                if(x < R_b)
                                {
                                    
                                    matchFlag =false;   //no match
                                    break;

                                }


                            }
                            else if(match != -1)
                            {
                                
                                
                                //System.out.println(integers);
                                //System.out.println(match);
                                matches.add(match); //save the index of integers in grid for later use. We are going to compare whether 
                                                    //they areat the same position or not.
                                x--;    //decrements x.
                                k++;    //increments k.
                                
                                break;
                            }

                            x--;    //decrements x.
                            k++;    //increments k.
                            
                        }   //EOF while

                        

                    }   //EOF check integers length
                  
                        
                }
                

   
            }// For loop for rows grid
            if(matches.size() == R_b)   //if # of matches are equal to how many integers row are in matrix
            {
                matchFlag = true;   //at least there are matches. need to check if those integers are at the same index position.
            }
            else
                matchFlag = false;

            if(matchFlag == true)
            {
                int indexPosition = matches.get(0);
                int total = 0;  //count how many matches are at the same index
                for(k = 0; k<matches.size(); ++k)
                {
                    
                    if(matches.get(k) == indexPosition)
                    {
                        //System.out.println(k);
                        total++;
                    }
                }   //EOF for
                if(total == matches.size())
                    System.out.println("YES");
                else
                    System.out.println("NO");

            }//EOF matchFlag

            else if(matchFlag == false)
            {
                System.out.println("NO");
                

            }        


            


        }//EOF for test cases
        
        
    }
}