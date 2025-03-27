class Solution {
    public List<String> findRepeatedDnaSequences(String s) {

     Map<String, Boolean> map = new HashMap<>();

        List<String> list = new ArrayList<>();
        if(s.length()<10){
            return list;
        }

        for(int i=0;i<=s.length()-10;i++){
            String subStr = s.substring(i,i+10);

            if(map.containsKey(subStr)){
                map.put(subStr,true);
            }else{
                map.put(subStr,false);
            }
        }


        for(Map.Entry<String,Boolean> entry : map.entrySet()){
            String key = entry.getKey();
            boolean val = entry.getValue();

            if(val){
                list.add(key);
            }
        }   

        return list;
    }
}