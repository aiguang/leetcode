/**
 Note: This is an extension of House Robber.

 After robbing those houses on that street, the thief has found himself a new place for his thievery
 so that he will not get too much attention. This time, all houses at this place are arranged in a circle.
 That means the first house is the neighbor of the last one. Meanwhile,
 the security system for these houses remain the same as for those in the previous street.

 Given a list of non-negative integers representing the amount of money of each house,
 determine the maximum amount of money you can rob tonight without alerting the police.
 */
public class problem213 {
  public static void  main(String[] args){
    int nums[] = {0,0};
    System.out.println(new problem213().rob(nums));
  }
  public int rob(int[] nums) {
    int n = nums.length;
    if(n==1) return nums[0];
    return Math.max(helper(nums, 0, n-1), helper(nums, 1, n));
  }

  private int helper(int nums[], int inclusive, int exclusive){
    if(inclusive>=exclusive) return 0;
    int first = 0, second = nums[inclusive];
    for(int i=inclusive+1; i<exclusive; i++){
      int temp = second;
      second = Math.max(first+nums[i], temp);
      first = temp;
    }
    return second;
  }
}
