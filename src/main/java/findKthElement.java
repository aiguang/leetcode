/**
 * Created by Administrator on 16-4-26.
 */
public class findKthElement {

  //return the value of kth element in union of two sorted array
  int findKthElement(int A[], int m, int B[], int n, int k) {
//    int i = (int)((double)(m)/(m+n)*(k -1));
//    int j = (k-1) - i;
//
//    //A[i] or B[j] is the Kth element, return it
//    if ((j <= 0 || B[j-1] < A[i]) && (j >= n || A[i] < B[j]))
//      return A[i];
//    if ((i <= 0 || A[i-1] < B[j]) && (i >= m || B[j] < A[i]))
//      return B[j];
//
//    //A[i] is too small, get rid of lower part of A and higher part of B
//    if (0 < j && A[i] < B[j-1])
//      return findKthElement(A+i+1, m-i-1, B, j, k-i-1);
//
//      //B[j] is too small, get rid of higher part of A and lower part of B
//    else //if(i > 0 && B[j] < A[i-1])
//      return findKthElement(A, i, B+j+1, n-j-1, k-j-1);
    return 0;
  }
  public static void main(String[] args){
    int[] array = {4,5,6,7,8,1,2,3};
    System.out.print(new findKthElement().findMin(array));
  }
  public int findMin(int[] array){
    int low = 0; int high = array.length - 1;
    while (low < high){
      int mid = (low + high) / 2;
      if(array[mid] > array[high]) {
        low = mid + 1;
      }else{
        high = mid;
      }
    }
    return low;
  }
}
