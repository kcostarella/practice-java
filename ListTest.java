import java.util.AbstractMap;
import java.util.HashMap;

public class ListTest {

  public ListTest() {
    single_map = new HashMap<String,IntList>();
    double_map = new HashMap<String, DoubleIntList>();
  }

  public void createSingle(String name, int data) {
    IntList l = new IntList(data, null);
    single_map.put(name,l);
    print_single(name);
  }

  public void createDouble(String name, int data) {
    DoubleIntList l = new DoubleIntList(null,data,null);
    double_map.put(name, l);
    print_double(name);
  }

  public void append(String name, String data) throws NumberFormatException {
    try {
      if (single_map.get(name) != null) {
        append(name, new IntList(Integer.parseInt(data),null));
      }
    } catch (NumberFormatException e) {
      append(name, single_map.get(data));
    }
    try {
      if (double_map.get(name) != null) {
       append(name, new DoubleIntList(null,Integer.parseInt(data),null));
      }
    } catch (NumberFormatException e) {
      append(name, double_map.get(data));
    }
  }

  public void push(String name, String data) {
    try {
      if (single_map.get(name) != null) {
        push(name, new IntList(Integer.parseInt(data),null));
      }
    } catch (NumberFormatException e) {
      push(name, single_map.get(data));
    }
    try {
      if (double_map.get(name) != null) {
       push(name, new DoubleIntList(null,Integer.parseInt(data),null));
      }
    } catch (NumberFormatException e) {
      push(name, double_map.get(data));
    }
  }

  private void append(String name, IntList l) {
    single_map.get(name).append(l);
    print_single(name);
  }

  private void append(String name, DoubleIntList l) {
    double_map.get(name).append(l);
    print_double(name);
  }

  private void push(String name, IntList l) {
    single_map.put(name,single_map.get(name).push(l));
    print_single(name);
  }

  private void push(String name, DoubleIntList l) {
    double_map.put(name, double_map.get(name).push(l));
    print_double(name);
  }

  public void delete(String name, int d) {
    if (single_map.get(name) != null) {
      single_map.put(name, single_map.get(name).delete(d));
      print_single(name);
    } else if (double_map.get(name) != null) {
      double_map.put(name, double_map.get(name).delete(d));
      print_double(name);
    }
  }

  public void print(String name) {
     if (single_map.get(name) != null) {
      print_single(name);
    } else if (double_map.get(name) != null) {
      print_double(name);
    }
  }

  private void print_single(String name) {
  System.out.println(name + ": " + single_map.get(name));
  }

  private void print_double(String name) {
    System.out.println(name + ": " + double_map.get(name));
  }


  private static AbstractMap<String,IntList> single_map;
  private static AbstractMap<String,DoubleIntList> double_map;

}
