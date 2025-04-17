class MedianFinder {

    PriorityQueue<Integer> smallHeap;
    PriorityQueue<Integer> largeHeap;
    public MedianFinder() {
        smallHeap = new PriorityQueue<>();
        largeHeap = new PriorityQueue<>(Collections.reverseOrder());
    }
    
    public void addNum(int num) {
        largeHeap.add(num);

        if(largeHeap.size()-smallHeap.size()>1){
            smallHeap.add(largeHeap.poll());
        }
        if(!smallHeap.isEmpty() && largeHeap.peek()>smallHeap.peek()){
            int large = largeHeap.poll();
            int small = smallHeap.poll();
            largeHeap.add(small);
            smallHeap.add(large);
        }

    }
    
    public double findMedian() {
        if(largeHeap.size()>smallHeap.size()){
            int ele = largeHeap.peek();
            return (double) ele;
        }

        double ele1 = (double) largeHeap.peek();
        double ele2 = (double) smallHeap.peek();

        return (double) (ele1+ele2)/2;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */