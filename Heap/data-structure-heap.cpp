#include<iostream>
#include<vector>

using namespace std;

class maxHeap{
private:
    vector<int> heap;
    void heapifyUp(int index){
        while(index > 0 && heap[index] > heap[(index - 1) / 2]){
            swap(heap[index], heap[(index - 1)/2]);
            index = (index - 1) / 2;
        }
    }
//        10
//      8     7
//   6    5  4   3
// 2   1          
// pop()
//       8 
//     6    7
//  2  5  4   3
// 1          

    void heapifyDown(int index){
        int left = index * 2 + 1;
        int right = index * 2 + 2;
        int largest = index;

        if(left < heap.size() && heap[left] > heap[right]){
            largest = left;
        }

        if(right < heap.size() && heap[left] < heap[right]){
            largest = right;
        }

        if(largest != index){
            swap(heap[index], heap[largest]);
            heapifyDown(largest);
        }
    }
public:
    void push(int val) {
        heap.push_back(val);
        heapifyUp(heap.size() - 1);
    }

    void pop() {
        if (heap.empty()) return;
        heap[0] = heap.back();
        heap.pop_back();
        heapifyDown(0);
    }

    int top() {
        return heap.empty() ? -1 : heap[0];
    }
 
    bool empty() {
        return heap.empty();
    }
    void printHeap(){
        for(int i : heap) cout << i << " "; cout << endl;
    }
};

int main(){
    vector<int> v = {10, 8, 7, 6, 5, 4, 3, 2, 1};
    maxHeap h;
    for(int i : v) h.push(i);

    h.printHeap();
    h.pop();
    h.printHeap();
}