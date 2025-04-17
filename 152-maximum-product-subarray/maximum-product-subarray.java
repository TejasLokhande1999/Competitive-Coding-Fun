class Solution {
    public int maxProduct(int[] nums) {

     int n = nums.length;
     int prefix = 1;
     int suffix=1;
     int ans = Integer.MIN_VALUE;

     for(int i=0;i<n;i++){

        if(prefix==0){
            prefix=1;
        }
        prefix = prefix*nums[i];

        ans = Math.max(ans,prefix);
        
     }

     for(int i=n-1;i>=0;i--){

        if(suffix==0){
            suffix=1;
        }
        suffix = suffix*nums[i];

        ans = Math.max(ans,suffix);
        
     }

     return ans;

     

    }
}