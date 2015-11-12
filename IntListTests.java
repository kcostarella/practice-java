public class IntListTests {
  public static void main(String[] args) {
    IntList list = new IntList(1, new IntList(2, new IntList(3, null)));
    System.out.println("Original list: " + list);
    IntList rList = IntList.intListReverse(list);
    System.out.println("Reverse list: " + rList);
  }
}
