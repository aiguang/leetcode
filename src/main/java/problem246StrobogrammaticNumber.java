import java.util.HashMap;
import java.util.Map;

/**
 A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).

 Write a function to determine if a number is strobogrammatic. The number is represented as a string.

 For example, the numbers "69", "88", and "818" are all strobogrammatic.

 */
public class problem246StrobogrammaticNumber {
  public static void main(String[] args){
    System.out.println(new problem246StrobogrammaticNumber().isStrobogrammatic("2"));
  }
  public boolean isStrobogrammatic(String num) {
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    map.put(6,9);
    map.put(8,8);
    map.put(0,0);
    map.put(9,6);
    map.put(1,1);
    int left = 0;
    int right = num.length() - 1;
    while (left <= right){
      int l = num.charAt(left) - '0';
      int r = num.charAt(right) - '0';
      if(map.containsKey(l) && map.get(l) == r){
        left++;
        right--;
      }else return false;
    }
    return true;
  }
}
