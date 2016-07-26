/**
 * Created by Administrator on 15-8-10.
 *
 *
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the
 * sorted order, not the kth distinct element.
 *
 * For example, Given [3,2,1,5,6,4] and k = 2, return 5.
 *
 * Note: You may assume k is always valid, 1 ≤ k ≤ array's length.
 *
 * [3,2,3,1,2,4,5,5,6], 4
 */
public class p215 {

  public static void main(String[] args) {
    int[] x = {3, 2, 3, 1, 2, 4, 5, 5, 6};
    int k = 2;
    System.out.println(new p215().findKthLargest(x, k));
  }

  public int findKthLargest(int[] nums, int k) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    heapSort(nums);
    return nums[nums.length - k];
  }

  private void heapSort(int[] nums) {
    for (int i = nums.length / 2; i >= 0; i--) {
      heapSort(nums, i, nums.length);
    }
    for (int i = nums.length - 1; i >= 0; i--) {
      swap(nums, 0, i);
      heapSort(nums, 0, i);
    }
  }

  private void heapSort(int[] nums, int i, int n) {
    int child = 0;
    int parent = nums[i];
    for (; leftChild(i) < n; i = child) {
      child = leftChild(i);
      if (child != n - 1 && nums[child] < nums[child + 1]) {
        child++;
      }
      if (parent < nums[child]) {
        nums[i] = nums[child];
      } else {
        break;
      }
    }
    nums[i] = parent;
  }

  private int leftChild(int k) {
    return 2 * k + 1;
  }

  private void swap(int[] nums, int index1, int index2) {
    int tmp = nums[index1];
    nums[index1] = nums[index2];
    nums[index2] = tmp;
  }

}
