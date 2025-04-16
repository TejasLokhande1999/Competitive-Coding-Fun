class Solution {
        int countY0=0;
        int countY1=0;
        int countY2=0;
        int countNotY0=0;
        int countNotY1=0;
        int countNotY2=0;
    public int minimumOperationsToWriteY(int[][] grid) {
        
        int n = grid.length;
        int j=0;
        boolean visited [][]= new boolean[n][n];
        for(int i=0;i<n/2;i++){
            visited[i][j]=true;
            j++;
        }

        j=n-1;
        for(int i=0;i<=n/2;i++){
            visited[i][j]=true;
            j--;
        }

        j=n/2;
        for(int i=n/2;i<n;i++){
            visited[i][j]=true;    
        }

        for(int i=0;i<n;i++){
            for(int k=0;k<n;k++){
                int val = grid[i][k];
                if(visited[i][k]){
                    if(val==0){
                        countY0++;
                    }else if(val==1){
                        countY1++;
                    }else{
                        countY2++;
                    }
                }else{
                    //Not Y;
                    if(val==0){
                        countNotY0++;
                    }else if(val==1){
                        countNotY1++;
                    }else{
                        countNotY2++;
                    }
                }

            }
        }

        int minOps = Integer.MAX_VALUE;

        for(int yChar=0;yChar<3;yChar++){
            for(int notyChar=0;notyChar<3;notyChar++){

                if(yChar==notyChar) continue;
                
                int ops = 0;
                if(yChar!=0) ops+=countY0;
                if(yChar!=1) ops+=countY1;
                if(yChar!=2) ops+=countY2;

                if(notyChar!=0) ops+=countNotY0;
                if(notyChar!=1) ops+=countNotY1;
                if(notyChar!=2) ops+=countNotY2;

                minOps = Math.min(minOps,ops);

            }
        }

        return minOps;


    }

    


}