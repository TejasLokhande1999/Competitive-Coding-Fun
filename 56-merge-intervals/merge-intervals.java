class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);

        int prevS = intervals[0][0];
        int prevE = intervals[0][1];
        List<int[]> list = new ArrayList<>();
        for(int i=1;i<intervals.length;i++){

            int currS = intervals[i][0];
            int currE = intervals[i][1];

            if(prevE>=currS){
                prevE = Math.max(prevE,currE);
            }else{
                
                list.add(new int[]{prevS,prevE});
                prevS = currS;
                prevE = currE;
            }
        }

        list.add(new int[]{prevS,prevE});

        return list.toArray(new int[list.size()][]);



    }
}