 import java.lang.*;
 import java.util.*;
 public class Kata
{
    public static void reverse_list(List<Long> list, int i, int j)
    {
      while(i < j)
      {
        long temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
        i++;
        j--;
      }
    }
    public static void swap(List<Long> list, int i, int j)
    {
      long temp = list.get(i);
      list.set(i, list.get(j));
      list.set(j, temp);
    }
    /*
        the logic:
          find the first decreasing order ex) 513 , 1 at ith position is decreasing.
          swap if and only if the value from num.length - 1.. is greater than value at i.
          reverse(i + 1, length - 1)

    */
    public static long nextBiggerNumber(long n)
    {
      List<Long> list = new ArrayList<Long>();
      while(n > 0)
      {
        list.add(n % 10);
        n /= 10;
      }
      Collections.reverse(list);
      int i = list.size() - 2;
      while(i > 0)
      {
        if (list.get(i) < list.get(i + 1))
          break;
        i--;
      }
      int k = list.size() - 1;
      while(k > i && list.get(i) >= list.get(k)) k--;
      if (k == i)  return (-1);
      swap(list, i, k);
      reverse_list(list, i + 1, list.size() - 1);
      long solution = 0;
      for(int j = 0; j < list.size(); ++j)
        solution = solution * 10 + list.get(j);
      return (solution);
    }
}