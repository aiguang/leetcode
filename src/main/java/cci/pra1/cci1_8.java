package cci.pra1;

/**
 * Created by Administrator on 15-7-30.
 * 1.8 假顶有一个方法substring，用于检测一个字符串是否为另外一个的子串，在只是用substring一次的情况下，检测字符串s1 是否为
 * 字符串s2 反转而来
 * me ： 首先要找到反转点 在反转点时候s1可以分为x 和 y字符串，而此时s2是yx，yx一定是xyxy的子串。所以判定s2是否为s1s1的子串即可
 *
 */
public class cci1_8 {
    public boolean isRotate(String s1, String s2){
        return isSubstring(s1 + "" + s1, s2);
    }
    private boolean isSubstring(String s1, String s2){
        return true;
    }

}
