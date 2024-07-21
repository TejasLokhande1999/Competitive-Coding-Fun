class Solution {
    public boolean isPalindrome(String s) {
        
        String str = s.toLowerCase();

        String newStr = "";

        char charArr[] =str.toCharArray();

        for(int i=0;i<charArr.length;i++){
            if(Character.isLetterOrDigit(charArr[i])){
                newStr+=charArr[i];
            }
        }


        int n =newStr.length();

        for(int i=0;i<n/2;i++){
            if(newStr.charAt(i)==newStr.charAt(n-i-1))
                continue;
            else
                return false;
        }


        return true;
        
    }
}