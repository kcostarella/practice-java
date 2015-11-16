/** A matrix */
public class Matrix {

  //Underlying matrix
  private int[][] matrix;

  private int row, col;

  public Matrix(int row, int col) {
    this.row = row;
    this.col = col;
    matrix = new int[row][col];

  }

  public Matrix(int row, int col, int init) {
    this.row = row;
    this.col = col;
    matrix = new int[row][col];
    fill(init);
  }

  public void fill(int init) {
    for (int i = 0;i < row ; i += 1) {
      for (int j = 0; j < col; j += 1) {
        matrix[i][j] = init;
      }
    }
  }

  public int row() {
    return row;
  }

  public int col() {
    return col;
  }

  public int get(int row, int col) throws AssertionError {
    assert row < this.row && col < this.col;
    return matrix[row][col];
  }

  public int[] get (int row) throws AssertionError {
    assert row < this.row;
    return matrix[row];
  }

  public void set(int row, int col, int elem) throws AssertionError {
    assert row < this.row && col < this.col;
    matrix[row][col] = elem;
  }

  public void set(int i, int[] v_t) throws AssertionError {
    assert i < this.row && v_t.length == this.col;
    matrix[row] = v_t;
  }

  public Matrix transpose() {
    Matrix transpose = new Matrix(this.col(),this.row());
    for (int i = 0;i < this.row(); i += 1) {
      for (int j = 0;j < this.col() ;j += 1) {
        transpose.set(j,i, this.get(i,j));
      }
    }
    return transpose;
  }

  /** Returns C = A * B, the result of multiplying matrix A by matrix B. */
  public static Matrix matrixMultiply(Matrix a, Matrix b) throws AssertionError {
    assert a.col() == b.row();
    Matrix c = new Matrix(a.row(), b.col());
    b = b.transpose();
    for (int i = 0;i < a.row(); i += 1) {
      for (int j = 0; j < b.row(); j += 1) {
        c.set(i,j, dotProduct(a.get(i), b.get(j)));
      }
    }
    return c;
  }

 /** Returns the dot product A dot B, where A and B are int Vectors*/
  public static int dotProduct(int[] a, int[] b) throws AssertionError {
  assert a.length == b.length;
  int i, p;
  for(i = p = 0; i < a.length; i += 1) {
      p += a[i] * b[i];
    }
  return p;
  }

  public static Matrix identity(int row) {
    Matrix identity = new Matrix(row,row,0);
    for (int i = 0;i < identity.row(); i += 1) {
      for (int j = 0; j < identity.col(); j += 1) {
        if (i == j) {
          identity.set(i,j,1);
        }
      }
    }
    return identity;
  }

  /** if A.get(n,m) == 0 set row n and column m = 0.*/
  public static void setZeroPropigate(Matrix a, int n, int m) {
    if (a.get(n,m) == 0) {
      for (int row = 0; row < a.row() ; row += 1 ) { //for each row of A
        if (row == n) { //if this is the row to be zeroed...
          for (int col = 0; col < a.col(); col += 1 ) {
            a.set(row,col,0); //set all entries of this row to 0
          }
        } else {
          a.set(row,m,0); //set just element in column m to be zero
        }
      }
    }
  }

  @Override public String toString() {
    StringBuffer s = new StringBuffer();
    for (int i = 0;i < row ; i += 1) {
      s.append("|  ");
      for (int j = 0; j < col; j += 1) {
        s.append(matrix[i][j] + "  ");
      }
      s.append("|\n");
    }
    return s.toString();
  }
}
