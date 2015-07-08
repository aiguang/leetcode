import java.util.ArrayList;
import java.util.List;

/**
 * Given a sorted integer array without duplicates, return the summary of its ranges.
 * For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].
 * Credits:
 * Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.
 */
public class SummaryRanges {
    public static void main(String[] args){
        SummaryRanges summaryRanges = new SummaryRanges();
        int[] array = {1,3};
        List<String> result = summaryRanges.summaryRanges(array);
        for(String string : result){
            System.out.println(string);
        }
    }

    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<String>();
        if(nums == null || nums.length == 0){
            return result;
        }
        if(nums.length == 1){
            result.add(String.valueOf(nums[0]));
            return result;
        }
        int startIndex = 0;
        int length = nums.length;
        for(int i = 1 ; i < length  ; i++){
            if(nums[i] - nums[i - 1] == 1){
                if(i == length - 1){
                    String tmp = nums[startIndex] + "->" + nums[i];
                    result.add(tmp);
                }
            }else{
                if(i - 1 != startIndex){
                    String tmp = nums[startIndex] + "->" + nums[i - 1];
                    result.add(tmp);
                }else{
                    result.add(String.valueOf(nums[startIndex]));
                }
                startIndex = i;
                if(startIndex == length - 1){
                    result.add(String.valueOf(nums[startIndex]));
                }
            }
        }
        return result;
    }
}
