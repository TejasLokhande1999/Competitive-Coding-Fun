class Solution {
    public int removeElement(int[] nums, int val) {
        int i=0;
        int j=0;
        int n = nums.length;

        while(i<n){
            if(nums[i]==val){
                j=i+1;
                while(j<n && nums[j]==val)
                {
                    j++;
                }
                if(j<n)
                {
                    int temp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = temp;
                }else{
                    break;
                }             
            }
            i++;
        }

        return i;
    }
}