class Solution {
    public void moveZeroes(int[] nums) {
        

        int arr2[] = new int[nums.length];

        int index=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                arr2[index] = nums[i];
                index++;
            }
        }

        for(int i=index;i<arr2.length;i++){
            arr2[i] = 0;
        }

        for(int i=0;i<nums.length;i++){
            nums[i] = arr2[i];
        }
    }
}