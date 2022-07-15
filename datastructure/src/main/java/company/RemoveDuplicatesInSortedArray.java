package company;

import java.util.Arrays;
import java.util.List;

public class RemoveDuplicatesInSortedArray {
    //https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/727/

    public static void main(String[] args) {
        int[] input = new int[]{0,0,0,0,0,1,1,1,2,2,3,3,4};
        int uniqueCount = 1;
        for(int i=0;i<input.length-1;i++){
            if(input[i]!=input[i+1]){
                input[uniqueCount] = input[i+1];
                uniqueCount = uniqueCount+1;
                //input[i+1]=null;
            }
        }

        System.out.println(Arrays.toString(input));
    }
}
