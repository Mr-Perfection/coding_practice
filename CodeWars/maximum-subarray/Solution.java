import java.lang.*;
import java.util.*;

public class Max {
  public static int sequence(int[] arr) {
    int max = 0;
    int temp = 0;
    for(int i = 0; i < arr.length; ++i)
    {
      temp = temp + arr[i];
      if (temp > 0)
        max = Math.max(temp, max);
      else
        temp = 0;
    }
    return max;
  }
}