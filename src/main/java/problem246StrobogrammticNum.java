import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 16-5-9.
 */
public class problem246StrobogrammticNum {
  public static void main(String[] args){
    int num = 2;
    List<String> result = new problem246StrobogrammticNum().generateStrobogrammatic(num);
    for(String s : result){
      System.out.println(s);
    }
  }
  public boolean isStrobogrammatic(String num) {
    Map<Character, Character> map = new HashMap<Character, Character>();
    map.put('9', '6');
    map.put('6', '9');
    map.put('1', '1');
    map.put('8', '8');
    map.put('0', '0');
    int left = 0, right = num.length() - 1;
    while(left <= right){
      char l = num.charAt(left);
      char r = num.charAt(right);
      if(map.get(l) != r){
        return false;
      }
      l++;
      r--;
    }
    return true;
  }

  public List<String> generateStrobogrammatic(int num){
    if(num < 1) return new ArrayList<String>();
    List<Character> source = new ArrayList<Character>();
    source.add('9');
    source.add('6');
    source.add('1');
    source.add('8');
    source.add('0');

    Map<Character, Character> map = new HashMap<Character, Character>();
    map.put('9', '6');
    map.put('6', '9');
    map.put('1', '1');
    map.put('8', '8');
    map.put('0', '0');
    List<String> result = new ArrayList<String>();
    helper(source, map, result, "", num);
    return result;
  }
  public void helper(List<Character> source, Map<Character, Character> map, List<String> result, String curString, int num){
    if(num % 2 == 0 && curString.length() == num / 2){
      StringBuilder r= new StringBuilder();
      r.append(curString);
      for(int i = curString.length() - 1; i >= 0;i--){
        r.append(map.get(curString.charAt(i)));
      }
      result.add(r.toString());
      return;
    }
    if(num % 2 != 0 && curString.length() == (num + 1) / 2){
      StringBuilder r= new StringBuilder();
      r.append(curString);
      for(int i = curString.length() - 2; i >= 0;i--){
        r.append(map.get(curString.charAt(i)));
      }
      result.add(r.toString());
      return;
    }
    for (int i = 0; i < source.size();i++){
      curString += source.get(i);
      helper(source, map, result, curString, num);
      curString = curString.substring(0, curString.length() - 1);
    }
  }
}
