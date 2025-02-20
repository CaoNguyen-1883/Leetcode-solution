#include"LeetCodeLibs.h"
class MyHeap{
    private:
        vector<int> heap;
    
        bool isMinHeap;
    
        bool cmp(const int& a, const int& b){
            return isMinHeap ? a < b : a > b;
        }
    
        void heapifyUp(int index){
            while(index > 0 && cmp(heap[index], heap[(index - 1) / 2])){
                swap(heap[index], heap[(index - 1) / 2]);
                index = (index - 1) / 2;
            }
        }
    
    
        void heapifyDown(const int& index){
            int left = index * 2 + 1;
            int right = index * 2 + 2;
            int _index = index;
    
            if(left < heap.size() && cmp(heap[left], heap[right]))
                _index = left;
            if(right < heap.size() && !cmp(heap[left], heap[right]))
                _index = right;
    
            if(_index != index){
                swap(heap[_index], heap[index]);
                heapifyDown(_index);
            }
        }
    public:
        MyHeap(): isMinHeap(false){}
        MyHeap(bool minHeap): isMinHeap(minHeap){}
        
        bool empty() const {return heap.empty();}
    
        int size() const{return heap.size();}
    
        void push(int val){
            heap.push_back(val);
            heapifyUp(heap.size() -1);
        }
    
        void pop(){
            if(empty()) return;
            if(heap.size() ==  1){
                heap.pop_back();
                return ;
            }
            heap[0] = heap.back();
            heap.pop_back();
            heapifyDown(0);
        }
    
    
        int top(){
            return empty() ? -1 : heap[0];
        }
    
        vector<int> getValues(){
            vector<int> copyHeap(heap);
            return copyHeap;
        }
    
    };
    
    
    class MedianFinder {
    private:
        MyHeap maxHeap;
        MyHeap minHeap = *(new MyHeap(true));
    public:
    
        void addNum(int num) {
            if(maxHeap.empty() || num <= maxHeap.top()) maxHeap.push(num);
            else minHeap.push(num);
            
            if(maxHeap.size() < minHeap.size()){
                maxHeap.push(minHeap.top());
                minHeap.pop();
            } else if(maxHeap.size() - minHeap.size() > 1){
                minHeap.push(maxHeap.top());
                maxHeap.pop();
            }
        }
    
        double findMedian() {
            if (maxHeap.size() == minHeap.size())
                return (maxHeap.top() + minHeap.top()) / 2.0;
            return maxHeap.top();
        }
    
    };
    
/**
    * Your MedianFinder object will be instantiated and called as such:
    * MedianFinder* obj = new MedianFinder();
    * obj->addNum(num);
    * double param_2 = obj->findMedian();
*/