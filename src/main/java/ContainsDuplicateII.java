import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 15-6-25.
 */
public class ContainsDuplicateII {
    public static void main(String[] args){
        ContainsDuplicateII temp = new ContainsDuplicateII();
        int[] array = {1,2 ,1};
        System.out .println(temp.containsNearbyDuplicate(array, 2));
    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(k <= 0 || nums == null || nums.length < 2){
            return false;
        }
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++){
            Integer index = map.get(nums[i]);
            if(index == null){
                map.put(nums[i], i);
                continue;
            }
            if(index != null){
                if(i - index <= k){
                    return true;
                }else{
                    map.put(nums[i], i);
                }

            }
        }
        return false;
    }
}
