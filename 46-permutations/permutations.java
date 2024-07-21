class Solution {
    public List<List<Integer>> permute(int[] nums) {
        
        List<List<Integer>> list = new ArrayList<>();

        permutations(0,nums.length,nums,list);

        return list;
    }

    public void permutations(int index, int n, int nums[], List<List<Integer>> list){

        if(index==n){       //WE reached the end
            ArrayList<Integer> temp = new ArrayList<Integer>();

            for(int i=0;i<nums.length;i++){
                temp.add(nums[i]);
            }   

            list.add(temp);

        }

        for(int i=index;i<n;i++){
            swap(index,i, nums);
            permutations(index+1,n,nums,list);
            swap(index,i,nums);
        }

    }

        public void swap(int i, int j, int nums[]){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
}