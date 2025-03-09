
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

class MedianFinder {

    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        if(maxHeap.isEmpty() || num >= maxHeap.peek()){
            maxHeap.offer(num);
        } else{
            minHeap.offer(num);
        }

        if(minHeap.size() > maxHeap.size()){
            maxHeap.offer(minHeap.poll());
        } else if(maxHeap.size()  - minHeap.size() > 1){
            minHeap.offer(maxHeap.poll());
        }
    }
    
    public double findMedian() {
        if(minHeap.size() == maxHeap.size()){
            return (minHeap.peek() + maxHeap.peek()) / 2.0;
        } else{
            return (double)maxHeap.peek();
        }
    }
}

// 1 2 3 4 5
// minheap: 3 4 5
// maxheap: 2 1