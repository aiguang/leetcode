/**
 Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.

 For example,
 MovingAverage m = new MovingAverage(3);
 m.next(1) = 1
 m.next(10) = (1 + 10) / 2
 m.next(3) = (1 + 10 + 3) / 3
 m.next(5) = (10 + 3 + 5) / 3
 */
public class problem346MovingAveragefromDataStream {
  public static void main(String[] args){
    MovingAverage m = new MovingAverage(3);
    System.out.println(m.next(1));
    System.out.println(m.next(10));
    System.out.println(m.next(3));
    System.out.println(m.next(5));
  }
}
class MovingAverage {

  int curSize = 0;
  int[] nums = null;
  /** Initialize your data structure here. */
  public MovingAverage(int size) {
    nums = new int[size];
  }

  public double next(int val) {
    curSize++;
    nums[curSize % nums.length] = val;
    if(curSize <= nums.length){
      int total = 0;
      for(Integer value : nums){
        total += value;
      }
      return (double)total/curSize;
    }else{
      int total = 0;
      for(Integer value : nums){
        total += value;
      }
      return (double)total/nums.length;
    }
  }
}
