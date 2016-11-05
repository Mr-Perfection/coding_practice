public class Solution {
    public int mice(ArrayList<Integer> mice, ArrayList<Integer> holes) {
        /*
            since ith mice can 1) go to ith hole, 2) go to (i-1)th hole, 3) go to (i+1)th hole,
            iterate through mice i..n and look for i-1, i, i+1 th elements in holes array.
            ensure to take care of the exceptions such as i - 1 < 0 or i + 1 > m etc.
            
            sort the mice and holes increasing order. and add them all up in ascending order to find the maximum
            
            
        */
        int max = 0;
        Collections.sort(mice);
        Collections.sort(holes);
        for (int i = 0; i < mice.size(); ++i)
        {
            max = Math.max(max, Math.abs(mice.get(i) - holes.get(i)));
        }
        
        
        return (max);
        
        // int last_mouse = Integer.MIN_VALUE;
        // int min = Integer.MAX_VALUE;
        // //bruteforce
        // for (int i = 0; i < mice.size(); ++i)
        // {
        //     min = Integer.MAX_VALUE;
        //     //1) aim for the i th hole
        //     if (mice.get(i) - holes.get(i) >= 0)
        //         min = Math.min(min, mice.get(i) - holes.get(i));
        //         System.out.println("mouse is1: " + i + "th..." + min);
        //     //2) aim for the i -1 th hole
        //     if (i - 1 >= 0)
        //     {
        //         if (mice.get(i) - holes.get(i - 1) >= 0)
        //             min = Math.min(min, mice.get(i) - holes.get(i - 1));
        //     }
        //     System.out.println("mouse is2: " + i + "th..." + min);
        //     //3) aim for the i +1 th hole
        //     if (i + 1 < holes.size())
        //     {
        //         if (mice.get(i) - holes.get(i + 1) >= 0)
        //             min = Math.min(min, mice.get(i) - holes.get(i + 1));   
        //     }
        //     System.out.println("mouse is3: " + i + "th..." + min);
        //     if (min == Integer.MAX_VALUE)
        //         continue ;
        //     last_mouse = Math.max(last_mouse, min);
        // }
        // return (last_mouse);
    }
}
