class Solution {
    public boolean canPlaceFlowers(int[] nums, int n) {
        int length = nums.length+2;

        int f[] = new int[length];

        for(int i=1;i<length-1;i++){
            f[i] = nums[i-1];
        }

        for(int i=1;i<length-1;i++){
            if(f[i-1]==0 && f[i]==0 && f[i+1]==0){
                f[i]=1;
                n--;
            }
        }

        if(n<=0){
            return true;
        }
        return false;
    }
}