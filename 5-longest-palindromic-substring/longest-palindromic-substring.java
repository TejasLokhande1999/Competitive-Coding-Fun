class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        String res = "";
        int len =0;

        for(int i=0;i<s.length();i++){
            int l,r;
            

                l=i;
                r=i;


            while(l>=0 && r<n && s.charAt(l)==s.charAt(r)){
                
                if(r-l+1>len){
                    len = r-l+1;
                    res = s.substring(l,r+1);
                }

                l--;
                r++;
            }

               l = i;
                r=l+1;
             while(l>=0 && r<n && s.charAt(l)==s.charAt(r)){
                
                if(r-l+1>len){
                    len = r-l+1;
                    res = s.substring(l,r+1);
                }

                l--;
                r++;
            }

        }
        return res;
    }
}
