class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        dfs(res,list,nums,0);

        return res;
    }

    public void dfs(List<List<Integer>> res, List<Integer> list, int arr[], int index){

        if(index>=arr.length){
            res.add(new ArrayList<>(list));
        }else{

                    list.add(arr[index]);
        //Go to left, i.e. recurse here
        dfs(res,list,arr,index+1);

        //backtrack
        list.remove(list.size()-1);
        dfs(res,list,arr,index+1);

        }
    }

}