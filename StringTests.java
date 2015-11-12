public class StringTests {

  //Delegates testing for String related Functions
  public static void main(String[] args) {
    String function = args[0].toLowerCase();
    if (args.length == 0) {
      System.out.println("No test function requested");
    }
    else {
      switch (function) {
        case "replace":
          if (args.length == 4) {
            replaceTest(args[1], args[2], args[3]);
          }
          else {
            wrongNumberArgs(function,4,args.length-1);
          }
          break;
        case "permutation":
          if (args.length == 3) {
            permutationTest(args[1],args[2]);
          }
          else {
            wrongNumberArgs(function,3,args.length-1);
          }
          break;
        case "compress":
          if (args.length == 2) {
            compressTest(args[1]);
          }
          else {
            wrongNumberArgs(function,2,args.length - 1);
          }
          break;
        default:
          System.out.println("Unknown Test Function: " + function);
      }
    }
  }

  private static void wrongNumberArgs(String func, int num, int prov) {
    System.out.println(func + "require(s) " + num + " args, " + prov +  " provided");
  }

  private static void compressTest(String s) {
    char[] c_s = s.toCharArray();
    System.out.println("Original String:\n\t" + s);
    StringStuff.compress(c_s);
    System.out.println("Compressed String:\n\t" + new String(c_s));
  }

  /** Prints a Replace Test, where S is the target string, O is the occurence to
   be replaced by T, the target. */
  private static void replaceTest(String s, String o, String t) {
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
  private static char[] paddify(char[] str) {
    char[] paddedStr = new char[255 + str.length];
    for (int i = 0; i < str.length; i += 1) {
      paddedStr[i] = str[i];
    }
    return paddedStr;
  }

  private static void permutationTest(String s1, String s2) {
     System.out.println(StringStuff.isPermutation(s1, s2));
  }
}
