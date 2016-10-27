//Write a method to replace all spaces in a string with ‘%20’.
private static void replaceFun(String s1)
        {
        char[] s = s1.toCharArray();
        StringBuilder sb = new StringBuilder();
        int j;
        /**Use for loop to find any empty spaces**/
        for(char i:s)
        {
        /***If char i is empty character then append %20 ****/
        if(i == ' ')
        {
        sb.append("%20");
        }
        else
        sb.append(i);
        }

        String s2 = sb.toString();
        System.out.println("Initial string is:"+s1);
        System.out.println("Final string is: " + s2);


        }

public static String ReplaceSpacesWith(String s1)
        {
        if(s1 == null) return null;

        char[] array1 = s1.toCharArray();
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<array1.length;++i)
        {
        if(array1[i] == ' ')
        sb.append("%20");
        else
        sb.append(array1[i]);
        }

        return sb.toString();


        }