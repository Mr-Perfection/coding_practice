import java.util.*;
import java.io.*;
public class StringCompress {


  String strCompressSolution(String s) {
    //similar approach with my strCompress solution but
    /*
      there is a tradeoff
      the book solution says
      This will be more optimal in cases where we don't have
      a large number of repeating characters.
      It will avoid us having to create a string that we never use.
      The downside of this is that it causes a second loop through the characters and
       also adds nearly duplicated code.
    */

  }

  // Time complexity O(n^2) because it reallocates the memory
  // when it exceeds the preallocated memory
  // Space O(n)
  String strCompress(String s) {

    if (s == null || s.length() <= 2) {
      return s;
    }
    StringBuilder sb = new StringBuilder();
    int i = 1, charCount = 1;
    char c = s.charAt(0);
    sb.append(c);
    while (i < s.length()) {
      if (c == s.charAt(i)) {
        charCount++;
      }
      else {
        sb.append(Integer.toString(charCount));
        sb.append(s.charAt(i));
        charCount = 1;
        c = s.charAt(i);
      }
      i++;
    }
    sb.append(Integer.toString(charCount));

    System.out.println("sb is  " + sb);
    if (sb.length() < s.length())
      return sb.toString();
    else
      return s;
  }
  public static void main(String[] args) {
      StringCompress sc = new StringCompress();
      System.out.println("aabddcAAAxz => " + sc.strCompress("aabddcAAAxz"));
      System.out.println("cccccccccCCCAaaA => " + sc.strCompress("cccccccccCCCAaaA"));
      System.out.println("aaddddccccczzzzz => " + sc.strCompress("aaddddccccczzzzz"));

  }
}
// static String strCompress(String s) {
//   int[] table = new int[52]; //0-25 lowercase, 26-52 uppercase
//   String str;
//
//   // iterate through s and convert it into our hashtable.
//   for (char c : s.toCharArray()) {
//     int val = createCharValue(c);
//     if (val != -1)
//       table[val]++;
//   }
//
//   //convert the table into String
//   str = convertTableToString(table);
//   if (str.length() < s.length())
//     return str;
//   else
//     return s;
// }
//
// static int createCharValue(char c) {
//
//   int value = Character.getNumericValue(c);
//   int a = Character.getNumericValue('a');
//   int z = Character.getNumericValue('z');
//   int A = Character.getNumericValue('A');
//   int Z = Character.getNumericValue('Z');
//
//   if (value >= a && value <= z)
//     return value - a;
//   if (value >= A && value <= Z)
//     return value - A + 26;
//   return -1;
// }
//
// static String convertTableToString(int[] table) {
//   int a = Character.getNumericValue('a');
//   int A = Character.getNumericValue('A');
//   StringBuilder sb = new StringBuilder();
//
//   for (int i = 0;i < table.length ; ++i ) {
//     if (i < 26) {
//       if (table[i] > 0)
//         sb.append((char)(i + a));
//         sb.append(Integer.toString(table[i]));
//     }
//     else {
//       if (table[i] > 0)
//         sb.append((char)(i + A));
//         sb.append(Integer.toString(table[i]));
//     }
//   }
//   return sb.toString();
// }
