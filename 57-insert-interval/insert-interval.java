class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        
        List<List<Integer>> list = new ArrayList<>();
        int newStart = newInterval[0];
        int newEnd = newInterval[1];
        int count=0;
        List<int[]> temp = new ArrayList<>();

        for(int interval[] : intervals){
            int start = interval[0];
            int end = interval[1];

            if(end<newStart){
                temp.add(new int[]{start,end});
                count+=1;
            }
        }

        int count2=count;
        for(int i=count;i<intervals.length;i++){
            int start = intervals[i][0];
            int end = intervals[i][1];
            if(start<=newEnd){
                newEnd = Math.max(newEnd,end);
                newStart= Math.min(newStart,start);
                count2+=1;
            }else{
                break;
            }
        }

        temp.add(new int[]{newStart,newEnd});

        for(int i=count2;i<intervals.length;i++){
            temp.add(new int[]{intervals[i][0],intervals[i][1]});
        }

        return temp.toArray(new int[temp.size()][]);



    }
}