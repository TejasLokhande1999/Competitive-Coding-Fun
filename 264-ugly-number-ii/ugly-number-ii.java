class Solution {
    public int nthUglyNumber(int n) {

        PriorityQueue<Long> pq = new PriorityQueue<>();
        Set<Long> set = new HashSet<>();
        int primeFactors[] = {2,3,5};


        //Use the property--> multiplying the number with 2,3,5 also generates an ugly number
        // poll from pq() --> the smallest ugly number
        // then generates the 3 ugly numbers from these and push to the PQ
        // the head will always point to the smallest ugly number

        pq.add(1L);
        set.add(1L);
        long currUgly = 0;
        for(int i=0;i<n;i++){
            currUgly = pq.poll();
            for(long pF : primeFactors){
                long nextUgly = currUgly*pF;
                if(!set.contains(nextUgly))
                {
                    pq.add(nextUgly);
                    set.add(nextUgly);
                }
            }
        }
        

        return (int) currUgly;
        
    }
}



// n=10

// primeFactors = [2,3,5]. //only can be divided by these

// 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20


// 1 2 3 4 5 6 9 10 12 15

// 1*2 = 2
// 2*3 = 6
// 6* 5 = 30 -->2,3,5,6,10,15


// [1, 2 , 6 , 30]





// 1 2 3
// 4 5 6
// 9 10 12 15


// 1 --> 1
// 2 --> 2
// 3 --> 3
// 4 --> 2
// 5 --> 5
// 6 --> 2,3
// 7 --> 7 -->(Nope, as this is my not in ugly numbers)
// 8 --> 2,4   (no)
// 9 --> 3
// 10 --> 2,5
// 11 --> 1, 11 (no)
// 12 --> 2,3,4,6,12
// 13 --> 1, 13
// 14 --> 2,7
// 15--> 3,5

