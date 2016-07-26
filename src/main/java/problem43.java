/**
 * Created by Administrator on 16-2-17.
 */
public class problem43 {
  public static void main(String[] args){
    String num1 = "12345";
    String num2 = "67890";
    System.out.println(new problem43().multiply(num1, num2));
  }
  public String multiply(String num1, String num2) {
    if(num1 == null || num1.length() == 0 || num2 == null || num2.length() == 0) return "";
    if(num1.equals("0") || num2.equals("0")) return "0";
    int[] m = new int[num1.length()];
    int[] n = new int[num2.length()];

    for(int j = num1.length() - 1; j >= 0;j--){
      m[num1.length() -1-j] = num1.charAt(j) - 48;
    }

    for(int j = num2.length() - 1; j >= 0;j--){
      n[num2.length() - 1 -j] = num2.charAt(j) - 48;
    }
    int[] result = new int[m.length + n.length];
    for(int i = 0; i < m.length;i++){
      for(int j = 0; j < n.length;j++){
        result[i + j] += m[i] * n[j];
      }
    }
    for(int i = 0; i < result.length - 1;i++){
      result[i + 1] += result[i] / 10;
      result[i] %= 10;
    }

    StringBuffer sb = new StringBuffer();
    for(int i =  result.length - 1;i >= 0;i--){
      if(i == result.length - 1){
        if(result[i] == 0) continue;
        else if(result[i] < 10) sb.append(result[i]);
        else {
          sb.append(result[i] % 10);
          sb.append(result[i] / 10);
        }
      }else{
        sb.append(result[i]);
      }
    }
    return sb.toString();
  }
}
