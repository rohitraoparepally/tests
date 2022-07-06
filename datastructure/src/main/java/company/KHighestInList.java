package company;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class KHighestInList {

    public static void main(String[] args) {
	// write your code here
        PriorityQueue<Integer> pq1 = new PriorityQueue<Integer>();//Min Heap
        List<Integer> list = Arrays.asList(10,78,61,15,27,67,100);
        int k = 3;
        for (int i=0;i<list.size();i++){
            pq1.add(list.get(i));

            if(pq1.size()>k){
                pq1.poll();
            }
        }

        while (!pq1.isEmpty()){
            System.out.println(pq1.poll());
        }
    }
}
