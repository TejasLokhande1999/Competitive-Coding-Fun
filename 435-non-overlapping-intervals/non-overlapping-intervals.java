class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {

    //sort based on end times
     Arrays.sort(intervals, (a,b)-> a[1]-b[1]);

    
    int prevStart = intervals[0][0];
    int prevEnd = intervals[0][1];


    int n = intervals.length;
    int count=0;

    for(int i=1;i<n;i++){
        int currStart = intervals[i][0];
        int currEnd = intervals[i][1];

        if(currStart>=prevEnd){

            prevStart = currStart;
            prevEnd = currEnd;

        }else{
            count +=1;
        }
    }

    return count;

    }
}