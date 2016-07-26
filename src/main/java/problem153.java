/**
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 *
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 *
 * Find the minimum element.
 *
 * You may assume no duplicate exists in the array.
 */
public class problem153 {
  public static void  main(String[] args){
    int[] nums = {1,1,2,0,0,1};
    System.out.println(new problem154().findMin(nums));
  }
  public int findMin(int[] num) {
    if (num == null || num.length == 0) {
      return 0;
    }
    int l = 0;
    int r = num.length - 1;
    int min = num[0];
    while (l < r - 1) {
      int m = (l + r) / 2;
      if (num[l] < num[m]) {
        min = Math.min(num[l], min);
        l = m + 1;
      } else if (num[l] > num[m]) {
        min = Math.min(num[m], min);
        r = m - 1;
      } else {
        l++;
      }
    }
    min = Math.min(num[r], min);
    min = Math.min(num[l], min);
    return min;
  }
}
