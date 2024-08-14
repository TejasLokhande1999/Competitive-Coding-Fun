import java.util.*;

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {


        PriorityQueue<Pair> maxh = new PriorityQueue<>(Collections.reverseOrder(new PairComparator()));

    for(int i=0;i<arr.length;i++){
        maxh.add(new Pair(Math.abs(arr[i]-x),arr[i]));

        if(maxh.size()>k){
            maxh.poll();
        }
    }

    //we ar eleft with min elements
    //take the elements of maxh in to a list

    ArrayList<Integer> list = new ArrayList<>();
    while(!maxh.isEmpty()){

        list.add(maxh.poll().ele);

    }

    Collections.sort(list);
    return list;


        // Create a max-heap with custom comparator
        // PriorityQueue<Pair> pq = new PriorityQueue<>(Collections.reverseOrder(new PairComparator()));

        // for (int i = 0; i < arr.length; i++) {
        //     pq.add(new Pair(Math.abs(arr[i] - x), arr[i]));

        //     if (pq.size() > k) {
        //         pq.poll();
        //     }
        // }

        // List<Integer> list = new ArrayList<>();

        // while (!pq.isEmpty()) {
        //     list.add(pq.poll().getSecond());
        // }

        // // Sort the result list as required by the problem statement
        // Collections.sort(list);

        // return list;
    }

    // class Pair {
    //     int diff;
    //     int value;

    //     Pair(int diff, int value) {
    //         this.diff = diff;
    //         this.value = value;
    //     }

    //     public int getFirst() {
    //         return diff;
    //     }

    //     public int getSecond() {
    //         return value;
    //     }
    // }

    // class PairComparator implements Comparator<Pair> {
    //     public int compare(Pair p1, Pair p2) {
    //         // Compare based on difference first, then value
    //         if (p1.getFirst() == p2.getFirst()) {
    //             //return 0;
    //             return Integer.compare(p1.getSecond(), p2.getSecond());
    //         } else {
    //             return Integer.compare(p1.getFirst(), p2.getFirst());
    //         }
    //     }
    // }

}


class Pair{

    int diff;
    int ele;
    Pair(int diff, int ele){
        this.diff=diff;
        this.ele = ele;
    }
}

class PairComparator implements Comparator<Pair>{

    public int compare(Pair p1, Pair p2){

        if(p1.diff>p2.diff){
            return 1;
        }else if(p1.diff<p2.diff){
            return -1;
        }else{      //p1.diff==p2.diff
            if(p1.ele>p2.ele){
                return 1;
            }else if(p1.ele<p2.ele){
                return -1;
            }else{
                return 0;
            }
        }

    }
}
