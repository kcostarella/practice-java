import java.util.AbstractMap;
import java.util.HashMap;

public class MatrixTest {


  public MatrixTest() {
    matrix_map = new HashMap<String, Matrix>();
  }

  public void createMatrix(String name, int row, int col) {
    Matrix m = new Matrix(row,col);
    matrix_map.put(name,m);
    System.out.format("New Matrix %s is:%n", name);
    System.out.println("\t" + m);
  }

   public void createMatrix(String name, int row, int col, int init) {
    Matrix m = new Matrix(row,col,init);
    matrix_map.put(name,m);
    System.out.format("New Matrix %s is:%n", name);
    System.out.println(m);
  }

  public void multiply(String m1, String m2){
    System.out.format("Multiplying %s and %s%n", m1, m2);

    Matrix a = matrix_map.get(m1);
    Matrix b = matrix_map.get(m2);

    System.out.println(m1 + " =\n " + a); System.out.println(m2 + " =\n " + b);

    Matrix m3 = Matrix.matrixMultiply(a,b);

    System.out.print("And the result is:\n");
    System.out.println(m3);

  }

  public void insert(String name, int row, int col, int elem) {
    Matrix m = matrix_map.get(name);
    m.set(row,col,elem);
    System.out.format("Edited Matrix %s is:%n", name);
    System.out.println(m);
  }

  public void show(String name) {
    Matrix m = matrix_map.get(name);
    System.out.println(m);
  }

  private static AbstractMap<String,Matrix> matrix_map;

}
