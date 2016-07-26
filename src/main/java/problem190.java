/**
 Reverse bits of a given 32 bits unsigned integer.

 For example, given input 43261596 (represented in binary as 00000010100101000001111010011100),
 return 964176192 (represented in binary as 00111001011110000010100101000000).

 Follow up:
 If this function is called many times, how would you optimize it?

 Related problem: Reverse Integer
 */
public class problem190 {
  public static void main(String[] args){
    int n = 4;
    System.out.println(new problem190().reverseBits(n));
  }

  public int reverseBits(int n) {
    int reversed = 0;
    int[] bit = new int[32];
    for (int i = 0; i < 32; i++) {
      bit[i] = n & 1;
      n = n >> 1;
      reversed = reversed << 1;
      reversed = reversed | bit[i];
   }
    return reversed;
  }
}
