import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 16-6-26.
 */
public class problem290WordPattern {
  public static void main(String[] args){
    String pattern = "abba";
    String str = "dog dog dog dog";
    System.out.println(new problem290WordPattern().wordPattern(pattern, str));
  }
  public boolean wordPattern(String pattern, String str) {
    String[] array = str.split(" ");
    Map<Character, String> map = new HashMap<Character, String>();
    for(int i = 0; i < pattern.length();i++){
      if(i >= array.length) return false;
      char cur = pattern.charAt(i);
      String target = map.get(cur);
      if(target == null){
        map.put(cur, array[i]);
      }else{
        if(i >= array.length || !target.equals(array[i])) return false;
      }
    }
    return true;
  }
}
