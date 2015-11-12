import static java.lang.System.*;
public class ArrayStuff {

  /** Returns a sorted int[] C that is the result of merging (assumingly sorted)
  int[] A and int[] B. */
  public static int[] merge(int[] a, int[] b) {
    int[] c = new int[a.length + b.length];
    merge(a, 0, a.length - 1, b, 0, b.length - 1, c, 0);
    return c;
  }

  /** Merges A[l0..u0] with B[l1..u1] starting at index K in C. */
  private static void merge(int[] a, int l0, int u0, int[] b, int l1, int u1, int[] c, int k) {
    while (u0 >= l0 && u1 >= l1) {
      if (a[l0] < b[l1]) {
        c[k] = a[l0];
        k += 1; l0 += 1;
      }
      else {
        c[k] = b[l1];
        k += 1; l1 += 1;
      }
    }

    if (u0 < l0) {
      while (u1 >= l1) {
        c[k] = b[l1];
        k += 1; l1 += 1;
      }
    }
    else {
      while (u0 >= l0) {
        c[k] = a[l0];
        k += 1; l0 += 1;
      }
    }
  }

  /** mergeSort (nlog(n)) sorting algorithm for int[] A
  B */
  public static int[] mergeSort(int[] a) {
    return mergeSort(a,0, a.length - 1);
  }

  /** Recurisve mergeSort sorting algorithm for A[l0..u0] */
  private static int[] mergeSort(int[] a, int l, int u) {
    if (u == l) {
      //Creates the single array that is inherently sorted
      int[] single = {a[l]};
      return single;
    }
    else {
      return merge(mergeSort(a, l, l + (u-l)/2), mergeSort(a, l + (u-l)/2 + 1, u));
    }
  }
}
