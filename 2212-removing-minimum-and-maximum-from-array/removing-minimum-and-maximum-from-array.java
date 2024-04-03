class Solution {
    public int minimumDeletions(int[] nums) {
        int min=Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        int minI=0;
        int maxI=0;


        if(nums.length==1)
        {
            return 1;
        }

        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]>max)
            {
                max=nums[i];
                maxI = i;
            }
            if(nums[i]<min)
            {
                min=nums[i];
                minI = i;
            }
        }

    //Now check with respect to index in array

    ArrayList<Integer> arr = new ArrayList<Integer>();

    if(minI<maxI)
    {
        arr.add(minI+1+(nums.length-maxI));
        arr.add(maxI+1);
        arr.add(nums.length-minI);
    }else if(minI>maxI){
        arr.add(maxI+1+(nums.length-minI));
        arr.add(minI+1);
        arr.add(nums.length-maxI);
    }else{
        arr.add(minI+1);
        arr.add(nums.length-minI);
    }

    Collections.sort(arr);
    // System.out.println(arr);
    // System.out.println("maxI:"+maxI+" minI:"+minI);

    return arr.get(0);

    }
}