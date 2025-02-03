class Solution {
    public int[][] kClosest(int[][] points, int k) {
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->b.dist-a.dist);
        for(int[] point : points){
            int x = point[0];
            int y = point[1];
            int dist = x*x + y*y;

            pq.add(new Pair(x,y,dist));

            if(pq.size()>k){
                pq.poll();
            }
        }

        int retArr[][] = new int[k][2];
        int i = 0;

        while(!pq.isEmpty()){

            Pair p = pq.poll();
            retArr[i][0] = p.x;
            retArr[i][1] = p.y;
            i+=1;
        }

        return retArr;

    }
}

class Pair{

    int x;
    int y;
    int dist;

    Pair(int x, int y, int dist){
        this.x = x;
        this.y = y;
        this.dist = dist;
    } 

}