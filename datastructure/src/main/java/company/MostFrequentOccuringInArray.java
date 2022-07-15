package company;

import java.util.*;

public class MostFrequentOccuringInArray {
    //https://leetcode.com/problems/lru-cache/

    public static void main(String[] args) {
        List<Integer> input = Arrays.asList(6,4,3,2,1,7,6,9,10,6, 1, 2, 1, 1);


        System.out.println(mostFrequentOccuringInArray(input));
    }

    private static Integer mostFrequentOccuringInArray(List<Integer> input) {
        Set<Integer> sumSet = new HashSet<Integer>();
        int maxCount = 0;
        int maxOccuredValue = 0;
        Map<Integer, Integer> occuranceMap = new HashMap<Integer, Integer>();
        for(Integer value : input) {
            int currentValueCount = occuranceMap.get(value)==null ? 0 : occuranceMap.get(value);
            if(maxCount <= currentValueCount+1){
                maxCount = currentValueCount+1;
                maxOccuredValue = value;
            }
            occuranceMap.put(value,currentValueCount+1);

        }
        return maxOccuredValue;
    }

}
