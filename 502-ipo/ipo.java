class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        
        //ArrayList mahd esort based on capital

        List<Pair> list = new ArrayList<>();
        for(int i=0;i<profits.length;i++){
            list.add(new Pair(capital[i],profits[i]));
        }

        Collections.sort(list, (a,b)-> a.capital-b.capital);

        //sort in descensding based on profits
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        int index=0;
        int n = capital.length;
        for(int i=0;i<k;i++){

            while(index<n && list.get(index).capital<=w){
                pq.add(list.get(index).profit);
                index++;
            }

            if(pq.isEmpty()){
                break;
            }

            w+=pq.poll();
    
        }

        return w;


    }
}

class Pair{

    int capital;
    int profit;

    Pair(int capital, int profit){
        this.capital = capital;
        this.profit = profit;
    }

}