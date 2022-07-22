package company;

import java.util.HashSet;
import java.util.Set;

public class SingleNumber {
    public static void main(String[] args) {
        int[] nums = new int[]{4,1,2,1,2};
        System.out.println(singleNumber(nums));
    }

    private static int singleNumber(int[] nums) {
        Set<Integer> uniques = new HashSet<>();
        int singleNum = 0;
        for (int num : nums){
            if(uniques.add(num) && singleNum == 0){
                singleNum = num;
            }
            else {
                if(num == singleNum){
                    singleNum = 0;
                }
            }
        }
        return singleNum;
    }
}
