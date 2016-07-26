import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

 push(x) -- Push element x onto stack.
 pop() -- Removes the element on top of the stack.
 top() -- Get the top element.
 getMin() -- Retrieve the minimum element in the stack.
 */
public class problem155 {
  public static void main(String[] args){
    problem155 test = new problem155();
    test.push(2);
    test.push(0);
    test.push(3);
    test.push(0);
    System.out.println(test.getMin() + ",");
    test.pop();
    System.out.println(test.getMin() + ",");
    test.pop();
    System.out.println(test.getMin() + ",");
    test.pop();
    System.out.println(test.getMin() + ",");

//    push(2),push(0),push(3),push(0),getMin,pop,getMin,pop,getMin,pop,getMin
//    System.out.println(test.getMin());
  }
  private List<Integer> list = new ArrayList<Integer>();
  private TreeMap<Integer, Integer> treeMap = new TreeMap<Integer,Integer>();

  public void push(int x) {
    list.add(x);
    treeMap.put(x, treeMap.get(x) == null ? 1 : treeMap.get(x) + 1);
  }

  public void pop() {
    if(list.size() > 0){
      int value = list.remove(list.size() - 1);
      int count = treeMap.get(value);
      if(count > 1){
        treeMap.put(value, count - 1);
      }else {
        treeMap.remove(value);
      }
    }
  }

  public int top() {
    return list.size() > 0 ? list.get(list.size() - 1) : 0;
  }

  public int getMin() {
    return list.size() > 0 ? treeMap.firstKey() : Integer.MIN_VALUE;
  }
}
