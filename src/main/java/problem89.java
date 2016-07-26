import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 The gray code is a binary numeral system where two successive values differ in only one bit.

 Given a non-negative integer n representing the total number of bits in the code,
 print the sequence of gray code. A gray code sequence must begin with 0.

 For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:

 00 - 0
 01 - 1
 11 - 3
 10 - 2
 Note:
 For a given n, a gray code sequence is not uniquely defined.

 For example, [0,2,3,1] is also a valid gray code sequence according to the above definition.

 For now, the judge is able to judge based on one instance of gray code sequence. Sorry about that.
 */
public class problem89 {
  public static void main(String[] args){
    int n = 2;
    List<Integer> result = new problem89().grayCode(n);
    for(int i : result){
      System.out.print(i + ",");
    }
    System.out.println();
  }
  public List<Integer> grayCode(int n) {
    List<Integer> result = new LinkedList<Integer>();
    if (n >= 0) {
      // 格雷码的前半部分
      result.add(0);
      // 格雷码最高位的值（非0时）
      int t = 1;
      // 每一次外循环求出的是位数i+1位的格雷码表，其相当于长度为i+1位的格雷码表的前半部分
      for (int i = 0; i < n; i++) {
        // 求出的长度为i+1位格雷码表的后半部分，前半部分由长度为i位的格雷码表给出
        for (int j = result.size() - 1; j >= 0; j--) {
          result.add(result.get(j) ^ t);
        }
        // 最高位右移
        t <<= 1;
      }
    }
    return result;
  }
}
