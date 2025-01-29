class Solution {
    public int[][] merge(int[][] intervals) {
        
        //sort the intervals according to start time

        Arrays.sort(intervals, (a,b) -> a[0]- b[0]);

        List<int[]> list = new ArrayList<>();
        //sort based on start time

        int start = intervals[0][0];
        int end = intervals[0][1];

        for(int i=1;i<intervals.length;i++){

            int currStart = intervals[i][0];
            int currEnd  = intervals[i][1];

            if(currStart<=end){
                start = Math.min(start,currStart);
                end = Math.max(end, currEnd);
            }else{
                
                list.add(new int[]{start,end});
                start = currStart;
                end = currEnd;

        }
        }

        list.add(new int[]{start,end});

        return list.toArray(new int[list.size()][]);

        


    }
}