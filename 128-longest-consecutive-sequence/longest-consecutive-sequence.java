class Solution {
    int max = 0;
    public int longestConsecutive(int[] nums) {

    Set<Integer> set = new HashSet<>();

    for(int i=0;i<nums.length;i++){
        set.add(nums[i]);
    }

    Iterator<Integer> itr = set.iterator();

    while(itr.hasNext()){
        int val = itr.next();
        if(set.contains(val-1)){
            //means that it's not the start of sequence
            continue;
        }else{
            calculate(set,val);
        }
    }

    return max;

    }

    public void calculate(Set<Integer> set, int ele){
        int count=0;

        while(set.contains(ele)){
            count+=1;
            max = Math.max(count,max);
            ele+=1;
        }
    }
}