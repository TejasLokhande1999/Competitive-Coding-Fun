class Solution {
    public int candy(int[] ratings) {

        int n = ratings.length;
        int candies[] = new int[n];


        Arrays.fill(candies,1);


        if(n==1){
            return 1;
        }


        for(int i=1;i<n;i++){
            if(ratings[i]>ratings[i-1]){
                candies[i] = 1+candies[i-1];
            }
        }


        for(int i=n-2;i>=0;i--){

            if(ratings[i]>ratings[i+1]){
                if(candies[i]<=candies[i+1])
                    candies[i] = 1 + candies[i+1];
            }

        }

        int sum = 0;
        for(Integer i : candies){
            sum+=i;
        }

        return sum;


        }
}