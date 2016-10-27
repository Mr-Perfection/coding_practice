//#my answer1
private static void uniqueChars(String str)
        {
        char[] chars = str.toCharArray();
        Set<Character> set = new LinkedHashSet<Character>();
        for(char c:chars)
        {
        set.add(c);
        } //Add the chars to set
        StringBuilder sb = new StringBuilder();
        for(Character c:set)
        {
        sb.append(c);
        }
        System.out.println(sb.toString());

        }

//#my answer2
private static void removeDuplicates(String str)
        {
        char[] s = str.toCharArray();
        int len = str.length();
        int i;
        boolean match = false;
        int tail = 1;
        if(len <2)
        {
        return;
        }

        for(i=1;i<len;++i)
        {
        int j;

        for( j=0;j<tail;++j)
        {
        if(s[i]==s[j])break;


        }
        //Check if tail is equal to j. It means s[i] is not equal to s[j]
        if(j == tail)
        {
        s[tail] = s[i];
        tail++;
        }

        }
        s[tail] = 0;


//        for(i=0;i<len;++i)
//        {
////            System.out.println(s[i]);
//
//            if(s[i]==s[tail])
//            {
//                match = true;
//            }
//            if(match)
//            {
////                System.out.println("match found?");
//                s[i]= Character.MIN_VALUE;
//                match = false;
//            }
//            tail++;
//        }//EOF for i

        String newString = new String(s);
//        String c = Character.toString('\0');
//        newString = newString.replaceAll(c,"");
        System.out.println(newString);

        } //EOF removeDuplicates

//Solution

public static void removeDuplicates(char[] str) {
        if (str == null) return; // if the array does not exist..nothing to do return.
        int len = str.length; // get the array length.
        if (len < 2) return; // if its less than 2..can't have duplicates..return.
        int tail = 1; // number of unique char in the array.
        // start at 2nd char and go till the end of the array.
        for (int i = 1; i < len; ++i) {
        int j;
        // for every char in outer loop check if that char is already seen.
        // char in [0,tail) are all unique.
        for (j = 0; j < tail; ++j) {
        if (str[i] == str[j]) break; // break if we find duplicate.
        }
        // if j reachs tail..we did not break, which implies this char at pos i
        // is not a duplicate. So we need to add it our "unique char list"
        // we add it to the end, that is at pos tail.
        if (j == tail) {
        str[tail] = str[i]; // add
        ++tail; // increment tail...[0,tail) is still "unique char list"
        }
        }
        str[tail] = 0; // add a 0 at the end to mark the end of the unique char.
        String newString = new String(str);
        System.out.println(newString);
        }
