class Solution {
    public int tribonacci(int n) {
    
        if(n==0){
            return 0;
        }else if(n==1){
            return 1;
        }else if(n==2){
            return 1;
        }
    
        int t0=0;
        int t1=1;
        int t2=1;

        int arr[] = new int[n+1];
        arr[0] = t0;
        arr[1]=t1;
        arr[2]=t2;

        for(int i=3;i<=n;i++){
            arr[i] = arr[i-1]+arr[i-2]+arr[i-3];
        }

        return arr[arr.length-1];
    }
}