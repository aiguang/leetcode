/**
 * Created by Administrator on 15-8-18.
 */
public class problem27 {
  public int removeElement(int[] nums, int val) {

    if(nums == null || nums.length ==0) return 0;
    int k = 0;
    for(int i = 0; i < nums.length ; i++){
      if(nums[i] == val){
        k++;
      }else{
        nums[i - k] = nums[i];
      }
    }
    return nums.length - k;
  }
}
