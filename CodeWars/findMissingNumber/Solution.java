import java.lang.*;
import java.util.*;

public class BrokenSequence {
		public int findMissingNumber(String sequence) {	
      if(sequence.isEmpty())
        return 0;
      int j = 1;
      for (int i = 0; i < sequence.length(); ++i)
      {
        if (sequence.charAt(i) == ' ')
          continue;
        if (sequence.charAt(i) < '0' || sequence.charAt(i) > '9')
          return (1);
        if(sequence.indexOf(j + "") == -1)
          return (j);
        j += 1;
      }
      return 0;

    }
    
}