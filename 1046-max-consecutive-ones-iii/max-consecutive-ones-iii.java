class Solution {
    public int longestOnes(int[] nums, int k) {
        
        int i=0;
        int j=0;
        int maxLen = 0;
        int n = nums.length;
        int countZero = 0;

        while(j<n){

            if(nums[j]==1){
                maxLen = Math.max(maxLen,j-i+1);
            }else{

                countZero+=1;

                if(countZero<=k){
                    maxLen = Math.max(maxLen,j-i+1);
                }else{

                    while(countZero>k){
                        if(nums[i]==0){
                            countZero--;
                        }
                        i++;
                    }
                }
            }
            j++;



        }

                    return maxLen;

    }
}