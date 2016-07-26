/**
 * Created by Administrator on 16-2-18.
 */
public class problem45_1 {
  public static void main(String[] args){
    int[] array = {2,3,1,1,4};
    System.out.println(new problem45_1().jump(array));
  }
  public int jump(int[] nums){
    int start = 0;
    int end = 0;
    int count = 0;
    if(nums.length == 1) return 0;
    while (end < nums.length){
      int max = 0;
      for(int i = start; i <= end;i++){
        if(i + nums[i] >= nums.length - 1){
          return count + 1;
        }
        max = Math.max(max, i + nums[i]);
      }
      count++;
      start = end + 1;
      end = max;
    }
    return count;
  }
}
