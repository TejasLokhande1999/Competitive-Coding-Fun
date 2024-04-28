class Solution {
    public String longestCommonPrefix(String[] strs) {
        
        String minStr = strs[0];

        for(int i=0;i<strs.length;i++){
            if(strs[i].length()<minStr.length()){
                minStr = strs[i];
            }
        }


    //we get the minimumn string
    // Now build a new String based on each character of this minString in the array

    String retStr="";

    char ch;
    for(int i=0;i<minStr.length();i++){
        ch = minStr.charAt(i);
        if(checkCharAtIndex(ch,i,strs)){
            retStr+=ch;
        }else{
            return retStr;
        }
    }

    return retStr;


    }

    public boolean checkCharAtIndex(char ch, int index, String arr[]){
        String str="";
        for(int i=0;i<arr.length;i++){
            str= arr[i];
            if(str.charAt(index)==ch){
                continue;
            }else{
                return false;
            }
        }

        return true;

    }
}