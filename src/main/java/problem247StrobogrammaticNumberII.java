import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at
 * upside down).
 *
 * Find all strobogrammatic numbers that are of length = n.
 *
 * For example, Given n = 2, return ["11","69","88","96"].
 */
public class problem247StrobogrammaticNumberII {
  public static void main(String[] args){
    int n = 3;
    List<String> result = new problem247StrobogrammaticNumberII().findStrobogrammatic(n);
    for(String v : result){
      System.out.print(v + ",");
    }
  }

  static Map<Integer, Integer> map = new HashMap<Integer, Integer>();
  static List<Integer> list = new ArrayList<Integer>();
  static {
    map.put(1, 1);
    map.put(8, 8);
    map.put(6, 9);
    map.put(9, 6);
    map.put(0, 0);
    list.add(1);
    list.add(8);
    list.add(6);
    list.add(9);
    list.add(0);
  }


  public List<String> findStrobogrammatic(int n) {
    if(n < 0) return new ArrayList<String>();
    if(n == 1){
      List<String> result = new ArrayList<String>();
      result.add(0 + "");
      result.add(1 + "");
      result.add(8 + "");
      return result;
    }
    List<String> result = new ArrayList<String>();
    if(n % 2 == 0){
      helper(result, n/2,0,"",new ArrayList<Integer>());
    }else{
      List<Integer> middle = new ArrayList<Integer>();
      middle.add(0);
      middle.add(1);
      middle.add(8);
      helper(result, n/ 2, 0, "", middle);
    }
    return result;
  }

  public void helper(List<String> result, int n, int curIndex, String curString, List<Integer> middleString) {
    if (curIndex == n) {
      if(middleString.size() > 0){
        for(int k = 0;k < middleString.size();k++){
          StringBuilder sb = new StringBuilder();
          sb.append(curString).append(middleString.get(k));
          for(int i = curString.length() - 1; i >= 0;i--){
            int t = Integer.parseInt(String.valueOf(curString.charAt(i)));
            sb.append(map.get(t));
          }
          result.add(sb.toString());
        }
      }else {
        StringBuilder sb = new StringBuilder();
        sb.append(curString);
        for(int i = curString.length() - 1; i >= 0;i--){
          int t = Integer.parseInt(String.valueOf(curString.charAt(i)));
          sb.append(map.get(t));
        }
        result.add(sb.toString());
      }

      return;
    }
    for(int i = 0;i < list.size();i++){
      if(curIndex == 0 && list.get(i) == 0) continue;
      curString += list.get(i);
      helper(result, n, curIndex + 1, curString, middleString);
      curString = curString.substring(0, curString.length() - 1);
    }

  }
}
