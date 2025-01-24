class Solution {
    public int longestConsecutive(int[] nums) {
        int maxLength = 0;
        Set<Integer> set = new HashSet<>();

        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }

        Iterator<Integer> itr = set.iterator();

        while(itr.hasNext()){
            int ele = itr.next();
            if(set.contains(ele-1)){
                //then it is not the start
                continue;
            }else{
                //it is the start. Cal the mas length
                int count = calc(set,ele);
                maxLength = Math.max(maxLength, count);

            }
        }

        return maxLength;
    }

    public int calc(Set<Integer> set, int ele){
        int count =0;
        while(set.contains(ele)){
            count+=1;
            ele+=1;
        }

        return count;

    }
}