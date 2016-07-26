/**
 Given an integer, write a function to determine if it is a power of three.

 Follow up:
 Could you do it without using any loop / recursion?
 */
public class problem326 {
  public boolean isPowerOfThree(int n) {
    if (n == 1) return true;
    if(n < 3) return false;

    while (n > 0 && n != 1){
     int tmp = n % 3;
      if(tmp != 0) return false;
      n /= 3;
    }
    return true;
  }
}
