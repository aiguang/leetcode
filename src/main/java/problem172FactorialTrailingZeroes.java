/**
 * Created by Administrator on 16-6-23.
 */
public class problem172FactorialTrailingZeroes {
  public int trailingZeroes(int n) {
    if(n <= 0) return 0;
    int result = 0;
    while(n > 0){
      result += n / 5;
      n /= 5;
    }
    return result;
  }
}
