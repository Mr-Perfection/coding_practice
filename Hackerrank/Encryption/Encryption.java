import java.io.*;
import java.util.*;

public class Encryption {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String text  = sc.next();
        double L = text.length();   //Get # of inputs  
        double sqrt_L = Math.sqrt(L);   //Square root of L 
        double lower_b = (int)sqrt_L;   //lower bound
        double diff = sqrt_L - lower_b; 
        
                    

        int row = 0;//Find the row
        if(diff < 0.5)
        {
            row  = (int)sqrt_L; 
        }
        else if(diff >= 0.5)
        {
            row = (int)Math.round(sqrt_L);
        }

        int col = (int)L / row; //Find the columns
        if(L % row != 0)    //if remainder of L mod row is not equal to zero
        {
            col+=1; //then add one more column for each row.
        }

        List<ArrayList<String>> words = new ArrayList<ArrayList<String>>(row);//initialize the array for the words
        List<ArrayList<String>> encrypted = new ArrayList<ArrayList<String>>(col);
        int i,j,m, k;   //initialize variables
        int count = 0;  //count the text length


        for(i = 0; i < row; ++i)
        {
            ArrayList<String> temp = new ArrayList<>();
            for (j=0 ; j< col ; ++j) 
            {
                if(count < (int)L)
                {
                    String x = Character.toString(text.charAt(count));  //store the character into words array.
                    temp.add(x);    //add string to the temp arraylist

                    // System.out.println(temp);
                }
                else if(count >= (int)L)
                {
                    temp.add(null); //need this to balance the arraylist sizes corresponding to rows and columns
                }   //EOF else if count>=
                count++;    //increments count
            }   //FOR j
            words.add(temp);
        }
        int difference = count - (int)L;    //find how many empty elements there are.

        // System.out.println(words);

        for (j=0;j<col ; ++j ) 
        {
            ArrayList<String> temp = new ArrayList<>();
            for (i=0;i<row ;++i ) 
            {

               
                // System.out.println(words.get(i).get(j));
                temp.add(words.get(i).get(j));
                
                
            }
            encrypted.add(temp); //add the group elements by column into the encrypted.
            //System.out.println(encrypted.get(j));
            // System.out.println(encrypted);
        }

        count = 0;  //count the text length

        String message = "";    //this is encrypted message
        
        for (j=0 ; j< col ; ++j) 
        {
            for (i=0 ; i< row ; ++i)
            {

            
                if(encrypted.get(j).get(i) !=null)
                    message+=encrypted.get(j).get(i);   //add the word
                
               
            }
            message += " ";
        }
        
        System.out.println(message);
    }//EOF main
}