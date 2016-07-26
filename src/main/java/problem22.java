import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 15-8-17.
 */
public class problem22 {
  public static void main(String[] args){
    List<String> result = new problem22().generateParenthesis(3);
    for(String value : result){
      System.out.println(value);
    }
  }
  public List<String> generateParenthesis(int n) {
    List<String> result = new ArrayList<String>();
    if(n <= 0) return result;
    calculate(result, n, n, "");
    return result;
  }
  private void calculate(List<String> result, int fpN, int backN, String value){
    if(fpN == 0 && backN == 0){
      result.add(value);
      return;
    }
    if(fpN > 0){
      calculate(result, fpN - 1, backN, value + "(");
    }
    if(backN > fpN){
      calculate(result, fpN, backN - 1, value + ")");
    }
  }
}
