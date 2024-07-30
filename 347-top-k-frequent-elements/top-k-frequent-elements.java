class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<Integer,Integer>();


        for(int i=0;i<nums.length;i++){
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
        }

        //We have generated a map

        PriorityQueue<Pair> pq = new PriorityQueue<Pair>(new PairComparator());

        for(Map.Entry<Integer,Integer> entry : map.entrySet()){

            pq.add(new Pair(entry.getValue(),entry.getKey()));

            if(pq.size()>k){
                pq.poll();
            }
        }

        int arr[] = new int [k];

        int i=0;
        while(!pq.isEmpty()){
            arr[i] = pq.poll().ele; 
            i++;
        }

        return arr;

    }

}

class Pair{
    int freq;
    int ele;
    Pair(int freq, int ele){
        this.freq = freq;
        this.ele=ele;
    }
}

class PairComparator implements Comparator<Pair>{

    public int compare(Pair p1, Pair p2){

        if(p1.freq>p2.freq){
            return 1;
        }else if(p1.freq<p2.freq){
            return -1;
        }else{
            return 0;
        }

    }
}