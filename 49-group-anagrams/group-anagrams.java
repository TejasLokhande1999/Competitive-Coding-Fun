class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for(String str : strs){
            char arr [] = str.toCharArray();

            int count[] = new int[26];
            for(int i=0;i<arr.length;i++){
                char ch = arr[i];
                count[ch-'a']+=1;
            }

            String mapStr = Arrays.toString(count);
            if(!map.containsKey(mapStr)){
                map.put(mapStr, new ArrayList<>());
            }

            map.get(mapStr).add(str);
        }
        List<List<String>> retList = new ArrayList<>();

        for(Map.Entry<String, List<String>> entry : map.entrySet()){    
        retList.add(entry.getValue());

        }

        return retList;
    }
}