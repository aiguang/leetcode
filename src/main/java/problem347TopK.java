import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 Given a non-empty array of integers, return the k most frequent elements.

 For example,
 Given [1,1,1,2,2,3] and k = 2, return [1,2].

 Note:
 You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 */
public class problem347TopK {
  public static void main(String[] args){
    int[] nums = {1,1,1,2,2,3};
    List<Integer> list = new problem347TopK().topKFrequent(nums, 2);
    for(Integer value : list){
      System.out.println(value);
    }
  }
  public List<Integer> topKFrequent(int[] nums, int k) {
    if(nums == null || nums.length == 0 || k < 1) return new ArrayList<Integer>();
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    for(Integer value : nums){
      if(map.containsKey(value)){
        map.put(value, map.get(value) + 1);
      }else{
        map.put(value, 1);
      }
    }
    TreeMap<Integer, List<Integer>> result = new TreeMap<Integer, List<Integer>>();
    for(Map.Entry<Integer, Integer> entry : map.entrySet()){
      List<Integer> list = result.get(entry.getValue());
      if(list != null){
        list.add(entry.getKey());
        result.put(entry.getValue(), list);
      }else{
        list = new ArrayList<Integer>();
        list.add(entry.getKey());
        result.put(entry.getValue(), list);
      }
    }

    List<Integer> r = new ArrayList<Integer>();
    Iterator<Integer> it = result.descendingKeySet().iterator();
    while (it.hasNext() && k > 0){
      int key = it.next();
      List<Integer> value = result.get(key);
      r.addAll(value);
      k -= value.size();
    }
    return r;
  }
}
