class Solution {
    public int[][] merge(int[][] intervals) {
        
        if(intervals.length==1){
            return intervals;
        }

        //sorting based on start in asc
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);

        List<int[]> list= new ArrayList<>();

        
        int prevStart = intervals[0][0];
        int prevEnd = intervals[0][1];
        int start = 0;
        int end = 0;

        for(int i=1;i<intervals.length;i++){

            start = intervals[i][0];
            end = intervals[i][1];


            if(start<=prevEnd){
                prevStart = Math.min(prevStart,start);
                prevEnd = Math.max(prevEnd,end);
            }else{
                list.add(new int[]{prevStart,prevEnd});
                prevStart = start;
                prevEnd = end;
            }
        }
        
        list.add(new int[]{prevStart,prevEnd});

        return list.toArray(new int[list.size()][]);

    }
}