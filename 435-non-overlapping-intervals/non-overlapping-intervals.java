class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        ArrayList<Pair> list = new ArrayList<>();
        int m = intervals.length;

        for(int i=0;i<m;i++){
            list.add(new Pair(intervals[i][0],intervals[i][1]));
        }
        Collections.sort(list, new PairComparator());

        int prevEnd = list.get(0).y;
        int count=0;
        for(int i=1;i<list.size();i++){
            int start = list.get(i).x;
            if(start<prevEnd){
                count+=1;
            }else{
                prevEnd = list.get(i).y;
            }
        }

        return count;



 
        //logic for merge intervals
        //      int start = list.get(0).x;
        // int end = list.get(0).y;
        // ArrayList<Pair> result = new ArrayList<>();
        // for(int i=0;i<list.size();i++){
        //     Pair p = list.get(i);
        //     int currStart = p.x;
        //     int currEnd = p.y;

        //     if(end>currStart){
        //         end = Math.max(currEnd,end);
        //     }else{
        //         result.add(new Pair(start,end));
        //         start = currStart;
        //         end = currEnd;
        //     }
        // }

        // result.add(new Pair(start,end));
        // for(int i=0;i<result.size();i++)
        //     System.out.print(result.get(i).x+" "+result.get(i).y+"   ");
        // return m-result.size();

    }
}

class Pair{
    int x;
    int y;

    Pair(int x,int y){
        this.x=x;
        this.y=y;
    }
}

class PairComparator implements Comparator<Pair>{

    public int compare(Pair p1, Pair p2){
            if(p1.y>p2.y){
                return 1;
            }else if(p1.y<p2.y){
                return -1;
            }else{
                return 0;
            }
    }
}