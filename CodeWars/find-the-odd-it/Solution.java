import java.lang.*;
import java.util.*;
public class FindOdd {
	public static int findIt(int[] A) {
	//use hashmap to store the A elements and see how many they appear.
	Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	int maxKey = A[0];
	int maxValue = Integer.MIN_VALUE;
  	for (int i = 0; i < A.length; ++i)
    {
//     	//map already has the key
//       if (map.containsKey(A[i]))
//       {
//         int value = map.get(A[i]) + 1;
//         if (value % 2 != 0)
//         {
//           if (maxValue < value)
//           {  
//             maxValue = value;
//             maxKey = A[i];
//             System.out.println("max: " + maxKey);
//           }

//         }
        if (map.containsKey(A[i]))
          map.put(A[i], map.get(A[i]) + 1);
        else
          map.put(A[i], 1);
//       }
      
    }
    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
      int key = entry.getKey();
      int value = entry.getValue();
      if (value % 2 != 0)
      
    // ...
    }
    return (maxKey);
  }
}