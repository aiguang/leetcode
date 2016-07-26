import org.omg.DynamicAny._DynEnumStub;

/**
 Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.

 The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2.
 Please note that your returned answers (both index1 and index2) are not zero-based.

 You may assume that each input would have exactly one solution.

 Input: numbers={2, 7, 11, 15}, target=9
 Output: index1=1, index2=2
 */
public class problem167TwoSumIIInputarrayissorted {
  public static void main(String[] args){
    int[] numbers={12,13,23,28,43,44,59,60,61,68,70,86,88,92,124,125,136,168,173,173,180,199,212,221,227,230,277,282,306,314,316,321,325,328,336,337,363,365,368,370,370,371,375,384,387,394,400,404,414,422,422,427,430,435,457,493,506,527,531,538,541,546,568,583,585,587,650,652,677,691,730,737,740,751,755,764,778,783,785,789,794,803,809,815,847,858,863,863,874,887,896,916,920,926,927,930,933,957,981,997};
    int target = 542;
    int[] array = new problem167TwoSumIIInputarrayissorted().twoSum(numbers, target);
    if(array != null){
      System.out.println(array[0] + "  ——  " + array[1]);
    }
  }
  public int[] twoSum(int[] numbers, int target) {
    int left = 0;
    int right = numbers.length - 1;
    while (left < right){
      while (right >= 0 &&  numbers[left] + numbers[right] > target) right--;
      while (left < numbers.length && numbers[left] + numbers[right] < target) left++;
      if(right >= 0 && left < numbers.length && numbers[left] + numbers[right] == target){
        int[] result = new int[2];
        result[0] = Math.min(left + 1, right + 1);
        result[1] = Math.max(left + 1, right + 1);
        return result;
      }
    }
    return null;
  }
}
