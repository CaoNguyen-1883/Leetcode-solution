#include"LeetCodeLibs.h"


int main(){
    vector<int> v = {1, 2, -2, 3, -5};

    int l = 0, r = v.size() - 1;

    while(l < r){
        while(l < r && v[r] < 0) --r;
        while(l < r && v[l] > 0) ++l;
        if(l < r){
            swap(v[l], v[r]);
        }
    }
    return 0;
}