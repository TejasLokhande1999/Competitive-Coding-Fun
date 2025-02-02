class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int nums[] = new int[n];

        Arrays.fill(nums,1);

        if(n==1){
            return 1;
        }
        for(int i=1;i<n;i++){
            if(ratings[i]>ratings[i-1]){
                nums[i] = nums[i-1]+1;
            }
        }

        for(int i=n-2;i>=0;i--){
            if(ratings[i]>ratings[i+1]){
                if(nums[i]<=nums[i+1]){
                    nums[i] = nums[i+1]+1;
                }
            }
        }

        int sum = 0;
        for(Integer i : nums){
            sum+=i;
        }

        return sum;
    }
}


    //  1 2 3 4 5
    //  1 2 3 4 5

    //  5 4 3 2 1
    //  5 4 3 2 1

    //  1 2 3 4 5 2 1 2 3
    //  1 2 3 4 5 3 2 4 5

        // 1 1 2
        // 1 0 2

        // 1 1 1. 1. 1. 1 1  
        // 1 2 87 87 87 2 1   