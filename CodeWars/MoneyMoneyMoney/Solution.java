public class Money {
  public static int calculateYears(double principal, double interest,  double tax, double desired) {
    /*
      formula:
        sum = sum + sum * (interest - interest * tax) = sum * (1 + (interest - interest * tax)) 
    */
    double sum = principal;
    double x = (interest - interest * tax);
    int count = 0;
    while (sum < desired)
    {
      count += 1;
      sum *= (1 + x);
    }
    return (count);
    
  }
}