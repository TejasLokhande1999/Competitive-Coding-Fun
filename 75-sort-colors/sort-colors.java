class Solution {
    public void sortColors(int[] nums) {
        
        int zero =0;
        int one = 0;
        int two=0;

        for(int i=0;i<nums.length;i++){

            if(nums[i]!=0){
                //find the first zero

                for(int j=i;j<nums.length;j++){
                    if(nums[j]==0){
                        //swap
                        int temp = nums[j];
                        nums[j] = nums[i];
                        nums[i] = temp;
                        break;
                    }
                }
            }

        }

        int zeroIndex = 0;

        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                zeroIndex=i;
                break;
            }
        }

        for(int i=zeroIndex;i<nums.length;i++){
             if(nums[i]!=1){
                //find the first zero

                for(int j=i;j<nums.length;j++){
                    if(nums[j]==1){
                        //swap
                        int temp = nums[j];
                        nums[j] = nums[i];
                        nums[i] = temp;
                        break;
                    }
                }
            }

        }
    }
}