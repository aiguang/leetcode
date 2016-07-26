/**
 Given a positive integer, return its corresponding column title as appear in an Excel sheet.

 For example:

 1 -> A
 2 -> B
 3 -> C
 ...
 26 -> Z
 27 -> AA
 28 -> AB
 */
public class problem168 {
  public static void main(String[] args){
    int i = 53;
    System.out.println(new problem168().convertToTitle(i));
  }

  public String convertToTitle(int n) {
    StringBuilder sb = new StringBuilder();
    for(;n > 0;n/=26){
      sb.insert(0,(char)('A' + --n %26));
    }
    return sb.toString();
  }
}
