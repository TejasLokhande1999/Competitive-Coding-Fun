class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        ArrayList<Integer> list = new ArrayList<>();
        dfs(candidates, target, 0, list);
        return res;
    }

        public void dfs(int arr[], int target, int index, ArrayList<Integer> list){
            if(target==0){
                res.add(new ArrayList<>(list));
            }else if(target<0 || index ==arr.length){
                return;
            }else{
                list.add(arr[index]);
        
                dfs(arr,target-arr[index],index,list);

                list.remove(list.size()-1);

                dfs(arr,target,index+1,list);

            }
        }




}