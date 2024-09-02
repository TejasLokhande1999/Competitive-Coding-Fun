class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int prefix[] = new int [n];
        int postfix[] = new int[n];

        prefix[0] = nums[0];
        for(int i=1;i<n;i++){
            prefix[i] = nums[i]*prefix[i-1];
        }

        postfix[n-1]=nums[n-1];
        for(int i=n-2;i>=0;i--){
            postfix[i] = nums[i]*postfix[i+1];
        }

        int op[] = new int[n];

        for(int i=0;i<n;i++){
            if(i==0){
                op[i] = 1*postfix[i+1];
            }else if(i==n-1){
                op[i] = prefix[i-1]*1;
            }else{
                op[i] = prefix[i-1]*postfix[i+1];
            }
        }

        return op;
    }
}