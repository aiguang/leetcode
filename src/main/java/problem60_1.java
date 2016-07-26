/**
 The set [1,2,3,…,n] contains a total of n! unique permutations.

 By listing and labeling all of the permutations in order,
 We get the following sequence (ie, for n = 3):

 "123"
 "132"
 "213"
 "231"
 "312"
 "321"
 Given n and k, return the kth permutation sequence.
 */
public class problem60_1 {
  public String getPermutation(int n, int k) {
    if(n < 0) return "";
    if(k <= 0) return "";

    int t = 1;
    int index = 1;
    while (k > t && index <= n){
      t *= index;
      index++;
    }
    if(index == n){
      return "";
    }
    StringBuffer result = new StringBuffer();
    for(;index >= 1;index--){
      result.append(index);
    }

    int[] nums = new int[9 - result.length()];
    for(;index < 9 - result.length();index++){

    }
    return "";
  }
}
