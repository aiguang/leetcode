/**
 * Created by Administrator on 15-6-25.
 */
public class CountPrimes {
    public static void main(String[] args){
        CountPrimes countPrimes = new CountPrimes();
        System.out.println(countPrimes.countPrimes(10));
    }

    public int countPrimes(int n) {
        if (n <= 1) return 0;
        int[] result = new int[n];
        result[0] = 0;
        result[1] = 0;

        for(int i = 2;i <= n - 1;i++){
            result[i] = 1;
        }
        for(int i = 2;i <= n - 1;i++){
            for(int j = i+ i; j <= n - 1 ; j=j+i){
                result[j] = 0;
            }
        }
        int count = 0;
        for(int i = 0; i <= n - 1; i++){
            if(result[i] == 1)
                count++;
        }
        return count;
    }

}
