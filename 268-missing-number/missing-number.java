class Solution {
    public int missingNumber(int[] nums) {

    Set<Integer> set = new HashSet<Integer>();

    for(int i=0;i<nums.length;i++){
        set.add(nums[i]);
    }

    int[] temp = new int[nums.length+1];

    for(int i=0;i<=nums.length;i++){
        temp[i] = i;
    }

    for(int i=0;i<temp.length;i++){
        if(!set.contains(temp[i]))
            return temp[i];
    }


    return 0;


    }

}