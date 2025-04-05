class Solution {
    public int[] fairCandySwap(int[] A, int[] B) {
        
        int sumA = 0;
        int sumB = 0;

        for(int i=0;i<A.length;i++){
            sumA+=A[i];
        }

        for(int i=0;i<B.length;i++){
            sumB+=B[i];
        }


        int diff = (sumA-sumB)/2;

        int retArr[] = new int[2];

        Set<Integer> set = new HashSet<>();

        for(int a: A){
            set.add(a);
        }

        for(int b : B){
            int reqNo = b+diff;

            if(set.contains(reqNo)){
                retArr[0] = reqNo;
                retArr[1] = b;

                return retArr;
            }
        }

        return retArr;

    }
}