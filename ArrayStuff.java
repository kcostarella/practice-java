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

  /** Rotates NXN 2D image array IMG by 90 degrees. That is to say if IMG is
  represented as  then the a rotation by 90 degrees sends ri -> c_n - r_i  if
  r_i is row i of the image, and c_n is the last column of the image, represented
  as vectors.*/
  public static void rotateBy90(char[][] img) {
    //a nxn img has n/2 layers. If n is odd, then the middlemost element does
    //not rotate.
    int numLayers = img[0].length / 2;
    Layer layer = new Layer(0, img[0].length-1);
    int currentLayer = 0;
    //While we have more layers to rotate... rotate and move to the next layer
    while (currentLayer < numLayers) {
      rotateLayerBy90(img, layer);
      currentLayer += 1;
      layer.next();
    }
  }

  private static class Layer {
    public int low;
    public int high;
    //Initilizes the low and high bounds of a layer.
    public Layer(int low, int high) {
      this.low = low;
      this.high = high;
    }
    //Creates the next layer
    public void next() {
      low += 1;
      high -= 1;
    }
  }

  private static void rotateLayerBy90(char[][] img, Layer layer) {
    char top,right,bottom,left;
    int i,j;
    for (i = layer.low, j = layer.high; i < layer.high; i += 1, j -=1) {
      //save top
      top = img[layer.low][i];
      // save right
      right = img[i][layer.high];
      // save bottom
      bottom = img[layer.high][j];
      // save left
      left = img[j][layer.low];
      //rotate top->right
      img[i][layer.high] = top;
      //rotate right->bottom
      img[layer.high][j] = right;
      //rotate bottom->left
      img[j][layer.low] = bottom;
      //rotate left->top
      img[layer.low][i]  = left;
    }
  }
}



