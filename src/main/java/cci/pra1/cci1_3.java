package cci.pra1;

/**
 * Created by Administrator on 15-7-30.
 * 1.3 给定两个字符串，确定一个是否能够经过变化成为另外一个
 *
 * me: 用一个int数组标志source中有哪些字符（假设ASCII），然后对应的扫target，如果有不一致的情况就认为无法变化
 */
public class cci1_3 {
    public boolean isTransfer(String source ,String target){
        if(source == null && target == null) return true;
        if((source != null && target == null) || (source == null && target != null)) return false;
        if(source.length() != target.length()) return false;

        int[] result = new int[256];
        for(int i = 0; i < source.length() ; i++){
            result[source.charAt(i)]++;
        }
        for(int i = 0; i < target.length(); i++){
            result[target.charAt(i)]--;
        }
        for(int i = 0; i < result.length;i++){
            if(result[i] != 0) return false;
        }
        return true;
    }
}
