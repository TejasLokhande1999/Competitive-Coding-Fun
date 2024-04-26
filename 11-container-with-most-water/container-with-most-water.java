class Solution {
    public int maxArea(int[] height) {
        
        //Use the 2 pointer approach.

        int n = height.length;
        int pointer1 = 0;
        int pointer2 = n-1;

        int max = Integer.MIN_VALUE;

        int temp =0;

        int minVal=0;
        while(pointer1<pointer2){
            minVal = Math.min(height[pointer1],height[pointer2]);
            temp = minVal*(pointer2-pointer1);
            if(max<temp){
                max = temp;
            }
            if(height[pointer1]<height[pointer2]){
                pointer1+=1;
            }else if(height[pointer1]>height[pointer2]){
                pointer2-=1;
            }else{
                pointer1++;
            }
        }

        return max;

    }
}