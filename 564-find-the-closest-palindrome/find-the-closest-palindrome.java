class Solution {
    public String nearestPalindromic(String str) {
        

        List<Long> possibilities = new ArrayList<>();

        int n = str.length();
        int index = 0;
        if(n%2==0){
            index = (n/2)-1;
        }else{
            index = n/2;
        }

        long firstHalf = Long.parseLong(str.substring(0,index+1));
        // long temp = getPalin(firstHalf,n);
        // long temp2 = getPalin(firstHalf+1,n);
        // long temp3 = getPalin(firstHalf-1,n);
        // System.out.println(temp+" "+temp2+" "+temp3);
        possibilities.add(getPalin(firstHalf,n));
        possibilities.add(getPalin(firstHalf+1,n));
        possibilities.add(getPalin(firstHalf-1,n));
        possibilities.add((long) Math.pow(10,n-1)-1);
        possibilities.add((long) Math.pow(10,n)+1);

        long minDiff = Integer.MAX_VALUE;
        long diff =0 ;

        long palin=0;
        long originalVal = Long.parseLong(str);

        for(int i=0;i<possibilities.size();i++){
            long val = possibilities.get(i);
            if (val == originalVal) continue;

            if(val<originalVal){
                diff = originalVal - val;
                if(diff<=minDiff){
                    minDiff = diff;
                    palin = val;
                }
            }else{
                diff = val-originalVal;
                if(diff<minDiff){
                    minDiff = diff;
                    palin = val;
                }
            }
        }


        return String.valueOf(palin);


    }


     public long getPalin(long firstHalf, int n) {
    String firstHalfStr = String.valueOf(firstHalf);
    StringBuilder sb = new StringBuilder(firstHalfStr);

    // For mirroring, we use half of the number depending on whether n is even or odd
    String reversed;

    if (n % 2 == 0) {
        // Even length: mirror the whole firstHalf
        reversed = new StringBuilder(firstHalfStr).reverse().toString();
    } else {
        // Odd length: exclude the last digit to avoid duplication
        reversed = new StringBuilder(firstHalfStr.substring(0, firstHalfStr.length() - 1)).reverse().toString();
    }

    sb.append(reversed);
    return Long.parseLong(sb.toString());
}

}