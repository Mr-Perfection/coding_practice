import java.lang.*;
import java.util.*;
public class TenMinWalk {
  public static boolean isValid(char[] walk) {
    int[] coordinate = new int[4]; //0: east, 1: west, 2: north, 3: south
    Arrays.fill(coordinate, 0);
    if (walk.length != 10)
      return (false);
    for (int i = 0; i < walk.length; ++i)
    {
      if (walk[i] == 'e') coordinate[0]++;
      else if (walk[i] == 'w') coordinate[1]++;
      else if (walk[i] == 'n') coordinate[2]++;
      else coordinate[3]++;
    }
    int x = coordinate[0] - coordinate[1], y = coordinate[2] - coordinate[3];
    return (x == 0 && y == 0); 
  }
}