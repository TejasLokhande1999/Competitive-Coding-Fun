class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        // List<Pair> list = new ArrayList<>();

        // for(int i=0;i<profits.length;i++){
        //     list.add(new Pair(profits[i],capital[i]));
        // }
        // Collections.sort(list, new SortComparator());
         int n = profits.length;
        List<Pair> projects = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            projects.add(new Pair(profits[i], capital[i]));
        }

        // Sort projects by capital required in ascending order
        projects.sort(Comparator.comparingInt(p -> p.c));
        
        // Max heap to keep track of the most profitable projects
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        
        int i = 0;
        while (k > 0) {
            // Add all projects that can be done with current capital to the max heap
            while (i < n && projects.get(i).c <= w) {
                maxHeap.add(projects.get(i).p);
                i++;
            }
            
            // If we can't afford any more projects, break
            if (maxHeap.isEmpty()) {
                break;
            }
            
            // Pick the most profitable project
            w += maxHeap.poll();
            k--;
        }

        return w;
    }
}

class Pair{
    int p;
    int c;

    Pair(int profit, int capital){
        this.p = profit;
        this.c = capital;
    }

}

class SortComparator implements Comparator<Pair>{

    public int compare(Pair p1, Pair p2){
        if(p1.c>p2.c){
            return 1;
        }else if(p1.c<p2.c){
            return -1;
        }else{      //tie
        //sort on capital
            if(p1.p>p2.p){
                return 1;
            }else if(p1.p<p2.p){
                return -1;
            }else{
                return 0;
            }
        }
    }

}