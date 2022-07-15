package company;

public class BestTimetoBuyandSellStock2 {
    //https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
    public static void main(String[] args) {
        int[] input = new int[]{7,4,5,4,5,19};
        int leastStock=input[0];
        int highStock=input[0];
        int maxProfit=0;

        for(int i=0;i<input.length;i++){

            if(input[i] < highStock){
                maxProfit = maxProfit + (highStock - leastStock);
                leastStock = input[i];
                highStock = input[i];
            }
            else if(input[i] > highStock){
                highStock = input[i];
            }

        }
        maxProfit = maxProfit + (highStock -leastStock);
        System.out.println(maxProfit);

    }
}
