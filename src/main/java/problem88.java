/**
 Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

 Note:
 You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold
 additional elements from nums2. The number of elements initialized in nums1 and nums2 are m and n respectively.
 */
public class problem88 {
  public static void main(String[] args){
    int[] nums1 = {0};
    int m = 0;
    int[] nums2 = {1};
    int n = 1;
    new problem88().merge(nums1, m, nums2, n);
    for(int i = 0; i < nums1.length; i++){
      System.out.print(nums1[i] + ",");
    }
  }

  public void merge(int[] nums1, int m, int[] nums2, int n) {
    int[] result = new int[m + n];

    int first = 0;
    int second = 0;
    for(int i = 0; i < result.length;i++){
      if(first < m){
        if(second < n){
          if(nums1[first] < nums2[second]){
            result[i] = nums1[first++];
          }else {
            result[i] = nums2[second++];
          }
        }else{
          result[i] = nums1[first++];
        }
      }else {
        if(second < n){
          result[i] = nums2[second++];
        }
      }
    }
    for(int i = 0 ; i < result.length; i++){
      nums1[i] = result[i];
    }

  }

}
