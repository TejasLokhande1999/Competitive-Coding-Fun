class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        
        int i=0;
        int j=0;
        int n = s.length();
        int k = p.length();
        int freqS[] = new int[26];
        int freqP[] = new int[26];
        List<Integer> list = new ArrayList<>();

        for(char c : p.toCharArray()){
            freqP[c-'a']+=1;
        }
        while(j<n){
            char ch = s.charAt(j);
            freqS[ch-'a']+=1;

            if(j-i+1<k){
                j++;
            }else if(j-i+1==k){
                if(Arrays.equals(freqS,freqP)){ 
                    list.add(i);
                }
                char ch1 = s.charAt(i);
                freqS[ch1-'a']-=1;
                i++;
                j++;
            }
        }

        return list;
    }
}