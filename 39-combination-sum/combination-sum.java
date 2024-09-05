class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] arr, int target) {
        
        List<Integer> list = new ArrayList<>();
        dfs(target,arr,list,0);
        return res;
        
    }

    public void dfs(int target,int arr[], List<Integer> list, int index){

        if(target==0){
            res.add(new ArrayList<>(list));
        }else if(index==arr.length || target<0){
            return;
        }else{

            //I did not increment the index
            list.add(arr[index]);
            dfs(target-arr[index],arr,list,index);

            list.remove(list.size()-1);
            dfs(target,arr,list,index+1);
        }

    }
}