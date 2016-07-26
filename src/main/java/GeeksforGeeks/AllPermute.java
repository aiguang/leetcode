package GeeksforGeeks;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 16-3-28.
 */
public class AllPermute {
  public static void main(String[] args){
    int[] array = {1,2,3,4};
    List<Integer> result = new AllPermute().allPermute(array);
    for(int i : result){
      System.out.println(i);
    }
    System.out.println("total length is " + result.size());
  }
  public List<Integer> allPermute(int[] arrays){
    if(arrays == null || arrays.length == 0) return new ArrayList<Integer>();
    List<Integer> list = new ArrayList<Integer>();
    helper(arrays, 0, list);
    return list;
  }
  private void helper(int[] array, int curIndex, List<Integer> result){
    if(curIndex == array.length - 1){
      int current = array[0];
      for(int i = 1; i < array.length;i++){
        current = current * 10 + array[i];
      }
      result.add(current);
    }else {
      for(int i = curIndex;i < array.length;i++){
        swap(array,curIndex, i);
        helper(array, curIndex + 1, result);
        swap(array, i, curIndex);
      }
    }
  }
  private void swap(int[] arrays, int i, int j){
    int tmp = arrays[i];
    arrays[i] = arrays[j];
    arrays[j] = tmp;
  }
}
