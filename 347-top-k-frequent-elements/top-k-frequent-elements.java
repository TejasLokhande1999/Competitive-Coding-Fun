class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0;i<nums.length;i++){
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)-> a.freq - b.freq);

        for(Map.Entry<Integer, Integer> entry : map.entrySet()){

            int key = entry.getKey();
            int freq = entry.getValue();

            pq.add(new Pair(key,freq));

            if(pq.size()>k){
                pq.poll();
            }

        }

        int retArr[] = new int[pq.size()];
        int i=0;
        while(!pq.isEmpty()){
        retArr[i] = pq.poll().key;
        i++;
        }

        return retArr;
    }
}

class Pair{

    int key;
    int freq;

    Pair(int key , int freq){
        this.key = key;
        this.freq = freq;
    }

}



//sort in ascending order
class PairComparator implements Comparator<Pair>
{

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