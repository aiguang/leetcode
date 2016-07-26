/**
 * Convert a non-negative integer to its english words representation. Given input is guaranteed to
 * be less than 231 - 1.
 *
 * For example, 123 -> "One Hundred Twenty Three" 12345 -> "Twelve Thousand Three Hundred Forty
 * Five" 1234567 -> "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven" Hint:
 *
 * Did you see a pattern in dividing the number into chunk of words? For example, 123 and 123000.
 * Group the number by thousands (3 digits). You can write a helper function that takes a number
 * less than 1000 and convert just that chunk to words. There are many edge cases. What are some
 * good test cases? Does your code work with input such as 0? Or 1000010? (middle chunk is zero and
 * should not be printed out)
 */
public class problem273IntegertoEnglishWords {

  public String numberToWords(int num) {
    if(num == 0) return "Zero";
    StringBuilder sb = new StringBuilder();

    if (num >= 1000000000) {
      sb.append(helper(num / 1000000000) + " Billion");
      num %= 1000000000;
      if (num != 0) {
        sb.append(" ");
      } else {
        return sb.toString();
      }
    }

    if (num >= 1000000) {
      sb.append(helper(num / 1000000) + " Million");
      num %= 1000000;
      if (num != 0) {
        sb.append(" ");
      } else {
        return sb.toString();
      }
    }

    if (num >= 1000) {
      sb.append(helper(num / 1000) + " Thousand");
      num %= 1000;
      if (num != 0) {
        sb.append(" ");
      } else {
        return sb.toString();
      }
    }

    if (num > 0) {
      sb.append(helper(num));
    }

    return sb.toString();
  }

  private String helper(int n) {
    //deal with n < 1000
    StringBuilder sb = new StringBuilder();
    String one[] = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    String ten[] =
        {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    String eleven[] =
        {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen",
         "Eighteen", "Nineteen"};

    if (n >= 100) {
      sb.append(one[n / 100] + " Hundred");
      n %= 100;
      if (n != 0) {
        sb.append(" ");
      } else {
        return sb.toString();
      }
    }

    if (n >= 20) {
      sb.append(ten[n / 10]);
      n %= 10;
      if (n != 0) {
        sb.append(" ");
      } else {
        return sb.toString();
      }
    } else if (n >= 10) {
      sb.append(eleven[n % 10]);
    }

    if (10 > n && n > 0) {
      sb.append(one[n]);
    }
    return sb.toString();
  }
}
