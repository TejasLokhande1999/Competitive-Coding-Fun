class Solution {
    public String reorganizeString(String s) {
        Map<Character,Integer> map = new HashMap<>();

        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }

    PriorityQueue<Pair> maxH = new PriorityQueue(new PairComparator());

    for(Map.Entry<Character,Integer> entry : map.entrySet()){
        maxH.add(new Pair(entry.getKey(),entry.getValue()));
    }
    int n = s.length();
    StringBuilder retStr = new StringBuilder();
    Pair prev = new Pair('#',-1);
    while(!maxH.isEmpty()){
        Pair current = maxH.poll();

        //current.ch;

        retStr.append(current.ch);
        current.freq--;

        if(prev.freq>0){
            maxH.add(prev);

        }
        prev = current;
 
    }

    if(retStr.length()==n)
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
