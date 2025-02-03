class Solution {
    public String longestDiverseString(int a, int b, int c) {


        //store in descending prder or freq
        PriorityQueue<Pair> pq = new PriorityQueue<>((x,y)->y.freq-x.freq);

        StringBuilder str = new StringBuilder();

       
        if (a > 0) pq.add(new Pair('a', a));
        if (b > 0) pq.add(new Pair('b', b));
        if (c > 0) pq.add(new Pair('c', c));


        while(!pq.isEmpty()){
            Pair first = pq.poll();

            if(str.length()>=2 && str.charAt(str.length()-1)==first.ch && str.charAt(str.length()-2)==first.ch){

                if(pq.isEmpty()){
                    break;
                }
                Pair second = pq.poll();

                str.append(second.ch);
                if(second.freq-1>0){
                    pq.add(new Pair(second.ch, second.freq-1));
                }
                pq.add(first);
            }else{

                str.append(first.ch);
                if(first.freq-1>0){
                    pq.add(new Pair(first.ch,first.freq-1));
                }


            }

            
        }



        

        return str.toString();

    }
}

class Pair{
    char ch;
    int freq;
    Pair(char ch, int freq){
        this.ch = ch;
        this.freq = freq;
    }
}