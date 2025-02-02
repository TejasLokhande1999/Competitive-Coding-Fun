class Solution {
    public int jump(int[] nums) {
        
        int n = nums.length;

        int res = 0;

        int l =0;
        int r=0;

        while(r<n-1){
            int maxWidth = 0;
            for(int i=l;i<=r;i++){
                maxWidth = Math.max(i+nums[i],maxWidth);
            }

            res+=1;
            l = r+1;
            r = maxWidth;

        }

        return res;

    }


}