import java.util.*;

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        // Create a min-heap with custom comparator
        PriorityQueue<Pair> pq = new PriorityQueue<>(Collections.reverseOrder(new PairComparator()));

        for (int i = 0; i < arr.length; i++) {
            pq.add(new Pair(Math.abs(arr[i] - x), arr[i]));

            if (pq.size() > k) {
                pq.poll();
            }
        }

        List<Integer> list = new ArrayList<>();

        while (!pq.isEmpty()) {
            list.add(pq.poll().getSecond());
        }

        // Sort the result list as required by the problem statement
        Collections.sort(list);

        return list;
    }

    class Pair {
        int diff;
        int value;

        Pair(int diff, int value) {
            this.diff = diff;
            this.value = value;
        }

        public int getFirst() {
            return diff;
        }

        public int getSecond() {
            return value;
        }
    }

    class PairComparator implements Comparator<Pair> {
        public int compare(Pair p1, Pair p2) {
            // Compare based on difference first, then value
            if (p1.getFirst() == p2.getFirst()) {
                //return 0;
                return Integer.compare(p1.getSecond(), p2.getSecond());
            } else {
                return Integer.compare(p1.getFirst(), p2.getFirst());
            }
        }
    }

}
