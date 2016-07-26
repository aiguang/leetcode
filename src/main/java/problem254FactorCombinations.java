import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 16-5-10.
 */
public class problem254FactorCombinations {
  public static void main(String[] args){
    int n = 8;
    List<List<Integer>> result = new problem254FactorCombinations().getFactors(n);
    for(List<Integer> list : result){
      for(Integer i : list){
        System.out.print(i + ",");
      }
      System.out.println();
    }
  }
  public List<List<Integer>> getFactors(int n) {
    if(n <= 1) return new ArrayList<List<Integer>>();
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    helper(result, new ArrayList<Integer>(), n , 2);
    return result;
  }
  private void helper(List<List<Integer>> result, List<Integer> cur, int n, int start){
    if(n == 1){
      if(cur.size() > 1){
        List tmp = new ArrayList(cur);
        result.add(tmp);
      }
      return;
    }
    for(int i = start; i <= n;i++){
      if(n % i == 0){
        cur.add(i);
        helper(result, cur, n / i , i);
        cur.remove(cur.size() - 1);
      }
    }
  }
}
