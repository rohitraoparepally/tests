package company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CommonElementsInTwoSortedArray {

    public static void main(String[] args) {
        List<Integer> input = Arrays.asList(1,3,4,6,7,9);
        List<Integer> input2 = Arrays.asList(1,2,4,5,9,10);


        commonElementsInTwoSortedArrayOptimal(input, input2).forEach(System.out::println);
    }

    private static List<Integer> commonElementsInTwoSortedArrayOptimal(List<Integer> input, List<Integer> input2) {
        List<Integer> result = new ArrayList<>();
        int p1=0,p2=0;

        while (p1<input.size() && p2<input2.size()){
            if(input.get(p1) == input2.get(p2)){
                result.add(input.get(p1));
                p1= p1+1;
                p2 = p2+1;
            }
            else if(input.get(p1) < input2.get(p2)){
                p1=p1+1;
            }
            else {
                p2=p2+1;
            }
        }

        return result;
    }

    private static List<Integer> commonElementsInTwoSortedArray(List<Integer> input, List<Integer> input2) {

        List<Integer> result = new ArrayList<>();
        for(int i = 0;i< input.size();i++){
            int lowerIndex = 0;
            for (int j=lowerIndex;j<input2.size() ; j++){
                if(input.get(i) == input2.get(j)){
                    result.add(input.get(i));
                }
                else if(input.get(i) < input2.get(j)){
                    lowerIndex = j-1;
                    break;
                }
            }
        }
        return result;
    }
}
