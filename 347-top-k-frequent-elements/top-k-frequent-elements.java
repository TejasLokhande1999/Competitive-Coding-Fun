class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0;i<nums.length;i++){
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
        }
    
    Queue<Pair> pq = new PriorityQueue<>((a,b)-> a.freq - b.freq);

    for(Map.Entry<Integer, Integer>entry : map.entrySet()){
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
        retArr[i] = pq.poll().ele;
        i++;
    }

    return retArr;


    }
}

class Pair{
    int ele;
    int freq;
    Pair(int ele, int freq){
        this.ele = ele;
        this.freq = freq;
    }
}

