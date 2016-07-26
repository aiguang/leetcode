/**
 Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range, inclusive.

 For example, given the range [5, 7], you should return 4.

 相与后的结果为100，仔细观察我们可以得出，最后的数是该数字范围内所有的数的左边共同的部分，
 如果上面那个例子不太明显，我们再来看一个范围[26, 30]，它们的二进制如下：

 11010　　11011　　11100　　11101　　11110

 发现了规律后，我们只要写代码找到左边公共的部分即可，我们可以从建立一个32位都是1的mask，
 然后每次向左移一位，比较m和n是否相同，不同再继续左移一位，直至相同，然后把m和mask相与就是最终结果
 ，代码如下：
 */
public class problem201 {
  public static void  main(String[] args){
    int m = 5;
    int n = 7;
    System.out.println(new problem201().rangeBitwiseAnd(5,7));
  }
  public int rangeBitwiseAnd(int m, int n) {
    if(m == 0 || n == 0) return 0;
    if(m == n) return m;
    int i = 0;
    while (m != n){
      m >>= 1;
      n >>= 1;
      i++;
    }
    return m << i;
  }
}
