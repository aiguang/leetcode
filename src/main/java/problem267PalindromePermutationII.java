import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 Given a string s, return all the palindromic permutations (without duplicates) of it.
 Return an empty list if no palindromic permutation could be form.

 For example:

 Given s = "aabb", return ["abba", "baab"].

 Given s = "abc", return [].

 Hint:

 If a palindromic permutation exists, we just need to generate the first half of the string.
 To generate all distinct permutations of a (half of) string, use a similar approach from: Permutations II or Next Permutation.
 Show Tags
 Show Similar Problems

 */
public class problem267PalindromePermutationII {
  public static void main(String[] args){
    String s = "abbaa";
    List<String> result = new problem267PalindromePermutationII().generatePalindromes(s);
    for(String v : result){
      System.out.print(v + ",");
    }
  }
  public List<String> generatePalindromes(String s){
    if(s == null || s.isEmpty()) return new ArrayList<String>();
    if(s.length() == 1){
      ArrayList<String> result = new ArrayList<String>();
      result.add(s);
      return result;
    }
    Map<Character, Integer> map = new HashMap<Character, Integer>();
    for(char c : s.toCharArray()){
      if(map.containsKey(c)){
        map.put(c, map.get(c) + 1);
      }else{
        map.put(c, 1);
      }
    }
    if(map.keySet().size() == 1){
      ArrayList<String> result = new ArrayList<String>();
      result.add(s);
      return result;
    }
    int oddNum = 0;
    char middleChar = '0';

    int arraySize = 0;
    for(Map.Entry<Character, Integer> entry : map.entrySet()){
      arraySize += entry.getValue() / 2;
      if(entry.getValue() % 2 != 0){
        oddNum += 1;
        middleChar = entry.getKey();
      }
      if(oddNum > 1){
        return new ArrayList<String>();
      }
    }
    if(map.size() == 2 && oddNum == 1){
      StringBuilder sb = new StringBuilder();
      char c = '0';
      for(Map.Entry<Character, Integer> entry : map.entrySet()){
        if(entry.getKey() != middleChar){
          c = entry.getKey();
          break;
        }
      }
      for(int i = 0; i < map.get(c) / 2;i++){
        sb.append(c);
      }
      sb.append(middleChar);
      for(int i = 0; i < map.get(c) / 2;i++){
        sb.append(c);
      }
      ArrayList<String> result = new ArrayList<String>();
      result.add(sb.toString());
      return result;
    }
    char[] array = new char[arraySize];
    int index = 0;
    for(Map.Entry<Character, Integer> entry : map.entrySet()){
      for(int i = 0; i < entry.getValue() / 2;i++){
        array[index++] = entry.getKey();
      }
    }
    Arrays.sort(array);
    List<String> result = new ArrayList<String>();
    helper(array, result, middleChar,0);
    return result;
  }
  public void helper(char[] array, List<String> result, char middle, int index){
    if(index == array.length - 1){
      StringBuilder sb = new StringBuilder();
      for(int i = 0; i < array.length;i++){
        sb.append(array[i]);
      }
      if(middle != '0'){
        sb.append(middle);
      }
      for(int i = array.length - 1;i >= 0;i--){
        sb.append(array[i]);
      }
      result.add(sb.toString());
    }
    for(int i = index; i < array.length;i++){
      if(canSwap(i, index, array)){
        swap(i, index, array);
        helper(array, result, middle, index+ 1);
        swap(index, i, array);
      }
    }
  }
  private void swap(int i, int j, char[] array){
    char tmp = array[i];
    array[i] = array[j];
    array[j] = tmp;
  }
  private boolean canSwap(int i, int j, char[] array){
    for(;i < j;i++){
      if(array[i] == array[j]) return false;
    }
    return true;
  }

}
