public static boolean isSubString(String s1, String s2)
        {
        if(s1.length() != s2.length() || s1.length() < 1) return false;
        else if(s1.equals(s2)) return true;

        //recursive call
        boolean result = IsS2SubStringOfS1(s1,s2);

        if(result) return true;
        else return false;
        }

//Here we will be concatenating the strings (S1+S1…)
public static boolean IsS2SubStringOfS1(String s1, String s2)
        {
        if(s1.contains(s2)) return true;////once s1 = s1s1, then check it!

        if(s1.length() == s2.length()) //if s1 length = s2 length
        {
        s1 = s1 + s1;
        return IsS2SubStringOfS1(s1,s2);
        }//EOF if s1 == s2
        return false;
        }

