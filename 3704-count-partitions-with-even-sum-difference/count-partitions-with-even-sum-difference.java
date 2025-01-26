class Solution {
    public int countPartitions(int[] nums) {
        int part1=0;
        int part2=0;
        int total =0;
        for(int i=0;i<nums.length;i++){
            total+= nums[i];
        }

        int count=0;

        for(int i=0;i<nums.length-1;i++){
            part1+=nums[i];
            part2 = total - part1;
            int diff = Math.abs(part1-part2);

            if(diff%2==0){
                count++;
            }
        }

        return count;
    }
}