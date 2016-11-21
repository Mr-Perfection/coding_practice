public class Solution {

    //inefficient. N^2 Can you make it more time efficient?
    public int bulbs(ArrayList<Integer> a) {
        int n = a.size();
        int i = 0, j;
        int item;
        boolean all_ones = true; //need to set a flag when all bulbs are turned on ( on = 1)
        int count  = 0;
        //iterate through number of bulbs
        while (i < n)
        {
            j = i;
            all_ones = true;
            //if current element is already 1? then skip it to the next element
            if (a.get(i) == 1)
            {
                i++;
                continue ;
            }
            for (j = i; j < n; ++j)
            {
                item = a.get(j);
                if (all_ones == true && item != 1)
                    all_ones = false;
                a.set(j, (item + 1) % 2);
            }
            count++;
            //System.out.println("a is: " + a);
            //if the first element is still zero then repress the button
            
            if (all_ones == true)
                break;
            i++;
        }
        return (count);
    }
    //efficient O(N) answer.
    // [0 1 0 1]
    /*
        
    */
    public int bulbs(ArrayList<Integer> a) {

        int state = 0;
        int count = 0;
        int i;
        for (i = 0; i < a.size(); ++i)
        {
            if (a.get(i) == state)
            {
                count += 1;
                state = 1 - state;
            }
        }
        return (count);
    }
}