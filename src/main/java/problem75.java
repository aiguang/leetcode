/**
 * Created by Administrator on 15-9-7.
 */
public class problem75 {
  public static void main(String[] args){
    int[] nums = {1,0,0,1,0,2,1};
    new problem75().sortColors(nums);
    for(int i = 0; i < nums.length;i++){
      System.out.print(nums[i] + ",");
    }
    System.out.println();
  }
  public void sortColors(int[] nums) {
    if(nums == null || nums.length == 0 || nums.length == 1) return;
    int zeroNum = 0;
    int oneNum = 0;
    for(int i = 0; i < nums.length;i++){
      if(nums[i] == 0){
        swap(nums, i, zeroNum);
        swap(nums, i, zeroNum + oneNum);
        zeroNum++;
      }else if(nums[i] == 1){
        swap(nums, i, zeroNum + oneNum);
        oneNum++;
      }
    }
  }
  private void swap(int[] nums, int i, int j){
    int tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
  }
}
