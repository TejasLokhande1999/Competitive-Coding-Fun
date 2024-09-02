class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k=k%n;
        // for(int i=0;i<k;i++){
        //     int saved = nums[n-1];
        //     for(int j=n-1;j>=1;j--){
        //         nums[j]=nums[j-1];
        //     }
        //     nums[0]=saved;
        // }
        
        reverse(0,n-1,nums);
        reverse(0,k-1,nums);
        reverse(k,n-1,nums);
    }

    public void reverse(int start, int end, int arr[])
    {

        while(start<end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }

    }
}