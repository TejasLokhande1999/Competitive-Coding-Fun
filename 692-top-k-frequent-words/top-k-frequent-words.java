class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();


        for(String word : words){   
            map.put(word,map.getOrDefault(word,0)+1);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->a.freq==b.freq ?
        b.str.compareTo(a.str) : a.freq-b.freq);

        for(Map.Entry<String, Integer> entry : map.entrySet()){

            pq.add(new Pair(entry.getKey(),entry.getValue()));

            if(pq.size()>k){
                pq.poll();
            }
        }

        List<String> retList = new LinkedList<>();

        while(!pq.isEmpty()){
            retList.addFirst(pq.poll().str);
        }

        return retList;


    }
}

class Pair{

    String str;
    int freq;

    Pair(String str, int freq){
        this.str = str;
        this.freq = freq;
    }
}