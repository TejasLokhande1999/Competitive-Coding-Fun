class MedianFinder {
    PriorityQueue<Integer> largeHeap;
    PriorityQueue<Integer> smallHeap;
    public MedianFinder() {
        smallHeap = new PriorityQueue<>(Collections.reverseOrder()); //this one is a max heap
        largeHeap = new PriorityQueue<>(); //this one is a minheap
    }
    
    public void addNum(int num) {
        smallHeap.add(num);
        if(smallHeap.size()-largeHeap.size()>1){
            largeHeap.add(smallHeap.poll());
        }else if(!largeHeap.isEmpty() && smallHeap.peek()>largeHeap.peek()){
            largeHeap.add(smallHeap.poll());
        }
        if(largeHeap.size()-smallHeap.size()>1){
            smallHeap.add(largeHeap.poll());
        }
    }
    
    public double findMedian() {

        int size1 = smallHeap.size();
        int size2 = largeHeap.size();
        if(size1-size2==0){
            int val1 = smallHeap.peek();
            int val2 = largeHeap.peek();
            return (double)(val1+val2)/2;
        }else if(size1>size2){
            return (double)smallHeap.peek();
        }
        return (double)largeHeap.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */