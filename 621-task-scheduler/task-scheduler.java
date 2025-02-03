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
            char ch = entry.getKey();
            int freq = entry.getValue();
            pq.add(new Pair(ch,freq,0));
        }


        int time = 0;
        Queue<Pair> q = new LinkedList<>();

        
        while (!pq.isEmpty() || !q.isEmpty()) {
            time++;  // Each iteration represents one unit of time

            // Step 4: If a task is ready to be executed
            if (!pq.isEmpty()) {
                Pair p = pq.poll();
                if (p.freq - 1 > 0) { // Only add back if tasks remain
                    q.add(new Pair(p.ch, p.freq - 1, time + n));
                }
            }

            // Step 5: Check if any task in the queue is ready to be re-added
            if (!q.isEmpty() && q.peek().time <= time) {
                pq.add(q.poll());
            }
        }
        return time;

    }
}

class Pair{

    char ch;
    int freq;
    int time;

    Pair(char ch, int freq, int time){
        this.ch = ch;
        this.freq = freq;
        this.time = time;
    }
}