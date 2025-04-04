class Solution {
    public boolean canMeasureWater(int x, int y, int target) {
        
        if(x+y<target){
            return false;

        }
        int gcd = gcd(x,y);
        System.out.println(gcd);
        if(target%gcd==0)
            return true;
        

        return false;
    }

    public int gcd(int num1, int num2){

        int no = Math.min(num1,num2);

        for(int i=no;i>=2;i--){

            if(num1%i==0 && num2%i==0){
                return i;
            }

        }

        return 1;


    }
}