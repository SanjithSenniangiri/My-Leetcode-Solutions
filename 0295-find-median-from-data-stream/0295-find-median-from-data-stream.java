class MedianFinder {
    // List<Integer> ls;
    PriorityQueue<Integer> min;
    PriorityQueue<Integer> max;
    public MedianFinder() {
        // ls = new ArrayList<>();
        min = new PriorityQueue();
        max = new PriorityQueue(Collections.reverseOrder());
    }
    
    public void addNum(int num) {
        // ls.add(num);
        if(max.isEmpty())
        {
            max.add(num);
            return;
        }

        if(num> max.peek())
        {
            min.add(num);
        }

        if(num<=max.peek())
        {
            max.add(num);
        }


        if(min.size() - max.size() > 1)
        {
            int val = min.remove();
            max.add(val);
        }

        if(max.size() - min.size() > 1)
        {
            int val = max.remove();
            min.add(val);
        }
    }
    
    public double findMedian() {
        if(min.size()==0 || max.size() > min.size())
        {
            return max.peek();
        }

        if(max.size() ==0 || min.size() > max.size())
        {
            return min.peek();
        }

        return (min.peek() + max.peek())/2.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */