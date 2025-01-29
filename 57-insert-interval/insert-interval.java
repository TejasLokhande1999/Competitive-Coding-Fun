class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        
        List<List<Integer>> list = new ArrayList<>();
        
        int Istart = newInterval[0];
        int Iend = newInterval[1];

        int n = intervals.length;
        int i=0;
        while(i<n && intervals[i][1]<Istart){
            List<Integer> a = new ArrayList<>();
            a.add(intervals[i][0]);
            a.add(intervals[i][1]);

            list.add(a);
            i++;
        }

        //end>=Istart
        //run this loop till start<=Iend

        while(i<n && intervals[i][0]<=Iend){
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1],intervals[i][1]);

            i++;
        }


        List<Integer> a2 = new ArrayList<>();
        a2.add(newInterval[0]);
        a2.add(newInterval[1]);

        list.add(a2);

        while(i<n){
            List<Integer> a = new ArrayList<>();
            a.add(intervals[i][0]);
            a.add(intervals[i][1]);

            list.add(a);
            i++;
        }

        int retArr[][] = new int[list.size()][2];

        for(int j=0;j<list.size();j++){
            retArr[j][0] = list.get(j).get(0);
            retArr[j][1] = list.get(j).get(1);
        }

        return retArr;

    }
}