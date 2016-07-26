import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a string of numbers and operators, return all possible results from computing all the
 * different possible ways to group numbers and operators. The valid operators are +, - and *.
 *
 *
 * Example 1 Input: "2-1-1".
 *
 * ((2-1)-1) = 0 (2-(1-1)) = 2 Output: [0, 2]
 *
 *
 * Example 2 Input: "2*3-4*5"
 *
 * (2*(3-(4*5))) = -34 ((2*3)-(4*5)) = -14 ((2*(3-4))*5) = -10 (2*((3-4)*5)) = -10 (((2*3)-4)*5) =
 * 10 Output: [-34, -14, -10, -10, 10]
 */
public class problem241 {

  public List<Integer> diffWaysToCompute(String input) {
    List<Character> operations = new ArrayList<Character>();
    List<Integer> nums = new ArrayList<Integer>();
    int number = 0;
    for (int i = 0, L = input.length(); i < L; i++) {
      char ch = input.charAt(i);
      if (!(ch - '0' <= 9 && ch - '0' >= 0)) {
        nums.add(number);
        operations.add(ch);
        number = 0;
      } else {
        number = number * 10 + (ch - '0');
      }
    }
    nums.add(number);
    HashMap<int[], List<Integer>> map = new HashMap<int[], List<Integer>>();
    return diffWaysToCompute(map, nums, operations, 0, nums.size() - 1);
  }

  private List<Integer> diffWaysToCompute(HashMap<int[], List<Integer>> map, List<Integer> nums,
                                          List<Character> operations, int start, int end) {
    //if(map.containsKey(new int[]{start, end})) return map.get(new int[]{start, end});
    List<Integer> list = new LinkedList<Integer>();
    if (start == end) {
      list.add(nums.get(start));
      return list;
    }
    for (int i = start; i < end; i++) {
      List<Integer> leftRes = diffWaysToCompute(map, nums, operations, start, i);
      List<Integer> rightRes = diffWaysToCompute(map, nums, operations, i + 1, end);
      for (int left : leftRes) {
        for (int right : rightRes) {
          switch (operations.get(i)) {
            case '+':
              list.add(left + right);
              break;
            case '-':
              list.add(left - right);
              break;
            case '*':
              list.add(left * right);
              break;
          }
        }
      }
    }
    //map.put(new int[]{start, end}, list);
    return list;
  }
}
