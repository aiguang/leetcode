import org.omg.PortableInterceptor.INACTIVE;

import sun.management.resources.agent_de;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

 For example, given the following triangle
 [
    [2],
   [3,4],
  [6,5,7],
 [4,1,8,3]
 ]
 The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

 Note:
 Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.

 [            [-7],
             [-2,1],
           [-5,-5,9],
          [-4,-5,4,4],
        [-6,-6,2,-1,-5],
        [3,7,8,-3,7,-9],
       [-9,-1,-9,6,9,0,7],
      [-7,0,-6,-8,7,1,-4,9],
     [-3,2,-6,-9,-7,-6,-9,4,0],
    [-8,-6,-3,-9,-2,-6,7,-5,0,7],
   [-9,-1,-2,4,-2,4,4,-1,2,-5,5],
  [1,1,-6,1,-2,-4,4,-2,6,-6,0,6],
 [-3,-3,-6,-2,-6,-2,7,-9,-5,-7,-5,5,1]
 ]
 */
public class problem120 {
  public static void main(String[] args){
    List<List<Integer>> triangle = new ArrayList<List<Integer>>();
    List<Integer> list = new ArrayList<Integer>();
    list.add(2);
    triangle.add(list);
    list = new ArrayList<Integer>();
    list.add(3);
    list.add(4);
    triangle.add(list);
    list = new ArrayList<Integer>();
    list.add(6);
    list.add(5);
    list.add(7);
    triangle.add(list);
    list = new ArrayList<Integer>();
    list.add(4);
    list.add(1);
    list.add(8);
    list.add(3);
    triangle.add(list);
    System.out.println(new problem120().minimumTotal(triangle));
  }
  public int minimumTotal(List<List<Integer>> triangle) {
    if(triangle == null || triangle.size() == 0) return 0;
    if(triangle.size() == 1) return triangle.get(0).get(0);
    int row = 0;
    List<List<Integer>> list = new ArrayList<List<Integer>>();
    List<Integer> tmp = new ArrayList<Integer>();
    tmp.add(triangle.get(0).get(0));
    list.add(tmp);
    for(int i = 1; i < triangle.size();i++){
      List<Integer> t = triangle.get(i);
      List<Integer> insert = new ArrayList<Integer>();
      List<Integer> before = list.get(i - 1);
      for(int j = 0;j < t.size();j++){
        int first = j - 1 < 0 ? before.get(0) : before.get(j - 1);
        int second = j >= before.size() ? before.get(before.size() - 1) : before.get(j);
        int curValue = Math.min(first + t.get(j), second + t.get(j));
        insert.add(curValue);
      }
      list.add(insert);
    }
    tmp = list.get(list.size() - 1);
    int min = tmp.get(0);
    for(int i = 1; i < tmp.size();i++){
      min = Math.min(min, tmp.get(i));
    }
    return min;
  }
  public void helper(List<Integer> result, int curRow, int curValue, List<List<Integer>> source,
                     int curIndex){
    if(curRow == source.size() - 1){
      List<Integer> list = source.get(curRow);

      int first = curValue + (curIndex >= 0 ? list.get(curIndex) :
                              list.get(0));
      int second = curValue + (curIndex + 1 < list.size() ?
                               list.get(curIndex + 1) : list.get(list.size() - 1));
      if(result.isEmpty()){
        result.add(Math.min(first, second));
      }else {
        result.add(Math.min(result.get(0), Math.min(first, second)));
      }
      return;
    }
    List<Integer> list = source.get(curRow);
    helper(result, curRow + 1, curValue + (curIndex >=  0 ? list.get(curIndex) : list.get(0))
        , source, curIndex  >= 0 ? curIndex : 0);
    helper(result, curRow + 1, curValue + (curIndex + 1 >= list.size() ? list.get(list.size() - 1) :
    list.get(curIndex + 1)) , source, curIndex  + 1 >= list.size() ? list.size() - 1 :  curIndex + 1);
  }
}
