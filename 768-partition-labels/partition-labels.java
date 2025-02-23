class Solution {
    public List<Integer> partitionLabels(String s) {
        
        Map<Character, Integer> map = new HashMap<>();

        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            map.put(ch,i);
        
        }

        List<Integer> list = new ArrayList<>();
        int left=0;
        int right=0;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);

            int lastIndexOfCh = map.get(ch);
            right = Math.max(right,lastIndexOfCh);

            if(i==right){
                list.add(right-left+1);
                left=right+1;
            }
        }


        return list;

    }
}