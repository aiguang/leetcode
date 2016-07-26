/**
 There are N children standing in a line. Each child is assigned a rating value.

 You are giving candies to these children subjected to the following requirements:

 Each child must have at least one candy.
 Children with a higher rating get more candies than their neighbors.
 What is the minimum candies you must give?
 */
public class problem135 {
  public static void main(String[] args){
    int[] ratings = {2,2};
    System.out.println(new problem135().candy(ratings));
  }
  public int candy(int[] ratings) {
    if(ratings == null || ratings.length == 0) return 0;
    int[] result = new int[ratings.length];
    for(int i = 0; i < result.length ;i++){
      result[i] = 1;
    }
    for(int i = 1; i < result.length;i++ ){
      if(ratings[i] > ratings[i - 1]){
        result[i] = result[i - 1] + 1;
      }
    }
    for(int i = result.length - 2;i >= 0 ;i--){
      if(ratings[i] > ratings[i + 1] && result[i] <= result[i + 1]){
        result[i] = result[i + 1] + 1;
      }
    }
    int sum = 0;
    for(int i = 0; i < result.length;i++){
      sum += result[i];
    }
    return sum;
  }
}
