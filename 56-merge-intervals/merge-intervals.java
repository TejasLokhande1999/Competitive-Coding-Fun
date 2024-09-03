class Solution {
    public int[][] merge(int[][] intervals) {
        
        if(intervals.length==1){
            return intervals;
        }
        ArrayList<Pair> list = new ArrayList<>();

        for(int i=0;i<intervals.length;i++){
            int x = intervals[i][0];
            int y = intervals[i][1];

            list.add(new Pair(x,y));
        }

    Collections.sort(list, new PairComparator());


    ArrayList<Pair> retList = new ArrayList<Pair>();

    Pair p1 = list.get(0);
    int ele1 = p1.x;
    int ele2=p1.y;
    for(int i=1;i<list.size();i++){
        Pair p = list.get(i);
        if(p.x<=ele2){

            if(p.y>ele2){
                ele2=p.y;
            }

        }else{  //start a new interval
            retList.add(new Pair(ele1,ele2));
            ele1 = p.x;
            ele2 = p.y;
        }
    }

    retList.add(new Pair(ele1,ele2));

    int mat[][] = new int[retList.size()][2];

    for(int i=0;i<retList.size();i++){
        mat[i][0] = retList.get(i).x;
        mat[i][1] = retList.get(i).y;
    }

    return mat;
}
}

class Pair{

    int x;
    int y;
    Pair(int x, int y){
        this.x = x;
        this.y=y;
    }
}

class PairComparator implements Comparator<Pair>{

    public int compare(Pair p1, Pair p2){

        if(p1.x>p2.x){
            return 1;
        }else if(p1.x<p2.x){
            return -1;
        }else{          //p1.x==p2.x;
            return 0;
        }
    }

}