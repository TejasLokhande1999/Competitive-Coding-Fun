class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        
        ArrayList<Integer> arr = new ArrayList<>();
        Map<Integer, Integer> ballsMap = new HashMap<>();
        Map<Integer, Integer> colorsMap = new HashMap<>();
        int distCount= 0;
        for(int arrEle[] : queries){

            int ball = arrEle[0];
            int color = arrEle[1];

            if(ballsMap.containsKey(ball)){
                
                int oldColor = ballsMap.get(ball);

                if(color!=oldColor){

                    ballsMap.put(ball,color);
                    colorsMap.put(oldColor,colorsMap.getOrDefault(oldColor,0)-1);

                    int oldColorVal = colorsMap.get(oldColor);

                    if(oldColorVal==0){
                        distCount-=1;
                    }

                    if(colorsMap.containsKey(color)){
                        if(colorsMap.get(color)==0)
                            distCount+=1;   
                        colorsMap.put(color,colorsMap.getOrDefault(color,0)+1);
                    }else{
                        colorsMap.put(color,1);
                        distCount+=1;
                    }   

                }
                arr.add(distCount);
                

                // int oldColor = ballsMap.get(ball);
                // ballsMap.put(ball,color);
                // colorMap.put(oldColor, colorMap.get(oldColor)-1);
                // colorMap.put(color,colorMap.getOrDefault(color,0)+1);

                // int count=0;
                // for(Map.Entry<Integer, Integer> entry : colorMap.entrySet()){
                //     int val = entry.getValue();
                //     if(val>0){
                //         count+=1;
                //     }
                // }
                // arr.add(count);
            }else{
                // ballsMap.put(ball,color);
                // colorMap.put(color,colorMap.getOrDefault(color,0)+1);
                // int count=0;
                // for(Map.Entry<Integer, Integer> entry : colorMap.entrySet()){
                //     int val = entry.getValue();
                //     if(val>0){
                //         count+=1;
                //     }
                // }
                // arr.add(count);

                ballsMap.put(ball,color);
                colorsMap.put(color,colorsMap.getOrDefault(color,0)+1);
                int val = colorsMap.get(color);
                if(val==1)
                    distCount+=1;
                arr.add(distCount);
            }

        }

        int retArr[] = new int[arr.size()];
        for(int i=0;i<arr.size();i++){
            retArr[i] = arr.get(i);
        }
        return retArr;
    }
}