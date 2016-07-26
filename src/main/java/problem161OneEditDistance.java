import com.sun.corba.se.spi.activation._RepositoryStub;

/**
 * Created by Administrator on 16-5-9.
 */
public class problem161OneEditDistance {
  public static void main(String[] args){
    String s = "a";
    String t = "ba";
    System.out.println(new problem161OneEditDistance().isOneEditDistance(s, t));
  }
  public boolean isOneEditDistance(String s , String t){
    if(s == null && t == null) return true;
    if(s.equals(t)) return false;
    if(Math.abs(s.length() - t.length()) > 1) return false;
    if(s.length() == t.length()){
      int diff = 0;
      for(int i = 0; i < s.length();i++){
        if(s.charAt(i) != t.charAt(i)) diff++;
      }
      return diff <= 1;
    }else {
      String so = s.length() < t.length() ? s : t;
      String lo = s.length() < t.length() ? t : s;
      for(int i = 0; i < so.length();i++){
        if(so.charAt(i) == lo.charAt(i)) continue;
        return so.substring(i).equals(lo.substring(i + 1));
      }
      return true;
    }
  }
}
