package company;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class KthHighestInList {

    public static void main(String[] args) {
	// write your code here
        PriorityQueue<Integer> pq1 = new PriorityQueue<Integer>(Comparator.reverseOrder());//Min Heap
        List<Integer> list = Arrays.asList(10,78,61,15,27,67,100,89,87);
        int k = 3;
        for (int i=0;i<list.size();i++){
            pq1.add(list.get(i));

            if(pq1.size()>list.size()-(k-1)){
                pq1.poll();
            }
        }

        System.out.println(pq1.poll());
    }
}
