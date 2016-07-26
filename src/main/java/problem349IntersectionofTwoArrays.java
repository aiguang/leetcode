import org.omg.CORBA.INTERNAL;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 Given two arrays, write a function to compute their intersection.

 Example:
 Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].

 Note:
 Each element in the result must be unique.
 The result can be in any order.
 */
public class problem349IntersectionofTwoArrays {
  public static void main(String[] args){
    int[] nums2 = {4,9,5};
    int[] nums1 = {9,4,9,8,4};
    int[] result = new problem349IntersectionofTwoArrays().intersection(nums1, nums2);
    System.out.println(result.length);
  }
  public int[] intersection(int[] nums1, int[] nums2) {
    if(nums1 == null || nums2 == null) return null;
    if(nums1.length == 0 || nums2.length == 0) return new int[]{};
    Set<Integer> set1 = new HashSet<Integer>();
    Set<Integer> set2 = new HashSet<Integer>();
    for(int i = 0; i < nums1.length;i++){
      set1.add(nums1[i]);
    }
    for(int i = 0; i < nums2.length;i++){
      set2.add(nums2[i]);
    }
    set2.retainAll(set1);
    int[] r = new int[set2.size()];
    int index = 0;
    Iterator<Integer> iterator = set2.iterator();
    while (iterator.hasNext()){
      r[index++] = iterator.next();
    }
    return r;
  }
}
