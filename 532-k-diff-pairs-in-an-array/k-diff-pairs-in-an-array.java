class Solution {
    public int findPairs(int[] nums, int k) {
        
        if(k<0){
            return 0;
        }
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0;i<nums.length;i++){
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
        }

        //we get the frequency

        int count=0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){

            int key = entry.getKey();
            int req = key-k;
            if(k==0){
                if(entry.getValue()>=2)
                    count++;
            }else{
                if(map.containsKey(req))
                    count++;
            }

        }

        return count;

    }
}