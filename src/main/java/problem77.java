import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 15-9-7.
 */
public class problem77 {
  public static void main(String[] args){
    int n = 4;
    int k = 2;
    List<List<Integer>> result = new problem77().combine(n, k);
    for(List<Integer> list : result){
      for(Integer i : list){
        System.out.print(i + ",");
      }
      System.out.println();
    }
  }
  public List<List<Integer>> combine(int n, int k) {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    calculate(n, k, result, 1, new ArrayList<Integer>());
    return result;
  }
  private void calculate(int n, int k, List<List<Integer>> result, int index, List<Integer> tmp){
    if(tmp.size() == k){
      List<Integer> m = new ArrayList<Integer>();
      for(int i : tmp){
        m.add(i);
      }
      result.add(m);
      return;
    }
    for(int i = index;i <= n;i++){
      tmp.add(i);
      calculate(n,k,result, i + 1, tmp);
      tmp.remove(tmp.size() - 1);
    }
  }
}
