import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.text.html.HTMLDocument;

/**
 Implement an iterator to flatten a 2d vector.

 For example,
 Given 2d vector =

 [
 [1,2],
 [3],
 [4,5,6]
 ]
 By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,2,3,4,5,6].

 Hint:

 How many variables do you need to keep track?
 Two variables is all you need. Try with x and y.
 Beware of empty rows. It could be the first few rows.
 */
public class problem251Flatten2DVector {
  public static void main(String[] args){
    List<List<Integer>> list = new ArrayList<List<Integer>>();
    List<Integer> a = new ArrayList<Integer>();
    a.add(1);
    a.add(2);

    List<Integer> b = new ArrayList<Integer>();
    b.add(3);

    List<Integer> c = new ArrayList<Integer>();
    c.add(4);
    c.add(5);
    c.add(6);

    list.add(a);
    list.add(b);
    list.add(c);
    myVector2D v = new myVector2D(list);
    while (v.hasNext()){
      System.out.print(v.next() + ",");
    }
  }
}
class myVector2D implements Iterator<Integer> {
  List<Iterator<Integer>> iterList = new ArrayList<Iterator<Integer>>();
  int index = -1;
  public myVector2D(List<List<Integer>> vec2d) {
    if(vec2d == null || vec2d.size() == 0) return;
    for(List<Integer> list : vec2d){
      iterList.add(list.iterator());
    }
  }

  @Override
  public Integer next() {
    if(index == -1 && iterList.size() == 0){
      return null;
    }
    if(index == -1) index = 0;
    while (true){
      Iterator<Integer> cur = iterList.get(index);
      if(cur.hasNext()){
        return cur.next();
      }else{
        if(index != iterList.size() - 1){
          index++;
        }else {
          break;
        }
      }
    }
    return null;
  }

  @Override
  public void remove() {

  }

  @Override
  public boolean hasNext() {
    if(index == -1 && iterList.size() == 0){
      return false;
    }
    if(index == -1) index = 0;
    while (true){
      Iterator<Integer> cur = iterList.get(index);
      if(cur.hasNext()){
        return true;
      }else{
        if(index != iterList.size() - 1){
          index++;
        }else {
          return false;
        }
      }
    }
  }
}
