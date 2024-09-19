class MedianFinder {
    PriorityQueue<Integer> left;
    PriorityQueue<Integer> right;
    public MedianFinder() {
        left = new PriorityQueue<Integer>(Collections.reverseOrder()); // half of list where top is median element (descending)
        right = new PriorityQueue<Integer>(); // half of list where top is median element (ascending)
    }
    
    public void addNum(int num) {
        // add to left by default or when median is greater than num
        if(left.isEmpty() || left.peek()>=num){
            left.add(num);
        }
        // otherwise add to right
        else{
            right.add(num);
        }
        // attempt to balance sides
        if(left.size()>right.size()+1){
            right.add(left.remove());
        }
        else if(left.size()<right.size()){
            left.add(right.remove());
        }
    }
    
    public double findMedian() {
        if(left.size()>right.size()){
            return (double)left.peek();
        }
        else{
            return ((double)left.peek()+(double)right.peek())/2.0;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */