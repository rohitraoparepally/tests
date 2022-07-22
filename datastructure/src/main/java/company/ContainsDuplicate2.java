package company;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ContainsDuplicate2 {

    //https://leetcode.com/problems/contains-duplicate-ii/

    public static void main(String[] args) {
        int[] input = new int[]{1, 0, 1, 1};
        int k = 1;
        System.out.println(containsDup2(input, k));

    }

    private static boolean containsDup2(int[] input, int k) {
        Set<Integer> uniques = new HashSet<>();
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0 ;i<input.length;i++){
            if(uniques.add(input[i])){
                indexMap.put(input[i], i);
            }
            else {
                if(k >= Math.abs(indexMap.get(input[i]) - i)){
                    return true;
                }
                else {
                    indexMap.put(input[i], i);
                }
            }
        }
        return false;
    }
}
