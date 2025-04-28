class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;

        if(grid[0][0]==1)
            return -1;

        if(grid[n-1][n-1]==1)
            return -1;

        Queue<Pair> q = new LinkedList<>();
        boolean visited[][] = new boolean[n][n];

        q.add(new Pair(0,0,1));

        while(!q.isEmpty()){

            Pair p = q.poll();
            int x= p.x;
            int y= p.y;
            int val= p.val;

            if(x==n-1 && y==n-1){
                return val;
            }

            //else


        int dirs[][] = {{0,1},{0,-1},{1,0},{-1,0},{1,1},{1,-1},{-1,1},{-1,-1}};

        for(int dir[] : dirs){

            int px = x+dir[0];
            int py = y+dir[1];

            if(px>=0 && px<n && py>=0 && py<n && !visited[px][py] && grid[px][py]==0){

                q.add(new Pair(px,py,val+1));
                visited[px][py]=true;
            }

        }

        }

        return -1;


        
    }
}

class Pair{

    int x;
    int y;
    int val;

    Pair(int x, int y, int val){
        this.x = x;
        this.y = y;
        this.val = val;
    }


}