class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums.length==1){
            return 1;
        }

        List<Integer> temp = new ArrayList<>();

        temp.add(nums[0]);
        for(int i=1;i<nums.length;i++){
            if(nums[i]> temp.get(temp.size()-1)){
                temp.add(nums[i]);
            }else{

                //get the index of element just greater that number
                int index = binSearch(temp,nums[i]);
                temp.set(index,nums[i]);
            }
        }


        return temp.size();
    }

    public int binSearch(List<Integer> list, int ele){

        int l = 0;
        int n = list.size();
        int r = n-1;
        int index=-1;

        while(l<=r){
            int mid = l + (r-l)/2;

            if(list.get(mid)==ele){
                return mid;
            }else if(list.get(mid)<ele){
                l = mid+1;
            }else{
                index = mid;
                r = mid-1;
            }
    }

    return index;

    }
}