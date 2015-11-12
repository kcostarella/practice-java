import java.util.Arrays;

public class ArrayTests {
  //Delegates testing for Array related Functions
  public static void main(String[] args) {
    String function = args[0].toLowerCase();
    if (args.length == 0) {
      System.out.println("No test function requested");
    }
    else {
      switch (function) {
        case "mergesort":
          if (args.length == 2) {
            mergeSortTest(args[1]);
          }
          else {
            System.out.println(function +  "requires 1 argument, " +
              (args.length - 1) + " provided.");
          }
          break;
        case "merge":
          if (args.length == 3) {
            mergeTest(args[1], args[2]);
          }
          else {
            System.out.println(function +  "requires 2 argument, " +
              (args.length - 1) + " provided.");
          }
          break;
        default:
          System.out.println("Unknown Test Function: " + function);
      }
    }
  }

  private static void mergeSortTest(String arrayInfo) {
    int[] a = stringToIntArray(arrayInfo);
    System.out.println("Original Array:\n\t " + Arrays.toString(a));
    int[] sort = ArrayStuff.mergeSort(a);
    System.out.println("Sorted Array: \n\t " + Arrays.toString(sort));
  }

  private static void mergeTest(String aInfo, String bInfo) {
    int[] a = stringToIntArray(aInfo);
    int[] b = stringToIntArray(bInfo);
    System.out.println("Original Array A:\n\t " + Arrays.toString(a));
    System.out.println("Original Array B:\n\t " + Arrays.toString(b));
    int[] c = ArrayStuff.merge(a,b);
    System.out.println("Merged Array C:\n\t " + Arrays.toString(c));
  }


  private static int[] stringToIntArray(String arrayInfo) {
    char[] c = arrayInfo.toCharArray();
    int[] result = new int[c.length];
    for (int i = 0; i < c.length; i += 1) {
      result[i] = Character.getNumericValue(c[i]);
    }
    return result;
  }
}
