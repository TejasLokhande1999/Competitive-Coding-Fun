class Solution {
    public String longestPalindrome(String s) {
        String subStr = "";
        int n = s.length();
        int maxLen = 0;
        for(int i=0;i<s.length();i++){

            //for odd
            int l = i;
            int r = i;
            while(l>=0 && r<n){

                if(s.charAt(l)==s.charAt(r)){
                    if(r-l+1>maxLen){
                        subStr = s.substring(l,r+1);
                        maxLen = r-l+1;
                    }
                    l--;
                    r++;
                }else{
                    break;
                }

            }



            //for evem
            l = i;
            r = i + 1;
            while (l >= 0 && r < s.length() && 
                   s.charAt(l) == s.charAt(r)) {
                if (r - l + 1 > maxLen) {
                    subStr = s.substring(l,r+1);
                    maxLen = r - l + 1;
                }
                l--;
                r++;
            }
        }

        return subStr;


    }
}