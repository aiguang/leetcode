/**
 * Created by Administrator on 16-7-2.
 */
public class problem367ValidPerfectSquare {
  public static  void main(String[] args){
    System.out.println(new problem367ValidPerfectSquare().isPerfectSquare(808201));
  }
  public boolean isPerfectSquare(int num) {
    if(num < 0) return false;
    if(num <= 1) return  true;
    int left = 1; int right = num - 1;
    while (left <= right){
      int mid = left + (right - left) / 2;
      if((long)mid * mid == num) return true;
      else if((long)(mid - 1) * (mid - 1) >= num){
        right = mid - 1;
      }else {
        left = mid + 1;
      }
    }
    return false;
  }
}
