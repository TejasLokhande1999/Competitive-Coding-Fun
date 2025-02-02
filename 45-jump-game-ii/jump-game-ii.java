class Solution {
    public int jump(int[] nums) {
        int n = nums.length;

        int l =0;
        int r =0;
        int res=0;
        while(r<n-1){

            res++;
            int endpoint = 0;
            for(int i=l;i<=r;i++){
                endpoint = Math.max(endpoint,i + nums[i]);
            }

            l = r+1;
            r = endpoint;
        }


        return res;
    }
}