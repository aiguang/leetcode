import java.util.HashSet;
import java.util.Set;

/**
 * Created by Administrator on 15-6-24.
 * Given an array of integers, find if the array contains any duplicates.
 * Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.
 */
public class ContainsDuplicate {
    public static void main(String[] args){

    }

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for(Integer number : nums){
            if(set.contains(number)){
                return true;
            }
            set.add(number);
        }
        return false;
    }
}
