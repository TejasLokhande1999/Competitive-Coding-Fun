class Solution {
    public String addStrings(String num1, String num2) {

     int i = num1.length()-1;
     int j = num2.length()-1;
     
     int sum=0;
     int carry = 0;
     int finalSum = 0;
     StringBuilder str = new StringBuilder();

     while(i>=0 || j>=0){

        int n1 = (i>=0) ? num1.charAt(i)-'0' : 0;
        int n2 = (j>=0) ? num2.charAt(j)-'0' : 0;

        sum = n1+n2+carry;

        carry = sum/10;         //for next iteration
        finalSum = sum%10;
        str.append(finalSum);

        i--;
        j--;
     
     }
     if(carry>0)
        str.append(carry);
        
     return str.reverse().toString();

    }
}