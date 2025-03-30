class Solution {
    public String countAndSay(int n) {

        if(n==1){
            return "1";
        }
        return RLE(countAndSay(n-1));
    }


    public String RLE(String str){

        if(str.length()==1){

            return "1"+String.valueOf(str.charAt(0));
        }

        int i=0;
        int j=0;
        int n = str.length();
        int len = 0;
        String finalStr = "";
        while(j<n){

            if(str.charAt(i)==str.charAt(j)){
                j++;
            }else{

                len = j-i;
                finalStr+=String.valueOf(len)+String.valueOf(str.charAt(i));
                i=j;
            }

        }

        len = j-i;
        finalStr+=String.valueOf(len)+String.valueOf(str.charAt(i));

        return finalStr;

    }
}