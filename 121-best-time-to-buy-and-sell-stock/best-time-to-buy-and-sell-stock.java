class Solution {
    public int maxProfit(int[] prices) {
    
     int n = prices.length;
     int right[] = new int[n];

     int max = prices[n-1];
     right[n-1]=-1;

     for(int i=n-2;i>=0;i--){
        if(prices[i]>max){
            right[i]=-1;
            max = prices[i];
        }else{
            right[i] = max;
        }
     }
    max= 0;
    for(int i=0;i<n;i++){
        int diff = right[i]-prices[i];
        max=Math.max(diff,max);
    }

    return max;
    }
}