package cci.pra5;

/**
 译文：

 给定两个32位的数，N和M，还有两个指示位的数，i和j。
 写程序使得N中第i位到第j位的值与M中的相同(即：M变成N的子串且位于N的第i位和第j位之间)

 例子：

 输入: N = 10000000000, M = 10101, i = 2, j = 6

 输出: N = 10001010100
 */
public class pra5_1 {
  public static void main(String[] args){
    int i = 2, j = 6, n=1024,m=21;
    new pra5_1().create(n,m,i,j);
  }
  public void create(int N, int M, int i, int j){
    int k = (int)Math.pow(2, i)- 1;
    int ret = N & k;
    int result = (N >> (j +1)) << (j+1) | (M << i) | ret;
    System.out.println(result);
  }
}
