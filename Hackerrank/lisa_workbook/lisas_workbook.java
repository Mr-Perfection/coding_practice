import java.io.*;
import java.util.*;
/*Stephen's Workbook*/
public class Solution {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        /*
        inputs:
            5 3  
            4 2 6 1 10
        */
        int ch = sc.nextInt();
        int pglimit = sc.nextInt();
        //create a list of problems per chapter
        List<Integer> pbs = new ArrayList<Integer>();
        //create a list of page number per chapter
        
        int ans = 0;
        int current_pn = 1;
        //loop through all the pages
        for (int i = 0; i < ch; ++i)
        {
            int pb = sc.nextInt();
            pbs.add(pb);
            //find how many pages in this chapter
            //if (i == 0)
               // pns.add(numberOfPages(pb, pglimit));
           // else
                //pns.add(numberOfPages(pb, pglimit) + pns.get(i - 1));
            //find answer 
            //System.out.println(pbs);
            //System.out.println(pns);
            
            for(int j = 1; j <= pbs.get(i) ; j++)
            {
                
                //System.out.println("pbs: "+pbs.get(i));
                //System.out.println("current pg number: "+current_pn);
                //System.out.println("current j: "+j);
                //System.out.println("ans: "+ans);
                if (current_pn == j)
                        ans += 1;
                
               if (j % pglimit == 0 && j != pbs.get(i))
                current_pn++;
            }
            current_pn++;
            
        }
        System.out.println(ans);
        
        sc.close();
        
    }
    
    
        
}