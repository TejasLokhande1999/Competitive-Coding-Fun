class Solution {
    public int[][] merge(int[][] intervals) {
        int m = intervals.length;

        List<Pair> list =new ArrayList<>();
        for(int i=0;i<m;i++){
            list.add(new Pair(intervals[i][0],intervals[i][1]));
        }

        Collections.sort(list, new PairComparator());

        int start = list.get(0).x;
        int end = list.get(0).y;
        ArrayList<Pair> result = new ArrayList<>();
        for(int i=0;i<list.size();i++){
            Pair p = list.get(i);
            int currStart = p.x;
            int currEnd = p.y;
            if(end>=currStart){
                end = Math.max(end,currEnd);
            }else{
                result.add(new Pair(start,end));
                start = p.x;
                end = p.y;
            }
        }

        result.add(new Pair(start,end));

        int n = result.size();

        int mat[][] = new int[n][2];

        for(int i=0;i<n;i++){
            mat[i][0] = result.get(i).x;
            mat[i][1] = result.get(i).y;
        }   

        return mat;
    }
}

class Pair{
    int x;
    int y;
    Pair(int x, int y){
        this.x=x;
        this.y=y;
    }
}

class PairComparator implements Comparator<Pair>{

    public int compare(Pair p1, Pair p2){
        if(p1.x>p2.x){
            return 1;
        }else if(p1.x<p2.x){
            return -1;
        }else{
            //tie
            if(p1.y>p2.y){
                return 1;
            }else if(p1.y<p2.y){
                return -1;
            }else{
                return 0;
            }
        }
    }

}