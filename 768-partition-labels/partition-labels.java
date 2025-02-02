class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            map.put(ch,i);
        }

        //we got the last index

        List<Integer> res = new ArrayList<>();
        int size = 0;
        int end = 0;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            int lastIndexOfCh = map.get(ch);
            end = Math.max(end,lastIndexOfCh);
            size+=1;
            if(i==end){
                res.add(size);
                size=0;
            }

        }

        return res;
    }
}