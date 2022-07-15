package company;

public class BestTimetoBuyandSellStock {
    //https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
    public static void main(String[] args) {
        int[] input = new int[]{7,1,5,3,6,4,19};
        int leastStock=100000;
        int highStock=0;
        int leastIndex=0;

        for(int i=0;i<input.length;i++){
            if(input[i] < leastStock){
                leastIndex = i;
                leastStock = input[i];
            }
            if(input[i] > highStock && i > leastIndex){
                highStock = input[i];
            }

        }
        System.out.println(highStock - leastStock);

    }
}
