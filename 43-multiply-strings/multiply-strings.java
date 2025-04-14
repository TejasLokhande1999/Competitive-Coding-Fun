class Solution {
    public String multiply(String num1, String num2) {
        int l1 = num1.length();
        int l2 = num2.length();

        if(num1.equals("0") || num2.equals("0"))
            return "0";

        int arr[] = new int[l1+l2];
        int carry=0;
        for(int j=l2-1;j>=0;j--){
            for(int i=l1-1;i>=0;i--){
                int n1 = num1.charAt(i)-'0';
                int n2 = num2.charAt(j)-'0';
                int mul = n1*n2;
                int res = mul + arr[i+j+1];
                carry = res/10;
                arr[i+j]+= carry;
                arr[i+j+1] = res%10;
            }
        }

        StringBuilder str = new StringBuilder();

        for(int i=0;i<arr.length;i++){
            if(arr[i]==0 && str.length()==0){
                continue;
            }
            str.append(arr[i]);
        }

        return str.toString();

    }
}