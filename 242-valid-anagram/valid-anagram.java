class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();

        int m = s.length();
        int n = t.length();

        for(int i=0;i<m;i++){
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch,0)+1);
        }

         for(int i=0;i<n;i++){
            char ch = t.charAt(i);
            map.put(ch, map.getOrDefault(ch,0)-1);
            if(map.get(ch)==0){
                map.remove(ch);
            }
        }

        if(map.isEmpty())
            return true;
        return false;

    }
}