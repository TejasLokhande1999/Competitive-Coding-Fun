class Solution {
    public List<List<Integer>> subsets(int[] nums) {

     List<List<Integer>> res = new ArrayList<>();
     List<Integer> list = new ArrayList<>();

     dfs(res,list,nums,0);

     return res;

    }

    public void dfs(List<List<Integer>> res, List<Integer> list, int nums[], int index){

        if(index==nums.length){
            res.add(new ArrayList<>(list));
        }else{

            list.add(nums[index]);

            dfs(res,list,nums,index+1);

            list.remove(list.size()-1);

            dfs(res,list,nums,index+1);

        }

    }
}