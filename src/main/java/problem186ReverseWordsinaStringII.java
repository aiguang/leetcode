/**
 * Given an input string, reverse the string word by word. A word is defined as a sequence of
 * non-space characters.
 *
 * The input string does not contain leading or trailing spaces and the words are always separated
 * by a single space.
 *
 * For example, Given s = "the sky is blue", return "blue is sky the".
 *
 * Could you do it in-place without allocating extra space?
 */
public class problem186ReverseWordsinaStringII {

  public void reverseWords(char[] s) {
    String str = new String(s);
    String[] array = str.split(" ");
    String reverse = "";
    for (int i = array.length - 1; i >= 0; --i) {
      reverse += (array[i] + " ");
    }
    reverse = reverse.substring(0, reverse.length() - 1);
    System.arraycopy(reverse.toCharArray(), 0, s, 0, s.length);
  }
}
