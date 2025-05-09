class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals.length==1){
            return 0;
        }

        int count=0;

        Arrays.sort(intervals,(a,b)->a[1]-b[1]);
        int prevStart = intervals[0][0];
        int prevEnd = intervals[0][1];

        for(int i=1;i<intervals.length;i++){

            int currStart = intervals[i][0];
            int currEnd = intervals[i][1];
            if(currStart<prevEnd){
                prevEnd = Math.min(prevEnd,currEnd);
                count+=1;
            }else{

               prevStart = currStart;
                prevEnd = currEnd;
            }
        }

        return count;
    }
}