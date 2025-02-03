class Solution {
    public int leastInterval(char[] tasks, int n) {

        Map<Character, Integer> map = new HashMap<>();
        for(int i=0;i<tasks.length;i++){
            char ch = tasks[i];

            map.put(ch, map.getOrDefault(ch,0)+1);
        }


        //max heap, we are sprting by freq
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)-> b.freq - a.freq);

        for(Map.Entry<Character, Integer> entry : map.entrySet()){
            int freq = entry.getValue();
            pq.add(new Pair(freq,0));
        }


        int time = 0;
        Queue<Pair> q = new LinkedList<>();

        
        while (!pq.isEmpty() || !q.isEmpty()) {
            time++; 

            if (!pq.isEmpty()) {
                Pair p = pq.poll();
                if (p.freq - 1 > 0) { 
                    q.add(new Pair(p.freq - 1, time + n));
                }
            }

            if (!q.isEmpty() && q.peek().time <= time) {
                pq.add(q.poll());
            }
        }
        return time;

    }
}

class Pair{

    int freq;
    int time;

    Pair(int freq, int time){
        this.freq = freq;
        this.time = time;
    }
}