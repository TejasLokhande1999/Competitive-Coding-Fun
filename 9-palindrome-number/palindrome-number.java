class Solution {
    public boolean isPalindrome(int x) {
        String str = String.valueOf(x);

        for(int i=0;i<str.length();i++){
            if(i==str.length()/2){
                return true;
            }else{
                if(str.charAt(i)==str.charAt(str.length()-1-i)){
                    continue;
                }else{
                    return false;
                }
            }
        }

        return true;
    }
}