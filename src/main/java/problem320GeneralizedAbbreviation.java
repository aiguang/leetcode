import java.util.ArrayList;
import java.util.List;

/**
 Write a function to generate the generalized abbreviations of a word.

 Example:
 Given word = "word", return the following list (order does not matter):
 ["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]
 */
public class problem320GeneralizedAbbreviation {
  private void helper(String word, int preCount, String currW, List<String> res) {
    if(word.isEmpty())
      res.add(currW);
    else {
      //not to abbr
      helper(word.substring(1), 0, currW+word.charAt(0), res);

      //to abbr
      int end = preCount==0 ? currW.length() : (currW.length()-(""+preCount).length());
      helper(word.substring(1), preCount+1, currW.substring(0,end)+(preCount+1), res);
    }
  }

  public List<String> generateAbbreviations(String word) {
    List<String> res = new ArrayList<String>();
    helper(word, 0, "", res);
    return res;
  }
}
