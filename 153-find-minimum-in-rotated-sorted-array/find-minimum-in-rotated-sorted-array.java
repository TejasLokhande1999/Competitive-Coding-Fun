class Solution {
    public int findMin(int[] nums) {
        
        int n = nums.length;
        if(n==1){
            return nums[0];
        }

        if(nums[0]<nums[n-1]){
            return nums[0];
        }


        int l = 0;
        int r = n-1;
        while(l<=r){
            int mid = l+(r-l)/2;
            int ele = nums[mid];
            if(nums[l]<nums[r]){
                return nums[l];
            }
            if(ele<=nums[(mid-1+n)%n] && ele<=nums[(mid+1)%n]){
                return ele;
            }else if(nums[l]<=nums[mid]){
               //check if left protaion sorted, then move to right
               l = mid+1; 
            }else{
                r = mid-1;
            }
        }
        return 0;
    }
}