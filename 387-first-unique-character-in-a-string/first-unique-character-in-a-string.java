class Solution {
    public int firstUniqChar(String s) {
        Queue<Pair> q = new LinkedList<>();
        Map<Character,Integer> map = new HashMap<>();

        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            q.add(new Pair(ch,i));
            map.put(ch, map.getOrDefault(ch,0)+1);
        }

        while(!q.isEmpty()){

            Pair p = q.poll();
            char ch = p.ch;
            int index = p.index;

            int freq = map.get(ch);
            if(freq==1)
                return index;
            
        }

        return -1;

    }
}
class Pair{
    char ch;
    int index;
    Pair(char ch, int index){
        this.ch = ch;
        this.index = index;
    }
}