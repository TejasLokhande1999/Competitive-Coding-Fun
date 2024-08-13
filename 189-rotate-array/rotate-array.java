class Solution {
    public void rotate(int[] nums, int k) {
        
        //Approach 1 TLE

        // int n = nums.length;
        // k=k%n;
        // for(int i=0;i<k;i++){

        //     int last = nums[n-1];
        //     int temp=nums[0];
        //     int temp2;
        //     for(int j=1;j<nums.length;j++){

        //         temp2 = nums[j];
        //         nums[j]=temp;
        //         temp = temp2;

        //     }
        //     nums[0] = last;

        // }


        int n = nums.length;
        k=k%n;
        if(n==1){
            return;
        }
        reverse(0,n-k-1,nums);
        reverse(n-k,n-1,nums);
        reverse(0,n-1,nums);
        //reverse(0,k-1,nums);
        //reverse(k,n-1,nums);

    }

    public void reverse(int start, int end, int[] nums){

            while(start<end){
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
                start++;
                end--;
            }

        }
}