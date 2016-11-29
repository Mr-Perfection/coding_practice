import java.lang.*;
import java.util.*;

public class BrainLuck {
    char bf[];
    public BrainLuck(String code) {      
      bf = code.toCharArray();
    }

    public String process(String input) {
        char stack[] = input.toCharArray();
        int i = 0;
        int ptr = 0;
        int inst = 0;
        //initialize the array to 0.
//         while(--i >= 0)
//           stack[i] = 0;
        //itereate through the instruction
        while (inst < bf.length)
        {
          if (bf[inst] == '>') ptr++;
          else if (bf[inst] == '<') ptr--;
          else if (bf[inst] == '+') stack[ptr]++;
          else if (bf[inst] == '-') stack[ptr]--;
          else if (bf[inst] == '.') System.out.print(stack[ptr]);
          else if (bf[inst] == ']')
          {
            if (stack[ptr] != 0)
            {
              i = 0;
              inst--;
              while(inst < bf.length)
              {
                if (bf[inst] == ']') i++;
                if (bf[inst] == '[' && i == 0) break;
                else if( bf[inst] == '[') i--;
                inst--;
              }
            }
          }
          else if (bf[inst] == '[')
          {
            if (stack[ptr] == 0)
            {
              i = 0;
              inst++;
              while(inst < bf.length)
              {
                if (bf[inst] == '[') i++;
                if (bf[inst] == ']' && i == 0) break;
                else if( bf[inst] == ']') i--;
                inst++;
              }
            }
          }
          inst++;
        }
        
        
        
      return new String(stack);
    }
}