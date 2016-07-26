import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 16-6-23.
 */
public class problem118PascalsTriangle {
  public List<List<Integer>> generate(int numRows) {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    if(numRows <= 0) return result;
    List<Integer> tmp = new ArrayList<Integer>();
    tmp.add(1);
    result.add(tmp);
    helper(result,1,numRows);
    return result;
  }
  public void helper(List<List<Integer>> result, int cur, int n){
    if(cur > n) return;
    List<Integer> tmp = new ArrayList<Integer>();
    if(cur == 2){
      tmp.add(1);
      tmp.add(1);
      result.add(tmp);
    }else if(cur > 2){
      tmp.add(1);
      List<Integer> last = result.get(result.size() - 1);
      for(int i = 1; i < last.size();i++){
        int t = last.get(i) + last.get(i - 1);
        tmp.add(t);
      }
      tmp.add(1);
      result.add(tmp);
    }
    helper(result, cur + 1, n);
  }
}
