class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        int n = strs.length;

        for(int i=0;i<strs.length;i++){
            String str = strs[i];
            int arr[] = new int[26];

            for(int j=0;j<str.length();j++){
                char ch = str.charAt(j);
                arr[ch-'a']+=1;
            }
            String key = Arrays.toString(arr);
            System.out.println(key);
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(str);
        }

        List<List<String>> retList = new ArrayList<>();
        for(Map.Entry<String, List<String>> entry : map.entrySet()){
            String key = entry.getKey();
            List<String> value = entry.getValue();
            retList.add(value);

        }

        return retList;
    }
}