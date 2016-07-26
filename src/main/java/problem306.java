/**
 * Additive number is a string whose digits can form additive sequence.
 *
 * A valid additive sequence should contain at least three numbers. Except for the first two
 * numbers, each subsequent number in the sequence must be the sum of the preceding two.
 *
 * For example: "112358" is an additive number because the digits can form an additive sequence: 1,
 * 1, 2, 3, 5, 8.
 *
 * 1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8 "199100199" is also an additive number, the additive
 * sequence is: 1, 99, 100, 199. 1 + 99 = 100, 99 + 100 = 199 Note: Numbers in the additive sequence
 * cannot have leading zeros, so sequence 1, 2, 03 or 1, 02, 3 is invalid.
 *
 * Given a string containing only digits '0'-'9', write a function to determine if it's an additive
 * number.
 *
 * Follow up: How would you handle overflow for very large input integers?
 */
public class problem306 {

  public boolean isAdditiveNumber(String num) {
    if (num == "") {
      return false;
    }
    for (int i = 1; i < num.length() - 1; i++) {
      if (i >= num.length() - i) {
        return false;
      }
      if (num.charAt(0) == '0' && i > 1) {
        return false;
      }
      for (int j = i + 1; j < num.length(); j++) {
        if (num.charAt(i) == '0' && j > i + 1) {
          break;
        }
        if (j - i > num.length() - j) {
          break;
        }
        if (num.charAt(j) == '0') {
          continue;
        }
        Long left = Long.parseLong(num.substring(0, i));
        Long right = Long.parseLong(num.substring(i, j));
        String sum = Long.toString(left + right);
        String other = num.substring(j, num.length());
        ;
        while (other.length() > 0 && !other.startsWith("0")) {
          if (!other.startsWith(sum)) {
            break;
          }
          other = other.substring(sum.length());
          left = right;
          right = Long.valueOf(sum);
          sum = Long.toString(left + right);
        }
        if (other.length() == 0) {
          return true;
        }
      }
    }
    return false;
  }
}
