import java.util.ArrayList;

/**
 * Created by Administrator on 16-6-23.
 */
public class problem119PascalsTriangleII {

  public ArrayList<Integer> getRow(int rowIndex) {
    ArrayList<Integer> res = new ArrayList<Integer>();
    if (rowIndex < 0) {
      return res;
    }
    res.add(1);
    for(int i = 1;i <= rowIndex;i++){
      for(int j = res.size() - 2;j >= 0;j--){
        res.set(j + 1, res.get(j) + res.get(j + 1));
      }
      res.add(1);
    }
    return res;
  }
}
