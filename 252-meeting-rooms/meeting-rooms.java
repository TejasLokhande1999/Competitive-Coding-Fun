class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        int m = intervals.length;
        if(m==0){
            return true;
        }
        List<Pair> list = new ArrayList<>();
        for(int i=0;i<m;i++){
            list.add(new Pair(intervals[i][0], intervals[i][1]));
        }

        
        Collections.sort(list, new PairComparator());

        // for(int i=0;i<m;i++){
        //     System.out.println(list.get(i).x+" "+list.get(i).y+"    ");
        // }

        int start = list.get(0).x;
        int end = list.get(0).y;

        for(int i=1;i<m;i++){
            Pair p = list.get(i);
            int currStart = p.x;
            int currEnd = p.y;

            if(end>currStart){
                return false;
            }else{
                start = currStart;
                end = currEnd;
            }
        }

        return true;
    }
}

class Pair{

    int x;
    int y;

    Pair(int x, int y){
        this.x=x;
        this.y =y;
    }
}

class PairComparator implements Comparator<Pair>{
    public int compare(Pair p1, Pair p2){
        if(p1.x>p2.x){
            return 1;
        }else if(p1.x<p2.x){
            return -1;
        }else{
            return 0;
        }
    }
}