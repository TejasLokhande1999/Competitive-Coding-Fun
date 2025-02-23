class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0;i<nums.length;i++){

            int num = nums[i];

            if(map.containsKey(target-num)){
                int retArr[] = new int[2];
                retArr[0] = i;
                retArr[1] = map.get(target-num);
                return retArr;
            }
            map.put(num,i);

        }

        return new int[2];


    }
}