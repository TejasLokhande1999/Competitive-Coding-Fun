class Solution {
    public boolean isIsomorphic(String s, String t) {
        
        return helper(s,t)&&helper(t,s);

    }

    public boolean helper(String s, String t){
        if(s.length()!=t.length()){
            return false;
        }

        Map<Character, Character> map =new HashMap<>();
        
        for(int i=0;i<s.length();i++){
            char ch1 = s.charAt(i);
            char ch2 = t.charAt(i);

            if(!map.containsKey(ch1)){
                map.put(ch1,ch2);
            }else{
                //map has the key
                char ch3 = map.get(ch1);
                if(ch3!=ch2){
                    return false;
                }
            }
        }

        return true;
    
    }
}