class Solution {
    public boolean canJump(int[] nums) {
       
     

    int n = nums.length; 

    int index =n-1;
    while(index>=0){
        boolean validEle = false;

        if(nums[index]==0&&index!=n-1){
            for(int i=index-1;i>=0;i--){
                if(nums[i]>=index-i+1){
                    index=i;

                    validEle = true;
                    break;
                }

            }
             if(validEle==false){
                return false;
             }
        }
        index--;

    }

    return true;


    }


}