import java.util.Arrays;

/**
 * Created by Administrator on 16-4-27.
 */
public class findKthElementInTwoSortedArray {
  public static void main(String[] args){

    int[] a = {5,4,3,2,1};
    int[] b = {10,9,8,7,6};
    System.out.println(new findKthElementInTwoSortedArray().findKth(a, b, 3));
  }
  public int findKth(int[] a, int[] b,int k){
    int i = (int)((double)(a.length/(a.length + b.length) * (k - 1)));
    int j = k - 1- i;

    int Ai_1 = ((i == 0) ? Integer.MIN_VALUE : a[i-1]);
    int Bj_1 = ((j == 0) ? Integer.MIN_VALUE : b[j-1]);
    int Ai   = ((i >= a.length) ? Integer.MAX_VALUE : a[i]);
    int Bj   = ((j >= b.length) ? Integer.MAX_VALUE : b[j]);

    if (Bj_1 < Ai && Ai < Bj)
      return Ai;
    else if (Ai_1 < Bj && Bj < Ai)
      return Bj;

    // if none of the cases above, then it is either:
    if (Ai < Bj)
      // exclude Ai and below portion
      // exclude Bj and above portion
      return findKth(Arrays.copyOfRange(a, i+1, a.length), b, k-i-1);
    else /* Bj < Ai */
      // exclude Ai and above portion
      // exclude Bj and below portion
      return findKth(a, Arrays.copyOfRange(b, j + 1, b.length), k - j - 1);
  }

}
