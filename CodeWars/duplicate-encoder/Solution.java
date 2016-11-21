import java.lang.*;
import java.util.*;
public class DuplicateEncoder {
	static String encode(String word){
    //store into hashmap<character, integer>. Count how many there exist same characters in the string per character:)
    Map<Character, Integer> map = new HashMap<Character, Integer>();
    StringBuilder sb = new StringBuilder();
    word = word.toUpperCase(); 
    for (int i = 0; i < word.length(); ++i)
    {
      char c = word.charAt(i);
      if (map.containsKey(c))
        map.put(c, map.get(c) + 1);
      else
        map.put(c, 1);
    }
    for (int i = 0; i < word.length(); ++i)
    {
      char c = word.charAt(i);
      if (map.get(c) == 1)
        sb.append('(');
      else
        sb.append(')');
    }
    return sb.toString();
  }
}
