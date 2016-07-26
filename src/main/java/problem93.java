import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 15-10-7.
 */
public class problem93 {

  private static Pattern ipPattern = Pattern.compile("^((?:(?:25[0-5]|2[0-4]\\d|((1\\d{2})|([1-9]?\\d)))\\.){3}(?:25[0-5]|2[0-4]\\d|((1\\d{2})|([1-9]?\\d))))$");
  public static void main(String[] args){
//    String s = "25525511135";
    String s = "0000";
    List<String> result = new problem93().restoreIpAddresses(s);
    for(int i = 0; i < result.size();i++){
      System.out.print(result.get(i) + ",");
    }
  }
  public List<String> restoreIpAddresses(String s) {
    if(s == null || s.isEmpty()) return new ArrayList<String>();
    List<String> result = new ArrayList<String>();
    helper(s, new ArrayList<String>(), result);
    return result;
  }
  public void helper(String curString, List<String> curList, List<String> result){
    if(curList.size() + 1 == 4){
      StringBuilder sb = new StringBuilder();
      for(String value : curList){
        sb.append(value).append(".");
      }
      sb.append(curString);
      if(ipPattern.matcher(sb.toString()).find()){
        result.add(sb.toString());
      }
      return;
    }
    for(int i = 0; i < 3 && i < curString.length();i++){
      String tmp = curString.substring(0, i + 1);
      curList.add(tmp);
      helper(curString.substring(i + 1, curString.length()), curList, result);
      curList.remove(curList.size() - 1);
    }
  }
}
