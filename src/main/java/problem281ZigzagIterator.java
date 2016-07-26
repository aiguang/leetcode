import java.util.ArrayList;
import java.util.List;

/**
 Given two 1d vectors, implement an iterator to return their elements alternately.

 For example, given two 1d vectors:

 v1 = [1, 2]
 v2 = [3, 4, 5, 6]
 By calling next repeatedly until hasNext returns false,
 the order of elements returned by next should be: [1, 3, 2, 4, 5, 6].

 Follow up: What if you are given k 1d vectors? How well can your code be extended to such cases?

 Clarification for the follow up question - Update (2015-09-18):
 The "Zigzag" order is not clearly defined and is ambiguous for k > 2 cases.
 If "Zigzag" does not look right to you, replace "Zigzag" with "Cyclic". For example, given the following input:

 [1,2,3]
 [4,5,6,7]
 [8,9]
 It should return [1,4,8,2,5,9,3,6,7].
 */
public class problem281ZigzagIterator {
  public static void main(String[] args){
    List<Integer> list1 = new ArrayList<Integer>();
    list1.add(1);
    list1.add(2);
    list1.add(3);

    List<Integer> list2 = new ArrayList<Integer>();
    list2.add(4);
    list2.add(5);
    list2.add(6);
    list2.add(7);

    ZigzagIterator iter = new ZigzagIterator(list1, list2);
    while(iter.hasNext()){
      System.out.print(iter.next() + ",");
    }
  }
}

class ZigzagIterator {

  List<Integer> list = new ArrayList<Integer>();
  int index1 = 0;
  int index2 = 0;
  int length1 = 0;
  public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
    list.addAll(v1);
    list.addAll(v2);
    index1 = 0;
    index2 = 0;
    length1 = v1.size();
  }

  public int next() {
    if(!hasNext()) return 0;
    int result = 0;
    if(index1 <= index2){
      if(index1 < length1){
        result = list.get(index1);
        index1++;
      }else {
        result = list.get(index2 + length1);
        index2++;
      }
    }else{
      if(index2 + length1 < list.size()){
        result = list.get(index2 + length1);
        index2++;
      }else{
        result = list.get(index1);
        index1++;
      }
    }
    return result;
  }

  public boolean hasNext() {
    return index1 + index2  <= list.size() - 1;
  }
}
