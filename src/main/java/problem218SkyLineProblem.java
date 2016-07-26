import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 (1) 自建一个名为Height的数据结构，保存一个building的index和height。约定，
 当height为负数时表示这个高度为height的building起始于index；height为正时表示这个高度为height的building终止于index。

 (2) 对building数组进行处理，每一行[ Li, Ri, Hi ]，根据Height的定义，转换为两个Height的对象，
 即，Height(Li, -Hi) 和 Height(Ri, Hi)。 将这两个对象存入heights这个List中。

 (3) 写个Comparator对heights进行升序排序，首先按照index的大小排序，若index相等，则按height大小排序，
 以保证一栋建筑物的起始节点一定在终止节点之前。

 (4) 将heights转换为结果。使用PriorityQueue对高度值进行暂存。遍历heights，遇到高度为负值的对象时，
 表示建筑物的起始节点，此时应将这个高度加入PriorityQueue。遇到高度为正值的对象时，表示建筑物的终止节点，此时应将这个高度从PriorityQueue中除去。
 且在遍历的过程中检查，当前的PriorityQueue的peek()是否与上一个iteration的peek()值（prev）相同，若否，则应在结果中加入[当前对象的index,
 当前PriorityQueue的peek()]，并更新prev的值。

 */
public class problem218SkyLineProblem {
  public static void main(String[] args){
    PriorityQueue<Integer> pq = new PriorityQueue<Integer>(1000, Collections.reverseOrder());
    pq.offer(1);
    pq.offer(-3);
    pq.offer(5);
    pq.offer(9);
    pq.offer(-11);
    while (pq.size() > 0){
      System.out.println(pq.poll());
    }
  }
  public List<int[]> getSkyline(int[][] buildings) {
    List<int[]> result = new ArrayList<int[]>();
    if (buildings == null || buildings.length == 0 || buildings[0].length == 0) {
      return result;
    }

    List<Height> heights = new ArrayList<Height>();
    for (int[] building : buildings) {
      heights.add(new Height(building[0], -building[2]));
      heights.add(new Height(building[1], building[2]));
    }
    Collections.sort(heights, new Comparator<Height>() {
      @Override
      public int compare(Height h1, Height h2) {
        return h1.index != h2.index ? h1.index - h2.index : h1.height - h2.height;
      }
    });

    PriorityQueue<Integer> pq = new PriorityQueue<Integer>(1000, Collections.reverseOrder());
    pq.offer(0);
    int prev = 0;
    for (Height h : heights) {
      if (h.height < 0) {
        pq.offer(-h.height);
      } else {
        pq.remove(h.height);
      }
      int cur = pq.peek();
      if (cur != prev) {
        result.add(new int[]{h.index, cur});
        prev = cur;
      }
    }

    return result;
  }

  class Height {
    int index;
    int height;
    Height(int index, int height) {
      this.index = index;
      this.height = height;
    }
  }
}
