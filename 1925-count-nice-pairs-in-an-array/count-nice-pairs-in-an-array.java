class Solution {
    public int countNicePairs(int[] nums) {
        
        int n = nums.length;
        int revNums [] = new int[n];

        for(int i=0;i<n;i++){
            revNums[i] = reverse(nums[i]);
        }


        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0;i<n;i++){
            int val = nums[i]-revNums[i];
            map.put(val,map.getOrDefault(val,0)+1);
        }

        int mod = 1_000_000_007;
        long retVal = 0;

        for(Map.Entry<Integer, Integer> entry : map.entrySet()){

            long count = (long) entry.getValue();

            long val = (count*(count-1))/2;
            retVal = (retVal+val)%mod;
        }

        return (int) retVal;


    }

    public int reverse(int no) {
    int rev = 0;
    while (no > 0) {
        rev = rev * 10 + (no % 10);
        no /= 10;
    }
    return rev;
}
}