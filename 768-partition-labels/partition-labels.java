class Solution {
    public List<Integer> partitionLabels(String s) {
        
        List<Integer> list =new ArrayList<>();

        Map<Character, Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            map.put(ch,i);
        }

        int size=0;

        int end = 0;
        for(int i=0;i<s.length();i++){
            size+=1;
            char ch = s.charAt(i);
            int lastIndexOfCh = map.get(ch);
            end = Math.max(end,lastIndexOfCh);

            if(i==end){
                list.add(size);
                size =0;
            }

        }
        

        return list;

    }
}