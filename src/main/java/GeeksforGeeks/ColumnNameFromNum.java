package GeeksforGeeks;

/**
 * Created by Administrator on 16-3-28.
 */
public class ColumnNameFromNum {
  public String parseNum(int n){
    if(n <= 0) return null;
    StringBuilder sb = new StringBuilder();
    while (n > 26){
      sb.append('A');
      n -= 26;
    }
    sb.append((char)('A' + n));
    return sb.toString();
  }
}
