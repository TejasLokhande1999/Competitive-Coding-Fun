class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if(source==target)
            return 0;
        
        Map<Integer, List<Integer>> stopToBus = new HashMap<>();

        for(int i=0;i<routes.length;i++){
            for(int j=0;j<routes[i].length;j++){
                    int stop = routes[i][j];
                    int bus=i;
                    stopToBus.putIfAbsent(stop, new ArrayList<>());
                    stopToBus.get(stop).add(bus);
            }
        }


        // for(Map.Entry<Integer, List<Integer>> entry : stopToBus.entrySet()){
        //     int stop = entry.getKey();
        //     List<Integer> buses = entry.getValue();
        //     System.out.print(stop+" ");
        //     for(int i=0;i<buses.size();i++){
        //         System.out.print(buses.get(i)+" ");
        //     }

        //     System.out.println();
        // }

        int countBuses=0;

        Queue<Integer> q = new LinkedList<>();

        q.add(source);

        Set<Integer> visitedBuses = new HashSet<>();
        Set<Integer> visitedStops = new HashSet<>();
        
        while(!q.isEmpty()){

            int size = q.size();
            countBuses++;
            for(int i=0;i<size;i++){

                int stop = q.poll();

                //get the buses from that stop
                List<Integer> buses = stopToBus.getOrDefault(stop, new ArrayList<>());
                for(int bus : buses){

                    if(visitedBuses.contains(bus)){
                        continue;
                    }

                    visitedBuses.add(bus);

                    //get the stops from these buses and see if they are equal to target

                    for(int nextStop : routes[bus]){
                        if(nextStop==target){
                            return countBuses;
                        }

                        if(!visitedStops.contains(nextStop)){
                            //visit the mext stop
                            visitedStops.add(nextStop);
                            q.add(nextStop);
                        }
                    }

                }


            }

        }

        return -1;

    }
}