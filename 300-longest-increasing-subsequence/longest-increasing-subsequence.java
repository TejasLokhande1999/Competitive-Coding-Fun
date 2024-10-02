class Solution {
    public int lengthOfLIS(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        if(nums.length==1){
            return 1;
        }
        for(int i=0; i <nums.length;i++){
            int size = list.size();
            if(i==0){
                list.add(nums[i]);
            }else if(list.get(size-1)<nums[i]){
                    list.add(nums[i]);
            }else{
                
                int index = binarySearch(list,nums[i]);
                if(index==-1){
                    continue;
                }else{

                    int currEle = nums[i];
                    if(currEle<list.get(index));
                    list.set(index,currEle);
                }
            }


        }

        return list.size();


    }

    public int binarySearch(ArrayList<Integer> nums, int ele){
        int start = 0;
        int n = nums.size();
        int end = n-1;
        int index = -1;
        while(start<=end){

            int mid = start + (end-start)/2;
            if(nums.get(mid)==ele){
                return mid;
            }else if(nums.get(mid)<ele){
                start = mid+1;
            }else{      //arr[mid]>ele
                index = mid;
                end = mid-1;
            }

        }

        return index;
    }
}