package acm.hdu;

import java.util.Scanner;

/**
 * Created by Administrator on 15-7-22.
 */
public class Problem1864 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String tmpStr = in.nextLine();
            double totalValue = Double.parseDouble(tmpStr.split(" ")[0]);
            int container = Integer.parseInt(tmpStr.split(" ")[1]);
            int tmpContainer = container;
            String[] all = new String[container];
            for(int i = 0; i < all.length;i++){
                all[i] = in.nextLine();
            }
            double[] d = new double[container + 1];
            for(int i = 0;i < container;i++){
//                if(i == 0) continue;
                String[] tmp = all[i].split(" ");
                double v = 0;
                int tiji = 1;
                boolean isContinue = true;
                for(int k = 1; k < tmp.length;k++){
                    String[] current = tmp[k].split(":");
                    if(!current[0].equals("A") && !current[0].equals("B") && !current[0].equals("C")){
                        isContinue = false;
                        break;
                    }
                    double curValue = Double.parseDouble(current[1]);
                    if(curValue > 600){
                        isContinue = false;
                        break;
                    }
                    v += curValue;
                    if(v > 1000){
                        isContinue = false;
                        break;
                    }
                }
                if(!isContinue) continue;
                for(int j = container; j >= 0;j--){
                    if(j - tiji >= 0){
                        double u = d[j];
                        d[j] = d[j] >= d[j - tiji] + v ? d[j] : d[j - tiji] + v;
                        if(d[j] > totalValue) d[j] = u;
                    }
                }
            }
            System.out.print(new java.text.DecimalFormat("#.00").format(d[container]));
        }
    }
}
