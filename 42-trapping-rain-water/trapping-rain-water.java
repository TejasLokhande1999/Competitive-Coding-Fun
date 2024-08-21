class Solution {
    public int trap(int[] arr) {
        
        int n = arr.length;

        int arrR[] = new int[n];
        int arrL[] = new int[n];

        int maxL = Integer.MIN_VALUE;
        int maxR = Integer.MIN_VALUE;

        for(int i=0;i<n;i++){
            arrL[i] = Math.max(maxL,arr[i]);
            maxL = Math.max(maxL,arr[i]);
        }

        for(int i=n-1;i>=0;i--){
            arrR[i] = Math.max(arr[i],maxR);
            maxR = Math.max(maxR,arr[i]);
        }

        int sum=0;

        for(int i=0;i<n;i++){
            sum+= Math.min(arrL[i],arrR[i])-arr[i];
        }

        return sum;
    }
}