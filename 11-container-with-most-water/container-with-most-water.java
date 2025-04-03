class Solution {
    public int maxArea(int[] height) {
        
        int maxArea = 0;

        int i = 0;
        int n = height.length;

        int j = n-1;

        while(i<j){

            int leftHgt = height[i];
            int rightHgt = height[j];

            maxArea = Math.max(maxArea, (j-i)*Math.min(leftHgt, rightHgt));

            if(leftHgt<rightHgt){
                i++;
            }else{
                j--;
            }
        }

        return maxArea;
    }
}