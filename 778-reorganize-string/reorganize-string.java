class Solution {
    public String reorganizeString(String s) {
        Map<Character,Integer> map = new HashMap<>();

        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }

    PriorityQueue<Pair> pq = new PriorityQueue(new PairComparator());

    for(Map.Entry<Character,Integer> entry : map.entrySet()){
        pq.add(new Pair(entry.getKey(),entry.getValue()));
    }
    int n = s.length();
    StringBuilder retStr = new StringBuilder();

    Pair prev = new Pair('#',-1);
    while(!pq.isEmpty()){
        Pair curr = pq.poll();

        // if(curr.ch==prev.ch){
        //     return "";
        // }
        // retStr.append(curr.ch);

        // if(prev.freq>0){
        //     pq.add(prev);
        // }
        // char ch = curr.ch;
        // map.put(ch,map.getOrDefault(ch,0)-1);
        // curr.freq=curr.freq-1;
        // prev = curr;
 // If the current character is the same as the previous, return empty string (impossible case)
            if (curr.ch == prev.ch && prev.freq > 0) {
                return "";
            }

            // Append current character to result
            retStr.append(curr.ch);

            // Reduce the frequency of the current character
            curr.freq--;

            // If previous character still has frequency, re-add it to the queue
            if (prev.freq > 0) {
                pq.add(prev);
            }

            // Update previous character to the current one
            prev = curr;



    }
    if(retStr.length()==s.length())
        return retStr.toString();

    return "";

    }

}

class Pair{
    Character ch;
    int freq;

    Pair(Character ch, int freq){
        this.ch = ch;
        this.freq=freq;
    }
}

class PairComparator implements Comparator<Pair>{

    public int compare(Pair p1, Pair p2){
        if(p1.freq>p2.freq){
            return -1;
        }else if(p1.freq<p2.freq){
            return 1;
        }else{
            return 0;
        }
    }

}