import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {



    /**
    game id| player id | team id | batting order | substitute id |
    45252q34, asfdsa432,   asdfde3   1                1
    45252q34, asfdsa432,   asdfde3   1                2
    45252q34 asfdsa432   asdfde3   2                1
    
    45252q34, asdfsafsa,   asdfde3   1 
    45252q34 asfdsa432   asdfde3   2                1


    **/
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner in = new Scanner(System.in);
        List<List<String>> table = new ArrayList<List<String>>();
        while(in.hasNext())
        {
            String input = in.next();
            List<String> list = Arrays.asList(input.split(","));
            table.add(list);
        }
        boolean[] checks = new boolean[table.size()];
        Arrays.fill(checks, false);
        for (int i = 0; i < table.size(); ++i)
        {
            if (checks[i] == true) continue ;
            List<String> row = table.get(i);
            int j = i;
            checks[j] = true;
            int max = Integer.parseInt(row.get(5));
            while (++j < table.size())
            {
                if (checks[j] == true) continue ;
                if (!table.get(j).get(0).equals(row.get(0)) || !table.get(j).get(1).equals(row.get(1)) || !table.get(j).get(4).equals(row.get(4))) continue ;
                if (Integer.parseInt(table.get(j).get(5)) > max)
                {
                    max = Integer.parseInt(table.get(j).get(5));
                    checks[j] = true;
                    row = table.get(j);
                }
            }
            //System.out.println("i: "+ i + " " + row);
            for (int k = 0; k < 4; ++k) System.out.print(row.get(k) + ",");
            System.out.print(row.get(4) + "\n");
        }
    }
}





import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/*
[user.p.id2] just made a three pointer! [user.p.id1] got a rebound... What? who stole the ball from [user.p.id3]

answer:
user.pid2, user.pid1
user.pid3

*/


public class Solution {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner in = new Scanner(System.in);
        List<String> players = new ArrayList<String>();
        while(in.hasNext())
        {    
            String str = in.next();
            if (str.charAt(0) == '[' && str.charAt(str.length() - 1) == ']')
            {
                if (!str.substring(1, 7).equals("nba.p.")) continue ;
                players.add(str.substring(1, str.length() - 1));
            }
            //System.out.println(str);
        }
        //System.out.println("players: " + players);
        for (int i = 0; i < players.size(); ++i)
        {
            if (i == players.size() - 1)
            {
                System.out.print(players.get(i));
                break;
            }
            if (i % 2 != 0)
                System.out.println(players.get(i));
            else
                System.out.print(players.get(i) + ",");
        }
        in.close();
    }
}