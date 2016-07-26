import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

 You may assume that the intervals were initially sorted according to their start times.

 Example 1:
 Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].

 Example 2:
 Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].

 This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
 */
public class problem57 {
  public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
    List<Interval> result = new ArrayList<Interval>();
    if(intervals == null|| newInterval == null) return result;
    intervals.add(newInterval);
    Comparator<Interval> comparator = new Comparator<Interval>() {
      @Override
      public int compare(Interval o1, Interval o2) {
        if(o1.start != o2.start) return o1.start - o2.start;
        else return o1.end - o2.end;
      }
    };
    Collections.sort(intervals, comparator);
    for(int i = 0; i < intervals.size(); i++){
      Interval interval = intervals.get(i);
      if(result.isEmpty()){
        result.add(interval);
      }else {
        Interval old = result.get(result.size() - 1);
        if(interval.start > old.end){
          result.add(interval);
        }else{
          Interval newOne = new Interval(old.start, Math.max(interval.end, old.end));
          result.remove(result.size() - 1);
          result.add(newOne);
        }
      }
    }
    return result;
  }
}
