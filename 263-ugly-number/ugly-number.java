class Solution {
    public boolean isUgly(int n) {

            // if(n==1 || n==2 || n==3){
            //     return true;
            // }

            // //find factosr of n
            // //trace thr the factors and see if the factor is 
            // // prime factor and is other than 2,3, or 5

            // //6 --> 1,2,3
            // List<Integer> pF = new ArrayList<>();
            // for(int i=2;i<=n/2;i++){
            //     if(n%i==0 && isPrime(i)){
            //         pF.add(i);
            //     }
            // }

            // Set<Integer> set = new HashSet<>();
            // set.add(2);
            // set.add(3);
            // set.add(5);
            // for(int primeFactor : pF){
            //     if(!set.contains(primeFactor)){
            //         return false;
            //     }
            // }

            //  if (isPrime(n) && !set.contains(n)) {
            //     return false;
            // }

            // return true;

            if (n <= 0) return false;
        if (n == 1) return true;

        // Only divide by allowed prime factors
        while (n % 2 == 0) n /= 2;
        while (n % 3 == 0) n /= 3;
        while (n % 5 == 0) n /= 5;

        return n == 1;

    }

    public boolean isPrime(int num){

        if(num==1){
            return false;
        }
        if(num==2){
            return true;
        }


        for(int i=2;i*i<=num;i++){
            if(num%i==0){
                return false;
            }
        }

        
        return true;


    }
}

//8--> 1,2,4,8