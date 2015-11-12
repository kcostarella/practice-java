public class StringStuff {

  /** Replace all occurences of A with B in place in STR */
  public static void replace(char[] str, char[] a, char[] b) {
    for (int i = 0; i < str.length; i += 1) {
      if (foundMatchAtIndex(str, a, i)) {
        i = dSwapAndIncrement(str, a, b, i); //swaps A for B and returns
                                             //adjusted index
      }
    }
  }

  /** Returns wether s1 is indeed a permutation of s2 */
  public static Boolean isPermutation(String s1, String s2) {
    //true if both are 0
    if (s1.isEmpty() && s2.isEmpty()) {
      return true;
    }
    //false if they are different lengths
    if (s1.length() != s2.length()) {
      return false;
    }
    //If they are the same size, k = s1[0] must be contained in s2
    char k = s1.charAt(0);
    //Since remove will NOT remove k from s2 is S2 does not contain k.
    return isPermutation(remove(k, s1), remove(k, s2));
  }


  /** Returns true IFF all chars of A match all chars of STR starting at index
  I in STR */
  private static Boolean foundMatchAtIndex(char[] str, char[] a, int i) {
    //If the remaning amount of STR is shorter than A
    if (a.length - 1 + i >= str.length) {
      return false;
    }
    else {
      for (int j = 0; j < a.length; j += 1) {
        if (str[i + j] != a[j]) {
          return false;
        }
      }
      return true;
    }
  }

  /** Destructively deletes occurence of A from STR starting at index I in STR,
  then inserts B at index I of STR. Returns I that is the index of the last char
  of B in STR. STR is a char[] with 'padding' at the end. */
  private static int dSwapAndIncrement(char[] str, char[] a, char[] b, int i) {
    if (a.length < b.length) {
      int len = b.length - a.length;
      shiftRight(str, i + a.length, len);
      for (int j = 0; j < b.length; j += 1) {
        str[i + j] = b[j];
      }
    }
    else if (a.length > b.length) {
      int len = a.length - b.length;
      for (int j = 0; j < b.length ; j += 1) {
        str[i + j] = b[j];
      }
      shiftLeft(str, i + a.length, len);
    }
    else {
      for (int j = 0; j < b.length ; j += 1) {
        str[i + j] = b[j];
      }
    }
    return i + b.length - 1;
  }

  /** Shifts all characters right by LEN starting at index I of string STR */
  private static void shiftRight(char[] str, int i, int len) {
    for (int j = str.length - len - 1; j >= i; j -= 1) {
      str[j + len] = str[j];
    }
  }

  /** Shifts all characters by LEN starting at index I of string STR */
  private static void shiftLeft(char[] str, int i, int len) {
    while(i < str.length) {
      str[i - len] = str[i];
      i += 1;
    }
  }

  /** removes the first occurence of char K from string S */
  private static String remove(char k, String s) {
    StringBuffer newString = new StringBuffer();
    Boolean foundK = false;
    for (int i = 0; i < s.length() ; i += 1 ) {
      if (k == s.charAt(i) && !foundK) {
        foundK = true;
      }
      else {
        newString.append(s.charAt(i));
      }
    }
    return newString.toString();
  }

  /** Compresses string STR, represented as a char array, in place. */
  public static void compress(char[] str) {
    int index = 0;
    int end = str.length - 1;
    while (index <= end) {
      int numEntries = entryCount(str,index, end);
      if (numEntries > 1) {
        end = compressAndShift(str, index, end, numEntries);
        index += 1;
      }
      index += 1;
    }
  }
  /** Returns the number of concecutive entries at index I in STR.*/
  private static int entryCount(char[] str, int i, int end) {
    char entry = str[i];
    int num = 0;
    while (i <= end && str[i] == entry)
      {
        num += 1; i += 1;
      }
    return num;
  }
  /** Compresses str by replacing repitions of str[I] with str[I] + n, where
  N is the number of repitions. Compresses the string the appropiate amount,
  N - 2. Returns the int pointing at the end of the compressed str.*/
  private static int compressAndShift(char[] str, int i, int end, int n) {
    compress(str,i,n);
    int shiftAmount = n - 2;
    nullShiftLeft(str,i + n, end, shiftAmount);
    return end - shiftAmount;
  }

  /** replaces n occurences of Str[i] with Str[i] + n */
  private static void compress(char[] str, int i, int n) {
   char c_n = ((n + " ").toCharArray())[0];
   str[i+1] = c_n;
  }

  /** Shifts all strings starting at I left by N, padding the leftmost N chars
  with null */
  private static void nullShiftLeft(char[] str, int i, int end, int n) {
    shiftLeft(str,i,n);
    for (int j = end; j > end - n; j -= 1) {
      str[j] = '\u0000';
    }
  }
}

