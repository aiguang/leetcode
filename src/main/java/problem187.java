import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG".
 When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.

 Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.

 For example,

 Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",

 Return:
 ["AAAAACCCCC", "CCCCCAAAAA"].
 */
public class problem187 {
  public static void main(String[] args){
    String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
    List<String> result = new problem187().findRepeatedDnaSequences(s);
    for(String value : result){
      System.out.println(value + ",");
    }
  }
  public List<String> findRepeatedDnaSequences(String s) {
    List<String> result = new ArrayList<String>();
    Map<String, Integer> map = new HashMap<String, Integer>();
    if(s == null || s.isEmpty() || s.length() < 10) return result;
    for(int i = 0; i < s.length();i++){
      if(s.length() - i < 10) break;
      String tmp = s.substring(i, i + 10);
      Integer count = map.get(tmp);
      if(count == null){
        map.put(tmp, 1);
      }else{
        map.put(tmp, count + 1);
      }
    }
    for(Map.Entry<String, Integer> entry : map.entrySet()){
      if(entry.getValue() > 1){
        result.add(entry.getKey());
      }
    }
    return result;
  }

}
