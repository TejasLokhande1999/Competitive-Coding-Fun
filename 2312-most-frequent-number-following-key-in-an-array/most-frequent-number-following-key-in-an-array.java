class Solution {
    public int mostFrequent(int[] nums, int key) {
        
        int n = nums.length;

        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0;i<n-1;i++){
            if(nums[i]==key){
                int target = nums[i+1];
                map.put(target, map.getOrDefault(target,0)+1);
            }
        }

        int maxFreq = -1;
        int val = 0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){

            int freq = entry.getValue();
            if(freq>maxFreq){
                
                maxFreq = freq;
                val = entry.getKey();

            }
        }  

        return val;

    }
}