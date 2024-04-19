class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.length()>haystack.length())
            return -1;
        else if(haystack.length()==needle.length()){
            if(haystack.equals(needle))
                return 0;
        }else{
            String str="";

            for(int i=0;i<haystack.length()-needle.length()+1;i++){
                str = haystack.substring(i,i+needle.length());
                if(str.equals(needle))  
                    return i;
            }

        }

        return -1;
    }
}