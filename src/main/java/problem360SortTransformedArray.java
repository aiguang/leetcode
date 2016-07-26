import java.util.ArrayList;
import java.util.List;

/**
 Given a sorted array of integers nums and integer values a, b and c.
 Apply a function of the form f(x) = ax2 + bx + c to each element x in the array.

 The returned array must be in sorted order.

 Expected time complexity: O(n)

 Example:
 nums = [-4, -2, 2, 4], a = 1, b = 3, c = 5,

 Result: [3, 9, 15, 33]

 nums = [-4, -2, 2, 4], a = -1, b = 3, c = 5

 Result: [-23, -5, 1, 7]
 */
public class problem360SortTransformedArray {
  public static void main(String[] args){
    int[] nums = {-4, -2, 2, 4};
    int a = -1;
    int b = 3;
    int c = 5;
    int[] r = new problem360SortTransformedArray().sortTransformedArray(nums, a , b, c);
    for(int k : r){
      System.out.println(k);
    }
  }
  public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
    int max = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;
    for(int i = 0;i < nums.length;i++){
      int cur = a * (nums[i] * nums[i]) + b * nums[i] + c;
      max = Math.max(max, cur);
      min = Math.min(min, cur);
    }
    int[] r = new int[max + 1 - min];
    for(int i = 0; i < nums.length;i++){
      int cur = a * (nums[i] * nums[i]) + b * nums[i] + c;
      r[cur - min]++;
    }
    List<Integer> result = new ArrayList<Integer>();
    for(int i = 0; i < r.length;i++){
      while (r[i] > 0){
        result.add(i + min);
        r[i]--;
      }
    }
    r = new int[result.size()];
    for(int i = 0; i < result.size();i++){
      r[i] = result.get(i);
    }
    return r;
  }
}
