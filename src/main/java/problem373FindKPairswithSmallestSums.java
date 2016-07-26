import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 You are given two integer arrays nums1 and nums2 sorted in ascending order and an integer k.

 Define a pair (u,v) which consists of one element from the first array and one element from the second array.

 Find the k pairs (u1,v1),(u2,v2) ...(uk,vk) with the smallest sums.

 Example 1:
 Given nums1 = [1,7,11], nums2 = [2,4,6],  k = 3

 Return: [1,2],[1,4],[1,6]

 The first 3 pairs are returned from the sequence:
 [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
 Example 2:
 Given nums1 = [1,1,2], nums2 = [1,2,3],  k = 2

 Return: [1,1],[1,1]

 The first 2 pairs are returned from the sequence:
 [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
 Example 3:
 Given nums1 = [1,2], nums2 = [3],  k = 3

 Return: [1,3],[2,3]

 All possible pairs are returned from the sequence:
 [1,3],[2,3]
 */
public class problem373FindKPairswithSmallestSums {
  public static void main(String[] args){
  }
  public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
    if(nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0 || k <= 0) return null;
    PriorityQueue<int[]> heap = new PriorityQueue<int[]>(k, new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        return o2[0] + o2[1] - o1[0] - o1[1] ;
      }
    });
    for(int i = 0 ; i < nums1.length;i++){
      for(int j = 0; j < nums2.length;j++){
        int[] r = new int[2];
        r[0] = nums1[i];
        r[1] = nums2[j];
        if(heap.size() < k){
          heap.offer(r);
        }else {
          int[] top = heap.peek();
          if(top[0] + top[1] > r[0] + r[1]){
            heap.poll();
            heap.offer(r);
          }
        }
      }
    }
    List<int[]> result = new ArrayList<int[]>();
    for(int[] t : heap){
      result.add(t);
    }
    return result;
  }
}
