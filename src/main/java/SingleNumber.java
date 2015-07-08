/**
 * Created by Administrator on 15-6-28.
 * Given an array of integers, every element appears twice except for one. Find that single one.
 */
public class SingleNumber {
    public static void main(String[] args){
        System.out.println(4^0);

    }
    public int singleNumber(int[] nums) {
        if(nums == null || nums.length  == 0) return 0;
        int result = 0;
        for(int i = 0 ; i < nums.length; i++){
            result = result ^ nums[i];
        }
        return result;
    }
}
