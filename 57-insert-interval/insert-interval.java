class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        
        List<int[]> list = new ArrayList<>();

        int i=0;
        int n = intervals.length;

        int Istart = newInterval[0];
        int Iend = newInterval[1];

        while(i<n && intervals[i][1]<Istart){
            list.add(new int[]{intervals[i][0],intervals[i][1]});
            i++;
        }

        //while start<=IntervaLEnd
        while(i<n&&intervals[i][0]<=Iend){
            
            Istart = Math.min(Istart,intervals[i][0]);
            Iend = Math.max(Iend,intervals[i][1]);
            i++;
        }

        list.add(new int[]{Istart,Iend});
        while(i<n){
            list.add(intervals[i]);
            i++;
        }


        return list.toArray(new int[list.size()][]);



    }
}