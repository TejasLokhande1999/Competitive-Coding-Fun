class Solution {
    public void moveZeroes(int[] arr) {
        //check for i
        int i=0;
        int n = arr.length;
        if(n==0){
            return;
        }
        boolean avl=false;
        for(int k=0;k<n;k++){
            if(arr[k]==0){
                i=k;
                avl=true;
                break;
            }
        }

        if(!avl){
            return;
        }


        for(int j=i+1;j<n;j++){
            if(arr[j]!=0){
                int temp = arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
                i++;
            }
        }



    }
}