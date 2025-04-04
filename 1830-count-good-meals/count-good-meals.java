class Solution {
    public int countPairs(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        

        int MOD = 1000000007;

        long count=0;
        for(int i=0;i<nums.length;i++){


            for(int j=0;j<=21;j++){

                int powOfTwo =(int) Math.pow(2,j);

                int ans = powOfTwo-nums[i];

                count+=map.getOrDefault(ans,0);


            }
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);

        }
        count = count%MOD;

        return (int)count;

    }
}