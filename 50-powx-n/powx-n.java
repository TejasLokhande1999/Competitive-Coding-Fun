class Solution {
    public double myPow(double x, int n) {
        if(x==0) return 0;
        if(n==0) return 1;

        double res = recurse(x,Math.abs((long) n));

        if(n>=0) return res;

        return 1/res;
    }

    public double recurse(double x, long n){
        if(n==0){
            return 1;
        }
        double res = recurse(x,n/2);

        if(n%2==1){
            return x*res*res;
        }
        return res*res;

    }
}