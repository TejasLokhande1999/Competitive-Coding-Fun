class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Map<String,Integer> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        for(int i=0;i<=s.length()-10;i++){
            String str= s.substring(i,i+10);
            if(map.containsKey(str)){
                if(map.get(str)==1){
                    //now update
                    list.add(str);
                }
                map.put(str,map.getOrDefault(str,0)+1);
            }else{
                map.put(str,1);
            }

        }
        return list;
    }
}