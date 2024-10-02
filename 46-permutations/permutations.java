class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        
        List<Integer> list = new ArrayList<>();
        boolean used[] = new boolean[nums.length];
        dfs(nums,list,used);
        return res;
    }

    public void dfs(int nums[], List<Integer> list, boolean used[]){
        if(list.size()==nums.length){
            res.add(new ArrayList<>(list));
            return;
        }else{
            
            for(int i=0;i<nums.length;i++){
                if(used[i]){
                    continue;
                }else{
                    used[i] = true;
                    list.add(nums[i]);
                    dfs(nums,list,used);

                    //backtracking step
                    used[i] = false;
                    list.remove(list.size()-1);

                }
            }

        }
    }
}