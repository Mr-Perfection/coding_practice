public static String StringCompression(String s)
        {
        int i = 0;
        StringBuilder sb = new StringBuilder();	//StringBuilder to append characters from compressed string
        char[] chars = s.toCharArray();
        int[] ccounts = new int[256];	//Assuming characters are all ASICII values and count how many of those values at each character.
        //Iterate through chars array and count the characters depending on the ASICII value
        for(i=0;i<chars.length;++i)
        {
        int val = (int)chars[i];
        ccounts[val]++;	//counts # of chars
        }
        //Iterate again to create a new String
        for(i=0;i<chars.length;++i)
        {
        int val  = (int)chars[i];
        int count = ccounts[val];
        //there exits character?
        if(count > 0)
        {
        //Just one letter
        if(count == 1)
        {
        sb.append( (char)val);
        }
        //more than one letter
        else
        {
        sb.append( (char)val);
        sb.append( count );
        }	//EOF else
        ccounts[val] = 0;
        }//EOF if count > 0
        } //EOf for loop
        return sb.toString();
        }// EOF class
