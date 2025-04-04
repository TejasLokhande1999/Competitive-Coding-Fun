class Solution {
    public boolean canMeasureWater(int x, int y, int target) {
        Set<String> set = new HashSet<>();
        return dfs(0,0,x,y,target,set);
    }

    public boolean dfs(int j1, int j2, int x, int y, int target, Set<String> set){

        if(j1+j2==target){
            return true;
        }
        
        String key = j1+","+j2;

        //we see if this state was previosuly present or not
        if(set.contains(key))
            return false;

        set.add(key);

        return  dfs(x,j2,x,y,target,set) ||      //fill j1
                dfs(j1,y,x,y,target,set) ||     //fill j1
                dfs(0,j2,x,y,target,set) ||        //empty j1
                dfs(j1,0,x,y,target,set) ||           //empty j2
                dfs(Math.max(0,j1-(y-j2)),Math.min(y,j1+j2),x,y,target,set) ||        //pour from j1->j2
                dfs(Math.min(x,j1+j2),Math.max(0,j2-(x-j1)),x,y,target,set);       //from j2-->j1
    }
}