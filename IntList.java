/** A java Integer Linked List. */
public class IntList {

  public IntList(int head, IntList tail) {
    this.head = head;
    this.tail = tail;
  }

  /** Returns this IntList as a String. For example:
  IntList(1, IntList(2, IntList(3, null))) -> 1 2 3
  */
  @Override public String toString() {
    StringBuffer string = new StringBuffer();
    string.append("[ ");
    string.append(recursiveToString());
    string.append("]");
    return string.toString();
}

  private String recursiveToString() {
    StringBuffer string = new StringBuffer();
    string.append(this.head);
    string.append(", ");
    if (this.tail != null) {
    string.append(this.tail.toString());
    } else {
      string.append("null");
    }
    return string.toString();
  }

  public int head;
  public IntList tail;

  /** Reverses the elements of IntList L */
  public static IntList reverse(IntList l) {
    if (l == null) {
      return null;
    }
    else if (l.tail == null) {
      return l;
    }

    else {
      //Reverse the rest of the list
      IntList rest = reverse(l.tail);
      //Make tail of Head.tail point to Head. Make Head.tail point to null
      l.tail.tail = l;
      l.tail = null;
      return rest;
    }
  }
}
