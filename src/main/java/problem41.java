/**
 * Created by Administrator on 16-2-16.
 */
public class problem41 {
  public int firstMissingPositive(int[] A) {
    for(int i = 0; i < A.length;i++){
      if(i != A[i] - 1){
        if(A[i] <= 0 || A[i] >= A.length || A[i] == A[A[i] - 1])
          continue;
        swap(A, i, A[i] - 1);
        i--;
      }
    }
    for (int i = 0; i < A.length; i++) {
      if (i != A[i] - 1)
        return i + 1;
    }
    return A.length + 1;
  }
  private void swap(int[] nums, int i, int j){
    int tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
  }
}
