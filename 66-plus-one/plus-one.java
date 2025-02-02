class Solution {
    public int[] plusOne(int[] digits) {
        
        int carry =0 ;
        ArrayList<Integer> res = new ArrayList<>();
        int n=digits.length;
        int currSum = 1;
        for(int i=n-1;i>=0;i--){
            int num = digits[i]+currSum+ carry;

            if(num>=10){
                carry = 1;
                res.add(num%10);
                currSum=0;
            }else{
                carry=0;
                res.add(num);
                currSum = 0;
            }
        }

        if(carry==1){
            res.add(1);
        }

        Collections.reverse(res);

        int retArr[] = new int[res.size()];

        for(int i=0;i<res.size();i++){
            retArr[i] = res.get(i);
        }

        return retArr;
    }
}