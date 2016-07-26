import java.net.URLDecoder;

/**
 * Created by Administrator on 15-8-4.
 */
public class ValidAnagram {
    public static void main(String[] args){
        ValidAnagram validAnagram = new ValidAnagram();
        String s = "rat";
        String t = "car";
        System.out.println(validAnagram.isAnagram(s, t));
    }
    public boolean isAnagram(String s, String t) {
        if(s == null && t == null) return true;
        if(s == null && t != null) return false;
        if(s != null && t == null) return false;

        //a 97 ~ z 122
        int[] counts = new int[26];
        for(int i = 0; i < t.length(); i++){
            char tmp = t.charAt(i);
            counts[tmp - 97]++;
        }
        for(int i = 0; i < s.length();i++){
            char tmp = s.charAt(i);
            counts[tmp - 97]--;
        }
        for(int i = 0; i < counts.length;i++){
            if(counts[i] != 0)
                return false;
        }
        return true;
    }
}
