class Solution {
    public int reverse(int num) {
        
        int rev = 0;

        while(num!=0){

            int mod = num%10;
            num = num/10;
            if((rev>Integer.MAX_VALUE/10) || (rev<Integer.MIN_VALUE/10)){
                return 0;
            }
            rev = (rev*10)+mod;

        }


        return rev;

    }
}