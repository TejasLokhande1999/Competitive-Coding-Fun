class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);

        int max1 = 1;
        int max2=1;


        for(int i=0;i<2;i++){
            max1*=nums[i];
        }
        max1*=nums[nums.length-1];
        for(int i=nums.length-1; i>=nums.length-3;i--){
            max2*=nums[i];
        }

        return Math.max(max1,max2);
    }
}