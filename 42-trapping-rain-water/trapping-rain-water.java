class Solution {
    public int trap(int[] height) {
        
        int gel[] = new int[height.length];
        int ger[] = new int[height.length];


        Stack<Integer> s = new Stack<>();
        int maxL = height[0];
        for(int i=0;i<height.length;i++){
            gel[i] = Math.max(maxL,height[i]);
            maxL = Math.max(maxL,height[i]);
        }

        int n = height.length;
        int maxR= height[n-1];

        for(int i=height.length-1;i>=0;i--){
            ger[i] = Math.max(maxR,height[i]);
            maxR =  Math.max(maxR,height[i]);       
        }


        int sum =0;

        for(int i=0;i<height.length;i++){
            sum += Math.min(gel[i],ger[i]) - height[i];
        }

        return sum;
    }
}