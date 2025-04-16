class Solution {
    public double myPow(double x, int n) {
        
        if(x==0) return 0;
        if(n==0) return 1;

        double res = helper(x,Math.abs(n));

        if(n>=0){
            return res;
        }

        return 1/res;

    }

    public double helper(double x, int n){

        if(n==0){
            return 1;
        }

        double res = helper(x,n/2);     //get result of 2^5 and return res*res

        if(n%2==0)
            return res*res;
        
        return x*res*res;

    }
}