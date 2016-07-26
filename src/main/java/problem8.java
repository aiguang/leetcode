import java.util.regex.Pattern;

/**
 * Created by Administrator on 16-2-1.
 */
public class problem8 {
  public static void  main(String[] args){
    String s = "1234567890abc";
    System.out.println(new problem8().myAtoi(s));
  }
  public int myAtoi(String str) {
    Pattern pattern = Pattern.compile("^\\d+$");
    if(str == null || str.isEmpty()) return 0;
    try {
      if(pattern.matcher(str).find()){
        return Integer.parseInt(str);
      }
    }catch (Exception e){
      return 0;
    }


    return 0;
  }
}
