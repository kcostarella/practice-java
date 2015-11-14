public class StringTest {

  public void compressString(String s) {
    char[] c_s = s.toCharArray();
    System.out.println("Original String:\n\t" + s);
    StringStuff.compress(c_s);
    System.out.println("Compressed String:\n\t" + new String(c_s));
  }

  /** Prints a Replace Test, where S is the target string, O is the occurence to
   be replaced by T, the target. */
  public void replaceString(String s, String o, String t) {
    char[] sentence = s.toCharArray();
    char[] occurence = o.toCharArray();
    char[] target = t.toCharArray();
    sentence = paddify(sentence);
    System.out.println("Original Sentence:");
    System.out.println("\t" + new String(sentence));
    System.out.println("Modified Sentence:");
    StringStuff.replace(sentence, occurence, target);
    System.out.println("\t" + new String(sentence));
  }

  /** Pads str with a sufficent amount of space */
  private char[] paddify(char[] str) {
    char[] paddedStr = new char[255 + str.length];
    for (int i = 0; i < str.length; i += 1) {
      paddedStr[i] = str[i];
    }
    return paddedStr;
  }

  public void permutationString(String s1, String s2) {
     System.out.println(StringStuff.isPermutation(s1, s2));
  }
}
