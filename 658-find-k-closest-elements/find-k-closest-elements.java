class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n = arr.length;
        int diff[] = new int[n];


        PriorityQueue<Pair> pq = new PriorityQueue<>(new PairComparator());
        for(int i=0;i<n;i++){
            diff[i] = Math.abs(arr[i]-x);
            pq.add(new Pair(arr[i],diff[i]));
            if(pq.size()>k){
                pq.poll();
            }
        }

        List<Integer> list = new ArrayList<>();

        while(!pq.isEmpty()){
            list.add(0,pq.poll().ele);
        }
        Collections.sort(list);
        return list;
    }
}

class Pair{

    int ele;
    int diff;

    Pair(int ele, int diff){
        this.ele = ele;
        this.diff = diff;
    }

}


//sprting in descinding order

class PairComparator implements Comparator<Pair>{

    public int compare(Pair p1, Pair p2){

        if(p1.diff<p2.diff){
            return 1;
        }else if(p1.diff>p2.diff){
            return -1;
        }else{

                if(p1.ele<p2.ele){
                    return 1;
                }else if(p1.ele>p2.ele){
                    return -1;
                }else{
                    return 0;
                }

        }

    }

}


//     k=4;
//     x=3

//   1  2   3   4   5
//   2  1.   0.  1.  2