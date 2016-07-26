import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 15-12-8.
 */
public class TestForRegex {
  public static void main(String[] args){
    Pattern pattern = Pattern.compile("([1-9]{11})");
    String input = "18896723779sdfsdfas18896723778";
    Matcher matcher = pattern.matcher(input);
    while (matcher.find()){
      System.out.println(matcher.group(2));
    }
  }
}
