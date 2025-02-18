class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        PriorityQueue<String> pq = new PriorityQueue<>(Collections.reverseOrder());
        List<List<String>> retList = new ArrayList<>();
    for(int i=1;i<=searchWord.length();i++)
    {
        String childStr = searchWord.substring(0,i);
        List<String> list = new ArrayList<>();
        for(String product : products){
            if(product.startsWith(childStr))
            {
                pq.add(product);
                if(pq.size()>3){
                    pq.poll();
                }
            }
        }

        while(!pq.isEmpty()){
            list.addFirst(pq.poll());
        }
            retList.add(list);

    }

        return retList;


    }

}