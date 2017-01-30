static boolean OneAway(String s1, String s2) {
  if (s1.length() - s2.length() > 1)
    return false;

  String str1 = s1.length() > s2.length() ? s2 : s1;
  String str2 = s1.length() > s2.length() ? s1 : s2;
  int i = 0, j = 0;
  boolean oneDiff = false;
  while (i < s1.length(), j < s2.length()) {
    if (s1.charAt(i) != s2.charAt(j)) {
      if (oneDiff)
        return false;
      oneDiff = true;
      if (s1.length() == s2.length())
        i++;
    }
    else
      i++;
    j++;
  }
  return true;
}
