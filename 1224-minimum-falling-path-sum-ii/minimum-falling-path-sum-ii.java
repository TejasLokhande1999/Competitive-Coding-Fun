class Solution {

    
    public int minFallingPathSum(int[][] grid) {

     int r = grid.length;
     int c = grid[0].length;

    int ans[][] = new int[r][c];

     for(int i=0;i<c;i++){
        ans[0][i] = grid[0][i];
     }

     for(int i=1;i<r;i++){
        for(int j=0;j<c;j++){
            ans[i][j] = grid[i][j]+findMin(ans,i-1,j);
        }
     }

     int min =Integer.MAX_VALUE;

     for(int i=0;i<c;i++){
        if(ans[r-1][i]<min){
            min = ans[r-1][i];
        }
     }

     return min;

    }

    public int findMin(int arr[][], int r, int c){
        int min = Integer.MAX_VALUE;

        for(int i=0;i<arr[0].length;i++){
            if(min>arr[r][i] && i!=c){
                min=arr[r][i];
            }
        }

        return min;

    }


}