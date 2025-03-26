class Solution {
    public List<List<Integer>> generate(int numRows) {
        
        List<List<Integer>> res = new ArrayList<>();

        res.add(new ArrayList<>());

        res.get(0).add(1);

        for(int i=1;i<numRows;i++){

            List<Integer> temp = new ArrayList<>(res.get(i-1));

            //add 0 to 1st and last position
            temp.add(0,0);
            temp.add(0);

            List<Integer> newRow = new ArrayList<>();

            for(int j=0;j<temp.size()-1;j++){
                newRow.add(temp.get(j)+temp.get(j+1));
            }

            res.add(newRow);
        }

        return res;


    }
}