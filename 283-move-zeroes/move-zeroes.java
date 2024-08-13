class Solution {
    public void moveZeroes(int[] nums) {
        
        //Brute force

        // int arr2[] = new int[nums.length];

        // int index=0;
        // for(int i=0;i<nums.length;i++){
        //     if(nums[i]!=0){
        //         arr2[index] = nums[i];
        //         index++;
        //     }
        // }

        // for(int i=index;i<arr2.length;i++){
        //     arr2[i] = 0;
        // }

        // for(int i=0;i<nums.length;i++){
        //     nums[i] = arr2[i];
        // }


    //2 pointer approach

    
        
    int i=-1;

    if(nums.length==1){
        return;
    }

    for(int j=0;j<nums.length;j++){
        if(nums[j]==0){
            i=j;
            break;
        }
    }

    if(i==-1){
        return;
    }

    for(int j=i+1;j<nums.length;j++){
        if(nums[j]!=0){
            //swap
            int temp = nums[j];
            nums[j]= nums[i];
            nums[i] = temp;
            i++;
        }
    }

    }
}