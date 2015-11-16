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
    listTest = new ListTest();
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
        case "list":
          welcome_list();
          run_list();
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
  NullPointerException, NumberFormatException {
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
            if (args.length == 2) {
              String name = args[1];
              //perform key lookup?
              matrixTest.show(name);
              while(true) {
                input = prompt("inserting into " + name + ": ");
                args = input.split(" ");
                if(args[0].equals("back")) {
                  break;
                }
                matrixTest.insert(name,Integer.parseInt(args[0]) - 1,
                                  Integer.parseInt(args[1]) - 1,
                                  Integer.parseInt(args[2]));

              }
            } else {
              matrixTest.insert(args[1],Integer.parseInt(args[2]) - 1,
                            Integer.parseInt(args[3]) - 1,
                            Integer.parseInt(args[4]));
              }
            break;
          case "show":
            matrixTest.show(args[1]);
            break;
          case "transpose":
            matrixTest.transpose(args[1]);
            break;
          case "quit":
            System.exit(0);
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
      catch (NumberFormatException e) {
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
          case "quit":
            System.exit(0);
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
          case "quit":
            System.exit(0);
            break;
          default:
            printError();
        }
      } catch (ArrayIndexOutOfBoundsException e) {
          System.out.println("wrong number of inputs");
      }
    }
  }

  public static void run_list() throws ArrayIndexOutOfBoundsException,
  NumberFormatException {
    while (true) {
      String input = prompt(list_prompt);
      String[] args = input.split(" ");
      String arg = args[0];
      if (arg.equals("back")) {
          break;
        }
      try {
        switch (arg) {
          case "createSingle":
            listTest.createSingle(args[1], Integer.parseInt(args[2]));
            break;
          case "createDouble":
            listTest.createDouble(args[1], Integer.parseInt(args[2]));
            break;
          case "append":
            listTest.append(args[1],args[2]);
            break;
          case "push":
            listTest.push(args[1],args[2]);
            break;
          case "delete":
            listTest.delete(args[1], Integer.parseInt(args[2]));
            break;
          case "show":
            listTest.print(args[1]);
            break;
          case "quit":
            System.exit(0);
            break;
          default:
            printError();
        }
      } catch (ArrayIndexOutOfBoundsException e) {
          System.out.println("wrong number of inputs");
      } catch (NumberFormatException e) {
        System.out.println("this function requires ints as arguments");
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

  private static void welcome_list() {
    System.out.format(generic_welcome, "List");
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
  private static String list_prompt = "list: ";
  private static Scanner scan;
  private static MatrixTest matrixTest;
  private static ArrayTest arrayTest;
  private static StringTest stringTest;
  private static ListTest listTest;
}
