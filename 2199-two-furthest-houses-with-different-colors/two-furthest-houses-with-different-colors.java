class Solution {
    public int maxDistance(int[] colors) {
        
        int i=0;
        int n = colors.length;
        int j = n-1;
        int maxLen = 0;

        while(i<n){

            j=n-1;
            while(i<j){
                if(i<j){

                if(colors[i]!=colors[j]){
                    maxLen = Math.max(maxLen,j-i);
                    break;
                }
                j--;
            }
            }

            i++;
        }

        return maxLen;

    }

}