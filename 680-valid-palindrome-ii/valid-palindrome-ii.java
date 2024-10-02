class Solution {
    public boolean validPalindrome(String s) {
    /*    if(s.length()==1){
            return true;
        }else{

            int n = s.length();
            int start = 0;
            int end = n-1;

            while(start<end){
                if(s.charAt(start)==s.charAt(end)){
                    start++;
                    end--;
                }else{
                    
                    String s1 = s.substring(0,start)+s.substring(end,n);
                    String s2 = s.substring(0,start+1)+s.substring(end+1,n);

                    if(isPalin(s1)||isPalin(s2)){
                        return true;
                    }else{
                        return false;
                    }


                }
            }

            return true;
        }
*/

            if (s.length() == 1) {
            return true;
        }
        
        int start = 0;
        int end = s.length() - 1;

        while (start < end) {
            if (s.charAt(start) == s.charAt(end)) {
                start++;
                end--;
            } else {
                // If there's a mismatch, check by removing one character from either side
                return isPalin(s, start + 1, end) || isPalin(s, start, end - 1);
            }
        }

        return true;
        

    }

/*
    public boolean isPalin(String s){
        int n = s.length();
        int start = 0;
        int end = n-1;

        while(start<end){
            if(s.charAt(start)==s.charAt(end)){
                start++;
                end--;
            }else{
                return false;
            }
        }

        return true;
    }
    */
    public boolean isPalin(String s, int start, int end) {
        // Check if the substring from start to end is a palindrome
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}