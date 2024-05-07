class Solution {
    public int reverse(int x) {
        
        String str = String.valueOf(x);

        if(str.charAt(0)=='-'){
            char negArr[] = new char[str.length()-1];

            for(int i=0;i<negArr.length;i++){
                negArr[i] = str.charAt(i+1);
            }

            return -reverseString(negArr);

        }else{

            return reverseString(str.toCharArray());

        }

    }


    public int reverseString(char arr[]){

        for(int i=0;i<arr.length/2;i++){
            char temp = arr[i];
            arr[i] = arr[arr.length-i-1];
            arr[arr.length-i-1] = temp;
        }

        String retStr = String.valueOf(arr);

        int retInt=0;

        try{
        retInt = Integer.parseInt(retStr);
        }catch(NumberFormatException e){
            return 0;
        }

        return retInt;
    
    }

}