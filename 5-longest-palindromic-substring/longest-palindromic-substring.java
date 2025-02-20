class Solution {
    public String longestPalindrome(String s) {
        
        int maxLen = Integer.MIN_VALUE;
        String retstr = "";
        int n = s.length();

        for(int i=0;i<n;i++){

            int l = i;
            int r = i;

            while(l>=0 && r<n){

                if(s.charAt(l)==s.charAt(r)){
                    
                    if(r-l+1>maxLen){
                        maxLen = r-l+1;
                        retstr = s.substring(l,r+1);
                    }
                    l--;
                    r++;
                }else{
                    break;
                }


            }

            l=i;
            r=i+1;

            while(l>=0 && r<n){

                if(s.charAt(l)==s.charAt(r)){
                    
                    if(r-l+1>maxLen){
                        maxLen = r-l+1;
                        retstr = s.substring(l,r+1);
                    }
                    l--;
                    r++;
                }else{
                    break;
                }


            }


        }

        return retstr;

    }
}