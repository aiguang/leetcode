/**
 * Created by Administrator on 15-6-24.
 */
public class LengthOfLastWord {
    public static void main(String[] args) {
        LengthOfLastWord test = new LengthOfLastWord();
        System.out.println(test.lengthOfLastWord("a "));
    }

    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0)
            return 0;

        int result = 0;
        int len = s.length();

        boolean flag = false;
        for (int i = len - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
                flag = true;
                result++;
            } else {
                if (flag)
                    return result;
            }
        }
        return result;
    }
}
