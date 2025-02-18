#include<iostream>
#include<vector>

using namespace std;

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
        int largest = index;

        if(left < heap.size() && cmp(heap[left], heap[right]))
            largest = left;
        if(right < heap.size() && !cmp(heap[left], heap[right]))
            largest = right;

        if(largest != index){
            swap(heap[largest], heap[index]);
            heapifyDown(largest);
        }
    }
public:
    MyHeap(): isMinHeap(false){}
    MyHeap(const bool& isMinHeap): isMinHeap(isMinHeap){}
    MyHeap(const string& s): isMinHeap(s == "minHeap" ? true : false){}
    
    bool empty() const {return heap.empty();}

    void push(int val){
        heap.push_back(val);
        heapifyUp(heap.size() -1);
    }

    void pop(){
        if(empty()) return;
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

int main(){
    MyHeap h(true);
    vector<int> v = {1,2,3,4,5,6,5,4,3,5,7,10,20,23,1,24,23};
    for(int i : v) h.push(i);
    for(int i : h.getValues()) cout << i << " "; cout << endl;
    h.pop();
    for(int i : h.getValues()) cout << i << " "; cout << endl;
    h.pop();
    for(int i : h.getValues()) cout << i << " ";cout << endl;
    h.pop();
    for(int i : h.getValues()) cout << i << " "; cout << endl;
    h.pop();
    for(int i : h.getValues()) cout << i << " "; cout << endl;
    h.pop();
    for(int i : h.getValues()) cout << i << " "; cout << endl;
    h.push(60);
    h.pop();
    for(int i : h.getValues()) cout << i << " "; cout << endl;
    return 0;
}