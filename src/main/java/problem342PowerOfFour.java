/**
 * Created by Administrator on 16-5-18.
 */
public class problem342PowerOfFour {
  public static void main(String[] args){
    int num = 16;
    System.out.println(new problem342PowerOfFour().isPowerOfFour(16));
  }
  public boolean isPowerOfFour(int num) {
    if(num <= 0) return false;
    if((num & (num - 1)) != 0) return false;
    return (num & 0x55555555) > 0;
  }
}
