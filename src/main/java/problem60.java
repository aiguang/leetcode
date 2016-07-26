import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Administrator on 15-9-1.
 *
 * The set [1,2,3,…,n] contains a total of n! unique permutations.

 By listing and labeling all of the permutations in order,
 We get the following sequence (ie, for n = 3):

 "123"
 "132"
 "213"
 "231"
 "312"
 "321"
 Given n and k, return the kth permutation sequence.

 Note: Given n will be between 1 and 9 inclusive.
 */
public class problem60 {
  public static void  main(String[] args){
    int n = 4;
    int k = 20;
    System.out.println(new problem60().getPermutation(n, k));
  }

  public String getPermutation(int n, int k) {
    if(n < 1 || n > 9) return "";
    int[] nums = new int[n];
    int m = 1;
//    int index = 1;
//    while(m < k){
//      m = m * (m + 1);
//      index++;
//    }


    for(int i = 0; i < nums.length;i++){
      nums[i] = i+ 1;
    }
    List<String> result = new ArrayList<String>();
    calculate(nums, 0, result, k);
    Collections.sort(result);

    return result.get(k - 1);
  }
  private void calculate(int[] nums, int start, List<String> result, int target){
    if(start == nums.length - 1){
      StringBuilder sb = new StringBuilder();
      for(int i = 0; i < nums.length  ;i++){
        sb.append(nums[i]);
      }
      result.add(sb.toString());
      return;
    }
    for(int i = start; i < nums.length ;i++){
      swap(nums, start, i);
      calculate(nums, start + 1, result, target);
      swap(nums, start, i);
      if(result.size()== target){
        return;
      }
    }
  }
  private void swap(int[] nums, int i, int j){
    int tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
  }


}
