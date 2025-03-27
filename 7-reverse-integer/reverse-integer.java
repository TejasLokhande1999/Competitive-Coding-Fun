class Solution {
    public int reverse(int num) {

        int rev = 0;
        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;
        
        while(num!=0){

            int mod = num%10;
            num=num/10;
            if(rev>max/10 || rev<min/10){
                return 0;
            }

            rev = rev*10 + mod;
        }

        return rev;

    }
}