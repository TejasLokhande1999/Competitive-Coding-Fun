class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);

        List<List<Integer>> res = new ArrayList<>();

        List<Integer> curr = new ArrayList<>();

        backtrack(0,candidates,res,curr,target);

        return res;
    }

    public void backtrack(int index, int[] candidates, List<List<Integer>> res, List<Integer> curr, int target){

        if(target<0)
            return;
        
        if(target==0){
            res.add(new ArrayList<>(curr));
        }

        for(int i=index; i<candidates.length;i++){
            curr.add(candidates[i]);
            backtrack(i,candidates,res,curr,target-candidates[i]);
            curr.remove(curr.size()-1);
        }

        

    }
}