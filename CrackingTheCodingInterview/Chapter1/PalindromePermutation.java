
/*
  Assumptions
  Do we count whitespaces as a character?
  Is it case sensitive? If not, convert all to lowercase String.toLowerCase().
*/
static boolean palindromePermutation(String s ){
  int[] frequency = createFrequency(s);
  return (hasOneOdd(frequency));
}
static int[] createFrequency(String s) {
  int[] freq = new int[26]; //26 alphabets
  for (int i = 0; i < s.length(); ++i) {
    int val = s.charAt(i) - Character.getNumericValue('a');
    if (val >= 0 && val < 26)
      freq[val]++;
  }
  return freq;
}
static boolean hasOneOdd(int[] freq) {
  boolean oneOdd = false;
  for (int num : freq ) {
    if (num % 2 != 0) {
      if (!oneOdd)
        oneOdd = true;
      else
        return false;
    }
  }
  return oneOdd;
}
