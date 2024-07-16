class Solution {
    public List<List<Integer>> generate(int numRows) {
        
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        int res;
        for(int i=1;i<=numRows;i++)
        {
            List<Integer> temp = new ArrayList<Integer>();
            res=1;
            for(int j=1;j<=i;j++)
            {
                   temp.add(func_nCr(i-1,j-1));
            }
            list.add(temp);
        }


        return list;
    }


    public int func_nCr(int r,int c){
        int res=1;          //also satisfies the base case

        for(int i=0;i<c;i++){
            res = res*(r-i);
            res = res/(i+1);
        }

        return res;

    }

}