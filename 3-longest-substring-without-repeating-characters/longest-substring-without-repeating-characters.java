class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s==" "){
            return 0;
        }
        int n = s.length();
        int maxLen = 0;
        int i=0,j=0;
        Map<Character,Integer> map = new HashMap<>();

        while(j<n){
        
        char ch = s.charAt(j);

        map.put(ch,map.getOrDefault(ch,0)+1);
        int len = j-i+1;
        if(len==map.size()){
            maxLen = Math.max(len,maxLen);
        }else{

            while(j-i+1>map.size()){
                char ch2 = s.charAt(i);
                map.put(ch2,map.getOrDefault(ch2,0)-1);
                if(map.get(ch2)==0){
                    map.remove(ch2);
                }
                i++;
            }

        }
        j++;

    }

    return maxLen;
    }
}