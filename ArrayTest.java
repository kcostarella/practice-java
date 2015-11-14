import java.util.Arrays;

public class ArrayTest {

  public void rotateTest() {
    char[][] img = new char[4][];
    img[0] = new char[]{'T', 'T', 'T', 'T'};
    img[1] = new char[]{'T', 'T', 'T', 'T'};
    img[2] = new char[]{'0', 'T', 'T', '0'};
    img[3] = new char[]{'0', 'T', 'T', '0'};
    char[][] t = new char[3][];
    t[0] = new char[]{'x', 'x', 'x'};
    t[1] = new char[]{'0', 'x', '0'};
    t[2] = new char[]{'0', 'x', '0'};
    print(t,3,3);
    System.out.print("\n");
    ArrayStuff.rotateBy90(t);
    print(t,3,3);
  }

  private void print(char[][] img, int n, int m) {
    StringBuffer str = new StringBuffer();
    for (int i = 0;i < n ; i += 1) {
      for (int j = 0;j < m ; j += 1) {
        str.append(img[i][j] + " ");
      }
      str.append("\n");
    }
    System.out.print(str.toString());
  }

  public void mergeSortTest(String arrayInfo) {
    int[] a = stringToIntArray(arrayInfo);
    System.out.println("Original Array:\n\t " + Arrays.toString(a));
    int[] sort = ArrayStuff.mergeSort(a);
    System.out.println("Sorted Array: \n\t " + Arrays.toString(sort));
  }

  public void mergeTest(String aInfo, String bInfo) {
    int[] a = stringToIntArray(aInfo);
    int[] b = stringToIntArray(bInfo);
    System.out.println("Original Array A:\n\t " + Arrays.toString(a));
    System.out.println("Original Array B:\n\t " + Arrays.toString(b));
    int[] c = ArrayStuff.merge(a,b);
    System.out.println("Merged Array C:\n\t " + Arrays.toString(c));
  }


  private int[] stringToIntArray(String arrayInfo) {
    char[] c = arrayInfo.toCharArray();
    int[] result = new int[c.length];
    for (int i = 0; i < c.length; i += 1) {
      result[i] = Character.getNumericValue(c[i]);
    }
    return result;
  }
}
