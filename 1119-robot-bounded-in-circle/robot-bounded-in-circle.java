class Solution {
    public boolean isRobotBounded(String instructions) {
                        // N    E.    S.       W
        int dirs[][] = {{0,1}, {1,0}, {0,-1}, {-1,0}};

            int x=0,y=0;
            int dir = 0;        //N  E  S. W
                                //0  1. 2. 3
            //facing north

            int n = instructions.length();

            for(int i=0;i<n;i++){
                char ch = instructions.charAt(i);

                if(ch=='G'){
                    x+=dirs[dir][0];
                    y+=dirs[dir][1];
                }else if(ch=='L'){
                    dir = (dir+3)%4;
                }else{
                    //ch=='R'
                    dir = (dir+1)%4;
                }
            }

            if(x==0 && y==0){
                return true;
            }

        //else check if the direction is not north. If it's north then no loop, 
        //else it will repeat itself in other direction
            return dir!=0;

    }
}




            