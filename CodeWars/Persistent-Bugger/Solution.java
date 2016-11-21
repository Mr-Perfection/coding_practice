class Persist {
  /*
    function getNum:
      @param: n, long, is the number that you are given.
      description:
        -this function recursively calls itself until the base case n == 0 where there is nothing to be divided.
        -ex) n = 39, result = 27
      @return: result, long
  */
  public static long getNum(long n)
  {
    if (n == 0) return (1);
    return (getNum(n / 10) * (n % 10));
  }
  /*
    persistance:
      @param: n, long
      @return: count, int, a number that counts how many times n needs to be called by getNum to reach single digit.
  */
	public static int persistence(long n) {
		int count = 0;
    while(n > 9)
    {
      n = getNum(n);
      count++;
    }
    return (count);
	}
}