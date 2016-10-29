public class Solution {
    public int lis(final List<Integer> list) {
        //if list is empty or does not exist
        if (list == null || list.size() == 0)
            return (0);
        int i, j;
        int n = list.size();
        int[] count = new int[n];
        count[0] = 1;
        //my first attempt...
        // for (i = 1; i < n; ++i)
        // {
        //     int item = list.get(i);
        //     if (list.get(i - 1) < item)
        //     {
        //         count[i] = count[i - 1] + 1;
        //     }
        //     else
        //     {
        //         j = i;
        //         //find the element that is less than item
        //         while (j >= 0 && list.get(j) >= item)
        //             j--;
        //        //something went wrong
        //         if (j < 0)
        //             count[i] = 1;
        //         else
        //             count[i] = count[j] + 1;
                
        //     }
        // }
        for (i = 0; i < n; ++i)
            count[i] = 1;

        for (i = 1; i < n; ++i)
        {
            for (j = 0; j < i; ++j)
            {
                if (list.get(i) > list.get(j) && count[i] < count[j] + 1)
                    count[i] = count[j] + 1;
            }
        }
        int max = Integer.MIN_VALUE;
        for (i = 0; i < n; ++i)
        {
            max = (count[i] > max) ? count[i] : max;
        }
        return (max);
    }
}
/*
89 69 54 19 51 16 54 64 89 72 40 31 43 1 11 82 65 75 67 25 98 31 77 55 88 85 76 35 101 44 74 29 94 72 39 20 24 23 66 16 95 5 17 54 89 93 10 7 88 68 10 11 22 25 50 18 59 79 87 7 49 26 96 27 19 67 35 50 10 6 48 38 28 66 94 60 27 76 4 43 66 14 8 78 72 21 56 34 90 89

*/
