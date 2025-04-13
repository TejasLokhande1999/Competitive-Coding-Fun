class Solution {
    public int[] fairCandySwap(int[] A, int[] B) {
        

        // alice = [1,1]. aliceSum = 2;
        // bob = [2,2],bobSum = 4;

        // diff = -1;



        // totalSumA - a[i] + b[j] = totalSumB-b[j]+a[i];
        // -2 a[i] + 2b[j] = totalSumB-totalSumA;
        // a[i] - b[j] = (totalSumA-totalSumB)/2;

        // a = diff + b;

        int sumA = 0;
        int sumB = 0;

        for(int num1 : A){
            sumA +=num1;
        }


        for(int num2 : B){
            sumB +=num2;
        }

        int diff = (sumA-sumB)/2;

        Set<Integer> set = new HashSet<>();


        //if in b, we find a then return that

        for(int i=0;i<A.length;i++){
            set.add(A[i]);
        }


        for(int i=0;i<B.length;i++){
            int ele = diff+B[i];

            if(set.contains(ele)){

                return new int[]{ele,B[i]};
            }
        }


        return new int[] {0,0};


    }
}