/**
 * Created by Administrator on 16-4-28.
 */
public class ReverseString {
  public static void main(String[] args){
    String s = "hellp";
    System.out.println(new ReverseString().reverseString(s));
  }
  public String reverseString(String s) {
    if(s == null || s.length() == 0) return s;
    StringBuilder sb = new StringBuilder();
    for(int i = 0; i < s.length();i++){
      sb.append(s.charAt(s.length() - i - 1));
    }
    return sb.toString();
  }
}
