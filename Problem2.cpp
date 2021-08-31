// Time Complexity :O(N*4^N)
// Space Complexity : O(N) Call stack size
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Expression add operators

#include<vector>
#include<iostream>
using namespace std;

class Solution {
    vector<string> result;
public:
    vector<string> addOperators(string num, int target) {
        if(num.size() == 0) return result;
        helper(num, target, 0, 0, "", 0);
        return result;
    }
    void helper(string num, int target, long calc, long tail,string path, int index){
        //base

        if(index == num.size()){
            if(target == calc){
                result.push_back(path);
                return;
            } 
        }

        //logic
        
        for(int i = index; i < num.size(); i++){
            if(num[index] == '0' && index != i) 
                continue;
            long curr = stol(num.substr(index,i-index+1));
            if(index == 0){
                helper(num,target,curr,curr,path + to_string(curr), i+1);
            }
            else{
                //  + case
                helper(num, target, calc + curr, curr, path + '+' + to_string(curr), i+1);
                //  - case
                helper(num, target, calc - curr, -curr, path + '-' + to_string(curr), i+1);
                //  * case
                helper(num, target, calc - tail + tail * curr, tail * curr, path + '*' + to_string(curr), i+1);
            }
        }
        
    }
};