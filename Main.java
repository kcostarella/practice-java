import java.util.Scanner;
public class Main {

  public static void main(String[] args) {
    initalize();
    welcome_message();
    while (true) {
      String input = prompt(main_prompt);
      parse(input);
    }
  }

  private static void initalize() {
    scan = new Scanner(System.in);
    matrixTest = new MatrixTest();
    stringTest = new StringTest();
    arrayTest = new ArrayTest();

  }

  private static String prompt(String msg) {
    System.out.print(msg);
    return scan.nextLine();
  }

  private static void parse(String input) throws ArrayIndexOutOfBoundsException {
    try {
      String[] args = input.split(" ");
      String arg = args[0];
      switch (arg) {
        case "matrix":
          welcome_matrix();
          run_matrix();
          welcome_back();
          break;
        case "string":
          welcome_strings();
          run_strings();
          welcome_back();
          break;
        case "array":
          welcome_arrays();
          run_array();
          welcome_back();
          break;
        case "quit":
          System.exit(0);
          break;
        default:
          break;
      }
    }  catch (ArrayIndexOutOfBoundsException e) {
      printError();
    }
  }

  private static void run_matrix() throws ArrayIndexOutOfBoundsException,
  NullPointerException {
    while (true) {
      String input = prompt(matrix_prompt);
      String[] args = input.split(" ");
      String arg = args[0];
      if (arg.equals("back")) {
        break;
      }
      try {
        switch (arg) {
          case "create":
            if (args.length == 4) {
              matrixTest.createMatrix(args[1],Integer.parseInt(args[2]),
                          Integer.parseInt(args[3]));
            } else {
              matrixTest.createMatrix(args[1],Integer.parseInt(args[2]),
                          Integer.parseInt(args[3]),
                          Integer.parseInt(args[4]));

            }
            break;
          case "multiply":
            matrixTest.multiply(args[1], args[2]);
            break;

          case "insert":
            matrixTest.insert(args[1],Integer.parseInt(args[2]),
                          Integer.parseInt(args[3]),
                          Integer.parseInt(args[4]));
            break;
          default:
            printError();
        }
      }
      catch (ArrayIndexOutOfBoundsException e) {
        System.out.println("wrong number of inputs");
      }
      catch (NullPointerException e) {
        System.out.println(e);
      }
    }
  }

  //Delegates testing for String related Functions
  public static void run_strings() throws ArrayIndexOutOfBoundsException {
    while (true) {
      String input = prompt(string_prompt);
      String[] args = input.split(" ");
      String arg = args[0];
      if (arg.equals("back")) {
          break;
        }
      try {
        switch (arg) {
          case "replace":
              stringTest.replaceString(args[1], args[2], args[3]);
            break;
          case "permutation":
              stringTest.permutationString(args[1],args[2]);
            break;
          case "compress":
              stringTest.compressString(args[1]);
            break;
          default:
            printError();
        }
      } catch (ArrayIndexOutOfBoundsException e) {
        System.out.println("wrong number of inputs");
      }
    }
  }

  //Delegates testing for Array related Functions
  public static void run_array() throws ArrayIndexOutOfBoundsException {
    while (true) {
      String input = prompt(array_prompt);
      String[] args = input.split(" ");
      String arg = args[0];
      if (arg.equals("back")) {
          break;
        }
      try {
        switch (arg) {
          case "mergesort":
            arrayTest.mergeSortTest(args[1]);
            break;
          case "merge":
            arrayTest.mergeTest(args[1], args[2]);
            break;
          case "rotate":
            arrayTest.rotateTest();
            break;
          default:
            printError();
        }
      } catch (ArrayIndexOutOfBoundsException e) {
          System.out.println("wrong number of inputs");
      }
    }
  }

  private static void printError() {
    System.out.println("Whoops!");
  }

  private static void welcome_message() {
    System.out.println(welcome_message);
  }

  private static void welcome_back() {
    System.out.println(welcome_back);
  }

  private static void welcome_matrix() {
    System.out.format(generic_welcome, "Matrix");
  }

  private static void welcome_strings() {
    System.out.format(generic_welcome, "String");
  }

  private static void welcome_arrays() {
    System.out.format(generic_welcome, "Array");
  }

  private static String welcome_message =
  "Welcome to Ko's Tests! To quit, type: 'quit'";
  private static String welcome_back =
  "Welcome back to Ko's Test. To quit, type: 'quit'";
  private static String generic_welcome =
  "Now in %s Test mode. To go back to Ko's Tests, type: 'back'%n";
  private static String main_prompt = "> ";
  private static String matrix_prompt = "matrix: ";
  private static String string_prompt = "string: ";
  private static String array_prompt = "array: ";
  private static Scanner scan;
  private static MatrixTest matrixTest;
  private static ArrayTest arrayTest;
  private static StringTest stringTest;
}
