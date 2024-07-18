class Solution {
    public void nextPermutation(int[] nums) {
        
        int index = -1;
        int n = nums.length;
        for(int i=n-2;i>=0;i--){
            if(nums[i]<nums[i+1]){  //we find a dip
                index =i;
                break;
            }
        }

        if(index==-1){//No dip found, so just reverse the array & return
            reverse(nums,0,n-1);
        }else{

            for(int i=n-1;i>=0;i--){        //Find element which is just greater than the arr[index] and then swap
                if(nums[i]>nums[index]){
                    //swap
                    int temp = nums[index];
                    nums[index] = nums[i];
                    nums[i] = temp;

                    reverse(nums,index+1,n-1);
                    break;
                }
            }



        }

    }

    public int[] reverse(int nums[], int start, int end){
        int temp;
        
        while(start<end){

            temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }


        return nums;

    }
}