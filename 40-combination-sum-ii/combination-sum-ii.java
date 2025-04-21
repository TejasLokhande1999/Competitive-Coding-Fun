class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);

        Set<String> set = new HashSet<>();
        List<List<Integer>> res = new ArrayList<>();

        List<Integer> curr = new ArrayList<>();

        backtrack(0,candidates,res,curr,target,set);

        return res;
    }

    public void backtrack(int index, int[] candidates, List<List<Integer>> res, List<Integer> curr, int target, Set<String> set){

        if(target<0)
            return;
        
        if(target==0){
            //String key = curr.toString();

            //if(!set.contains(key)){
                res.add(new ArrayList<>(curr));
            //    set.add(key);
          //  }

            return;
                
        }


        for(int i=index; i<candidates.length;i++){

            if(i>index && candidates[i]==candidates[i-1]) continue;

            curr.add(candidates[i]);
            backtrack(i+1,candidates,res,curr,target-candidates[i],set);
            curr.remove(curr.size()-1);
        }

        

    }
}