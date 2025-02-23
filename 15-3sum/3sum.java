class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        Arrays.sort(nums);
        List<List<Integer>> retList = new ArrayList<>();

        int i =0;

        int n = nums.length;

        while(i<n-2){

            if(i>0&&nums[i]==nums[i-1]){
                i++;
                continue;
            } 

            int j = i+1;
            int k = n-1;

            while(j<k){
                int sum = nums[i]+nums[j]+nums[k];

                if(sum<0){
                    j++;
                }else if(sum>0){
                    k--;
                }else{

                    //sum==0

                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);

                    retList.add(list);

                    j++;
                    k--;

                    while(j<k && nums[j]==nums[j-1]) j++;
                    while(j<k && nums[k]==nums[k+1]) k--;

                }

            }

            i++;
            

        }

        return retList;

    }
}