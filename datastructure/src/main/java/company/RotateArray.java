package company;

import java.util.*;

public class RotateArray {
    //https://leetcode.com/problems/rotate-array/
    public static void main(String[] args) {
        Integer[] input = new Integer[]{1,2,3,4,5,6,7};
        int k = 3;
        //int[] buffer = new int[input.length];
        Collection<Integer> buffer = new ArrayList<>();

        for (int i =0;i<k;i++){
            buffer.clear();
            Collections.addAll(buffer, input[input.length-1]);
            Collections.addAll(buffer, Arrays.copyOfRange(input,0, input.length-1));
            input = Arrays.copyOf(buffer.toArray(),buffer.size(), Integer[].class);
        }

        System.out.println(Arrays.toString(input));
    }
}
