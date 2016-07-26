package acm.hdu;

/**
 * Created by Administrator on 15-7-26.
 */
public class Problem1231 {
    public static void main(String[] args){
//        -2 11 -4 13 -5 -2
        int container = 6;
        int[] dp = new int[container + 1];
        int[] value = new int[container];
        value[0] = -2;
        value[1] = 11;
        value[2] = -4;
        value[3] = 13;
        value[4] = -5;
        value[5] = -2;
        for(int i = 0;i < container + 1;i++){
            if(i == 0){
                dp[i] = 0;
                continue;
            }
            for(int j = container;j > 0; j--){
               dp[j] = dp[j] > dp[j - 1] + value[j - 1] ? dp[j] : dp[j - 1] + value[j - 1];
            }
        }
        int max = 0;
        int index = 0;
        for(int i = 0 ;i < dp.length; i++){
//            System.out.println(dp[i]);
            if(max < dp[i]){
                max = dp[i];
                index = i;
            }
        }
        for(int i = index; i > 0; i--){
            if(i >= 1 && dp[i] <= dp[i - 1] + value[i - 1]){
                System.out.println(i + "put in");
            }
        }
    }
}
