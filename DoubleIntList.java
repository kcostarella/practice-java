public class DoubleIntList  {

  public DoubleIntList(DoubleIntList head, int data, DoubleIntList tail) {
  this.head = head;
  this.data = data;
  this.tail = tail;
  }

  public void append(DoubleIntList elem) {
    if (this.tail != null) {
      this.tail.append(elem);
    } else {
      this.tail = elem;
      elem.head = this;
    }
  }

  public DoubleIntList delete(int d) {
    if (d == 0) {
        return this.tail;

      } else if (this.tail == null) {
        return null;
      }

      this.tail = this.tail.delete(d-1);
        if (this.tail != null) {
          this.tail.head = this; //enforce forward linking
        }
      return this;
  }


  public DoubleIntList push(DoubleIntList elem) {
    elem.tail = this;
    this.head = elem;
    return elem;
  }

 @Override public String toString() {
    StringBuffer string = new StringBuffer();
    string.append("( ");
    string.append(recursiveToString());
    string.append(" )");
    return string.toString();
}

  private String recursiveToString() {
    StringBuffer string = new StringBuffer();
    string.append(this.data);
    string.append(", ");
    if (this.tail != null) {
    string.append(this.tail.toString());
    } else {
      string.append("null");
    }
    return string.toString();
  }

private DoubleIntList head;
private int data;
private DoubleIntList tail;

}
