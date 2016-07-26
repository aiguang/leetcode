/**
 Your task is to calculate ab mod 1337 where a is a positive integer and b is an extremely large positive integer given in the form of an array.

 Example1:

 a = 2
 b = [3]

 Result: 8
 Example2:

 a = 2
 b = [1,0]

 Result: 1024
 */
public class problem372SuperPow {
  public int superPow(int a, int[] b) {
    if(a < 0 || (b == null || b.length == 0)) return 0;
    if(a == 1) return 1;
    return 0;
  }
}
