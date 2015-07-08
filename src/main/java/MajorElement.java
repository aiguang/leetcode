import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 15-7-4.
 */
public class MajorElement {
    public  static void main(String[] args){

    }
    public void test(){
        int[] nums = {1, 2};
        List<Integer> res = majorityElement(nums);
        for(int i : res){
            System.out.println(i);
        }
    }
    public List<Integer> majorityElement(int[] nums) {
        if(nums == null){
            return new ArrayList<Integer>();
        }
        int element1 = 0,element2 = 0;
        int count1 = 0, count2 = 0;
        for(int i : nums){
            if(count1 == 0){
                element1 = i;
                count1++;
            }else if(element1 == i){
                count1++;
            }else if(count2 == 0){
                element2 = i;
                count2++;
            }else if(element2 == i){
                count2++;
            }else{
                count1--;
                count2--;
            }
        }
        count1 = count2 = 0;
        for(int i : nums){
            if(i == element1)count1++;
            else if(i == element2) count2++;
        }
        List<Integer> result = new ArrayList<Integer>();
        if(count1 > nums.length / 3) result.add(element1);
        if(count2 > nums.length / 3) result.add(element2);
        return result;
    }
}
