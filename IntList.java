/** A java Integer Linked List. */
public class IntList {

  public IntList(int head, IntList tail) {
    this.head = head;
    this.tail = tail;
  }


  /** Appends item to this IntList's tail. */
  public void append(IntList item) {
    if (this.tail != null) {
      this.tail.append(item);
    } else {
      this.tail = item;
    }
  }

  public IntList push(IntList item) {
    item.tail = this;
    return item;
  }

  /** Deletes node at depth, D */
  public IntList delete(int d) {
   if (d == 0) {
      return this.tail;
    } else if (this.tail == null) {
      return null;
    }
    this.tail = this.tail.delete(d-1);
    return this;
  }

  /** Returns this IntList as a String. For example:
  IntList(1, IntList(2, IntList(3, null))) -> (1 (2 (3, null)))
  */
  @Override public String toString() {
    StringBuffer string = new StringBuffer();
    string.append("( ");
    string.append(recursiveToString());
    string.append(" )");
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
