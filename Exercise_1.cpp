// Time Complexity                              :  Exponential. N ^ (Target/Minimum of all values in the candidate array)
// Space Complexity                             :  O(Target/Minimum Value) -> since the maximum depth 
//                                                 of the tree can be Target/Minimum value in the candidates array.
//                                                 In this particular case, the recursion will run for (Target/Minimum value in the candidates array) times.
// Did this code successfully run on Leetcode   :  Yes
// Any problem you faced while coding this      :  No

#include <bits/stdc++.h> 
using namespace std;  

// https://leetcode.com/problems/combination-sum/submissions/

class Solution {
private:
    set<vector<int>> st;int sz;
    vector<vector<int>> ans;
public:
    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        sz = candidates.size();
        vector<int> lv;
        // cSum(candidates, target, localVec);
        // vector<vector<int>> ans(begin(st), end(st));
        cSum2(candidates, 0, lv, target);
        return ans;
    }
    
    // using set
    void cSum(vector<int>& candidates, int target, vector<int> localVec) {
        if(target < 0) return;
        if(target == 0) {
            sort(begin(localVec), end(localVec));
            st.insert(localVec);
            return;
        }
        
        for(int i=0;i<sz;i++) {
            if(target - candidates[i] < 0) continue;
            localVec.push_back(candidates[i]);
            cSum(candidates, target - candidates[i], localVec);    
            localVec.pop_back();
        }
    }
    
    // using vector
    void cSum2(vector<int>& candidates, int ci, vector<int> lv, int target) {
        if(target < 0) return;
        
        if(target == 0) {
            ans.push_back(lv);
            return;
        }
        
        for(int i=ci;i<sz;i++) {
            lv.push_back(candidates[i]);
            cSum2(candidates,i,lv,target - candidates[i]);
            lv.pop_back();
        }
    }
};