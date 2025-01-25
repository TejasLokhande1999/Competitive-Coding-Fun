class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        int n= s.length();
        Map<String, Boolean> map = new HashMap<>();
        for(int i=0;i<=n-10;i++){
            String str = s.substring(i,i+10);
            if(!map.containsKey(str)){
                map.put(str,false);
            }else{
                map.put(str,true);
            }            

        }

        List<String> list = new ArrayList<>();

        for(Map.Entry<String,Boolean> entry : map.entrySet()){
            boolean flag = entry.getValue();
            String key = entry.getKey();
            if(flag){
                list.add(key);
            }
        }

        return list;


    }
}