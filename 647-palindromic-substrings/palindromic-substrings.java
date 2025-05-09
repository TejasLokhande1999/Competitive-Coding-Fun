class Solution {
    public int countSubstrings(String s) {
        
        int n = s.length();
        int l=0;
        int r =0;
        int res = 0;



        for(int i=0;i<n;i++){

            l = i;
            r = i;

            while(l>=0 && r<n && s.charAt(l)==s.charAt(r)){
                    res++;
                    l--;
                    r++;
            }

            l=i;
            r=i+1;

            while(l>=0 && r<n && s.charAt(l)==s.charAt(r)){
                    res++;
                    l--;
                    r++;
            }

        }

        return res;
    }
}