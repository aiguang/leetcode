/**
 We are playing the Guess Game. The game is as follows:

 I pick a number from 1 to n. You have to guess which number I picked.

 Every time you guess wrong, I'll tell you whether the number is higher or lower.

 You call a pre-defined API guess(int num) which returns 3 possible results (-1, 1, or 0):

 -1 : My number is lower
 1 : My number is higher
 0 : Congrats! You got it!
 Example:
 n = 10, I pick 6.

 Return 6.
 */
public class problem374GuessNumberHigherorLower {
  public static void main(String[] args){
    System.out.println(new problem374GuessNumberHigherorLower().guessNumber(10));
  }
  public int guessNumber(int n) {
    int left = 1, right = n;
    while (left < right){
      int middle = left + (right - left) / 2;
      int result = guess(middle);
      if(result == - 1){
        left = middle + 1;
      }else if(result == 1){
        right = middle - 1;
      }else{
        return middle;
      }
    }
    return 0;
  }
  public int guess(int num){
    int t = 6;
    return t == num ? 0 : t > num ? -1 : 1;
  }
}
