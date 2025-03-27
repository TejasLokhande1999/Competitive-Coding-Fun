class Solution {
    public String intToRoman(int num) {
        
        int numArr[] = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String romanArr[] = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

        String str="";
        int n = numArr.length;
        while(num!=0){
            for(int i=0;i<n;i++){
                if(num-numArr[i]>=0){
                    num=num-numArr[i];
                    str+=romanArr[i];
                    break;
                }
            }
        }

        return str;
    }
}