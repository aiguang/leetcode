/**
 * Created by Administrator on 15-6-24.
 */

import java.util.Arrays;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 * it is 14th of problems
 */
public class LongestCommonPrefix {
    public static void main(String[] args){
        LongestCommonPrefix prefix = new LongestCommonPrefix();
        String[] array = {"asdfuio", "asdf", "as123", "asdfgh", "123"};
        System.out.println(prefix.longestCommonPrefix(array));
    }
    public String longestCommonPrefix(String[] strs){
        if(strs == null || strs.length == 0){
            return "";
        }
        if(strs.length == 1){
            return strs[0];
        }
        return longestCommonPrefix(middleString(strs[0], strs[1]), Arrays.copyOfRange(strs, 2, strs.length));
    }
    public String longestCommonPrefix(String tmpString, String[] strs){
        if(strs == null || strs.length == 0){
            return tmpString;
        }
        if(strs.length == 1){
            return middleString(tmpString, strs[0]);
        }
        return longestCommonPrefix(middleString(tmpString, strs[0]), Arrays.copyOfRange(strs, 1, strs.length));
    }

    public String middleString(String first, String second){
        int firstLength = first.length();
        int secondLength = second.length();

        int size = firstLength < secondLength ? firstLength : secondLength;
        StringBuilder builder = new StringBuilder();
        for(int i = 0 ; i < size; i++){
            if(first.charAt(i) == second.charAt(i)){
                builder.append(first.charAt(i));
            }else{
                return builder.toString();
            }
        }
        return builder.toString();
    }
}


