class Solution {
    public int[] productExceptSelf(int[] arr) {

        int n = arr.length;
        int prod[] = new int[n];

        int pre[] = new int[n];
        int suf[] = new int[n];


        pre[0] = 1;

        for(int i=1;i<n;i++){
            pre[i] = pre[i-1]*arr[i-1];
        }
        
        suf[n-1]=1;
        for(int i=n-2;i>=0;i--){
            suf[i] = suf[i+1]*arr[i+1];
        }

        for(int i=0;i<n;i++){
            prod[i] = pre[i]*suf[i];
        }

        return prod;


    }
}




// arr[]       1   2   3   4
// prefix[]    1   1   2   6       prefix[i] = prefix[i-1]*arr[i-1]
// suffix[]    24  12  4   1
// op[]        1   12  8   6