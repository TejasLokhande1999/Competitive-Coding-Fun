class Solution {
    public String intToRoman(int num) {
        
        int values[] = {1000,900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

        String roman[] = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

        int n = values.length;
        String romanNo="";

        while(num>0){
            for(int i=0;i<n;i++){
                if(num>=values[i]){
                    num-=values[i];
                    romanNo+=roman[i];
                    break;
                }
            }
        }

        return romanNo;

    }
}