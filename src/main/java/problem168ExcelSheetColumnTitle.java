/**
 * Created by Administrator on 16-6-26.
 */
public class problem168ExcelSheetColumnTitle {
  public String convertToTitle(int n) {
    if(n <= 0) return "";
    StringBuilder sb = new StringBuilder();
    while (n > 0){
      int i = n / 26;
      int a = n % 26;
      sb.append((char)(a - 1 + 'A'));
      n = i;
    }
    return sb.toString();
  }
}
