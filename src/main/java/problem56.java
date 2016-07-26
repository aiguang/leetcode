import com.sun.org.apache.regexp.internal.recompile;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 Given a collection of intervals, merge all overlapping intervals.

 For example,
 Given [1,3],[2,6],[8,10],[15,18],
 return [1,6],[8,10],[15,18].
 */
public class problem56 {
  public static void main(String[] args){
    List<Interval> testList = new ArrayList<Interval>();
    Interval interval = new Interval(1,3);
    testList.add(interval);
    interval = new Interval(2,6);
    testList.add(interval);
    interval = new Interval(8,10);
    testList.add(interval);
    interval = new Interval(15,18);
    testList.add(interval);

    List<Interval> result = new problem56().merge(testList);
    for(Interval value : result){
      System.out.println(value.start + "    " + value.end);
    }
  }
  public List<Interval> merge(List<Interval> intervals) {
    List<Interval> result = new ArrayList<Interval>();
    if(intervals == null || intervals.isEmpty()) return result;

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
