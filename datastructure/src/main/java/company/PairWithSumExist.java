package company;

import java.util.*;

public class PairWithSumExist {
    //https://leetcode.com/problems/lru-cache/

    public static void main(String[] args) {
        List<Integer> input = Arrays.asList(6,4,3,2,1,7);


        System.out.println(hasSum(input,13));
    }

    private static boolean hasSum(List<Integer> input, int sum) {
        Set<Integer> sumSet = new HashSet<Integer>();
        for(Integer value : input) {
            if(sumSet.contains(value))
                return true;
            else {
                sumSet.add(sum-value);
            }
    }
        return false;
    }

}
