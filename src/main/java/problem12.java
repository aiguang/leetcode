/**
 Given an integer, convert it to a roman numeral.

 Input is guaranteed to be within the range from 1 to 3999.
 */
public class problem12 {
  public static void main(String[] args){
    int i = 3998;
    System.out.println(new problem12().intToRoman(i));
  }

  public String intToRoman(int num) {
    if(num <= 0) return null;
    String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    StringBuilder sb = new StringBuilder();
    for(int i = 0; i < symbols.length ;i++){
      while (num >= values[i]){
        sb.append(symbols[i]);
        num -= values[i];
      }
    }
    return sb.toString();
  }
}
