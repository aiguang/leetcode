import java.util.Arrays;
import java.util.Comparator;

/**
 Given a list of non negative integers, arrange them such that they form the largest number.

 For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.

 Note: The result may be very large, so you need to return a string instead of an integer.
 */
public class problem179 {
  public static void main(String[] args){
    int[] i = {0,0,0};
    System.out.println(new problem179().largestNumber(i));
  }
  public String largestNumber(int[] nums) {
    Integer[] tmp = new Integer[nums.length];
    for(int i = 0; i < nums.length; i++){
      tmp[i] = nums[i];
    }
    Comparator<Integer> comparator = new Comparator<Integer>() {
      @Override
      public int compare(Integer o1, Integer o2) {
        String value1 = o1 + "" + o2;
        String value2 = o2 + "" + o1;
        long l1 = Long.parseLong(value1);
        long l2 = Long.parseLong(value2);

        return l1 > l2 ? -1 : (l1 < l2 ? 1 : 0);
      }
    };
    Arrays.sort(tmp, comparator);
    StringBuffer sb = new StringBuffer();
    if(tmp[0] == 0) return "0";
    for(int i : tmp){
      sb.append(i);
    }
    return sb.toString();
  }
}
