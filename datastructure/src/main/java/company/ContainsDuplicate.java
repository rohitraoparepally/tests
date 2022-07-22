package company;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {

   // https://leetcode.com/problems/contains-duplicate/

    public static void main(String[] args) {
        int[] input = new int[]{1,2,3,4,5,6,7};

System.out.println(hasDup(input));

}

private static boolean hasDup(int[] input){
    Set<Integer> uniqueSet = new HashSet<>();

    for (int i : input){
        if( !uniqueSet.add(i))
        {
            return true;
        }
    }
    return false;
    }
}

