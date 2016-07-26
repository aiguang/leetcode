import java.util.ArrayList;
import java.util.List;

/**
 Given a non-negative integer n, count all numbers with unique digits, x, where 0 ≤ x < 10n.

 Example:
 Given n = 2, return 91. (The answer should be the total numbers in the range of 0 ≤ x < 100, excluding [11,22,33,44,55,66,77,88,99])

 Hint:

 A direct way is to use the backtracking approach.
 Backtracking should contains three states which are (the current number, number of steps to get that number and a bitmask
 which represent which number is marked as visited so far in the current number). Start with state (0,0,0) and
 count all valid number till we reach number of steps equals to 10n.
 This problem can also be solved using a dynamic programming approach and some knowledge of combinatorics.
 Let f(k) = count of numbers with unique digits with length equals k.
 f(1) = 10, ..., f(k) = 9 * 9 * 8 * ... (9 - k + 2) [The first factor is 9 because a number cannot start with 0].
 */
public class problem357CountNumberswithUniqueDigits {
  public static void main(String[] args){
    int n = 8;
    long start = System.currentTimeMillis();
    System.out.println(new problem357CountNumberswithUniqueDigits().countNumbersWithUniqueDigits1(n) + ", cost time: " + (System.currentTimeMillis() - start));

    start = System.currentTimeMillis();
    System.out.println(new problem357CountNumberswithUniqueDigits().countNumbersWithUniqueDigits(n) + ", cost time: " + (System.currentTimeMillis() - start));

    start = System.currentTimeMillis();
    System.out.println(new problem357CountNumberswithUniqueDigits().countNumbersWithUniqueDigits2(n) + ", cost time: " + (System.currentTimeMillis() - start));
  }
  public static int countNumbersWithUniqueDigits2(int n) {
    if (n > 10) {
      return countNumbersWithUniqueDigits2(10);
    }
    int count = 1; // x == 0
    long max = (long) Math.pow(10, n);

    boolean[] used = new boolean[10];

    for (int i = 1; i < 10; i++) {
      used[i] = true;
      count += search(i, max, used);
      used[i] = false;
    }

    return count;
  }

  private static int search(long prev, long max, boolean[] used) {
    int count = 0;
    if (prev < max) {
      count += 1;
    } else {
      return count;
    }

    for (int i = 0; i < 10; i++) {
      if (!used[i]) {
        used[i] = true;
        long cur = 10 * prev + i;
        count += search(cur, max, used);
        used[i] = false;
      }
    }

    return count;
  }
  public int countNumbersWithUniqueDigits1(int n){
    if(n < 0) return 0;
    if(n == 0) return 1;
    int[] dp = new int[n];
    dp[0] = 9;
    int result = 1;
    for(int i = 1; i < n;i++){
      dp[i] = dp[i - 1] * (9 - i + 1);
      result += dp[i];
    }
    return result + dp[0];
  }
  public int countNumbersWithUniqueDigits(int n) {
    if(n < 0) return 0;
    List<Integer> result = new ArrayList<Integer>();
    helper(0, result, n);
    return result.size();
  }
  private void helper(int cur,  List<Integer> result, int n){
    if(cur >= Math.pow(10, n)){
      return;
    }
    result.add(cur);
    for(int i = 0; i <= 9;i++){
      if(!String.valueOf(cur).contains(i + "")){
        cur = cur * 10 + i;
        helper(cur, result, n);
        cur = (cur - i) / 10;
      }
    }
  }
}
