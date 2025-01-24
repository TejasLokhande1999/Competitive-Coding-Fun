class Solution {
    public int reverse(int x) {
        boolean isNeg = false;

        String str = String.valueOf(x);

        if(str.charAt(0)=='-'){
            isNeg = true;
            str = str.substring(1,str.length());
        }

        String retStr = "";

        int n = str.length();
        for(int i=0;i<n;i++){
            retStr += str.charAt(n-i-1);
        }   
        

        long retNum = 0;
        retNum = Long.parseLong(retStr);
        if(isNeg){
            retNum = -retNum;
        }

        if(retNum>Integer.MAX_VALUE || retNum<Integer.MIN_VALUE){
            return -0;
        }

        return (int) retNum;



    }
}