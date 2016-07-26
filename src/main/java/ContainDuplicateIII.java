import java.util.TreeSet;

/**
 * Created by Administrator on 15-7-20.
 *
 *
 * 用一个TreeSet来存放窗口内的元素们，每来一个新元素，就：

 使用floor方法去找是否已存在小于等于新元素的元素，如果找到，就加上t看看是否能够等于或超过新元素，如果是，就说明这两个元素差值小于等于t；
 使用ceiling方法去找是否已存在大于等于新元素的元素，如果找到，就减掉t看看是否能够等于或者小于新元素，如果是，也说明这两个元素差值小于等于t。
 */
public class ContainDuplicateIII {
    TreeSet<Integer> treeSet = new TreeSet<Integer>();
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(nums == null || nums.length == 0 || k <= 0 || t < 0) return false;
        for(int i = 0; i < nums.length; i++){
            int current = nums[i];
            if(treeSet.floor(current) != null && current <= t + treeSet.floor(current)) return true;
            if(treeSet.ceiling(current) != null && current >= treeSet.ceiling(current) - t) return true;
            treeSet.add(current);
            if(i >= k)
                treeSet.remove(nums[i - k]);
        }
        return false;
    }
}
