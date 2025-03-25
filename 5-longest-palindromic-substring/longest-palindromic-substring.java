class Solution {
    public String longestPalindrome(String s) {
        
        int maxLen = 0;
        String maxStr="";
        int n = s.length();
        int l = 0;
        int r = 0;
        for(int i=0;i<n;i++){
            l = i;
            r = i;
            while(l>=0 && r<n && s.charAt(l) == s.charAt(r)){
                if(r-l+1>maxLen){
                    maxLen = Math.max(maxLen,r-l+1);
                    maxStr = s.substring(l,r+1);
                }
                l--;
                r++;
            }

            //for even length
            l = i;
            r = i+1;

            while(l>=0 && r<n && s.charAt(l) == s.charAt(r)){
                if(r-l+1>maxLen){
                    maxLen = Math.max(maxLen,r-l+1);
                    maxStr = s.substring(l,r+1);
                }
                l--;
                r++;
            }

        }

        return maxStr;
    }
}