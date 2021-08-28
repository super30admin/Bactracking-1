// Time Complexity : O(N)
// Space Complexity :O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
public:
    vector<vector<int>> result;
    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        if(candidates.empty() || candidates.size() == 0)
            return result;
        vector<int> path;
        recurse(candidates, target, 0, path);
        return result;
    }
    void recurse(vector<int>& candidates, int target, int index, vector<int> path){
        //base
        if(target == 0){
            result.push_back(path);
            return;
        }
        if(target<0 || index == candidates.size())
            return;
        //logic
        //do not choose
        recurse(candidates, target, index+1, path);
        path.push_back(candidates[index]);
        //choose
        recurse(candidates, target - candidates[index], index, path);
    }
};

//choosing first and than not choosing
class Solution {
public:
    vector<vector<int>> result;
    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        if(candidates.empty() || candidates.size() == 0)
            return result;
        vector<int> path;
        recurse(candidates, target, 0, path);
        return result;
    }
    void recurse(vector<int>& candidates, int target, int index, vector<int> path){
        //base
        if(target == 0){
            result.push_back(path);
            return;
        }
        if(target<0 || index == candidates.size())
            return;
        //logic
        
        //choose
        vector<int> copy(path);
        copy.push_back(candidates[index]);
        recurse(candidates, target - candidates[index], index, copy);
        //do not choose
        recurse(candidates, target, index+1, path);
    }
};

//backtracking
class Solution {
public:
    vector<vector<int>> result;
    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        if(candidates.empty() || candidates.size() == 0)
            return result;
        vector<int> path;
        recurse(candidates, target, 0, path);
        return result;
    }
    void recurse(vector<int>& candidates, int target, int index, vector<int> path){
        //base
        if(target == 0){
            result.push_back(path);
            return;
        }
        if(target<0 || index == candidates.size())
            return;
        //logic
        //do not choose
        
        recurse(candidates, target, index+1, path);
        //choose
        //action
        path.push_back(candidates[index]);
        recurse(candidates, target - candidates[index], index, path);
        //backtract
        path.pop_back();
    }
};

//using loop and recursion
class Solution {
public:
    vector<vector<int>> result;
    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        if(candidates.empty() || candidates.size() == 0)
            return result;
        vector<int> path;
        recurse(candidates, target, 0, path);
        return result;
    }
    void recurse(vector<int>& candidates, int target, int index, vector<int> path){
        //base
        if(target == 0){
            result.push_back(path);
            return;
        }
        if(target<0)
            return;
        //logic
        for(int i=index; i<candidates.size(); i++){
            vector<int> copy(path);
            copy.push_back(candidates[i]); // used copy becuase we are choosing first so.
            recurse(candidates, target-candidates[i], i, copy);
        }
    }
};

//backtrack and loop
class Solution {
public:
    vector<vector<int>> result;
    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        if(candidates.empty() || candidates.size() == 0)
            return result;
        vector<int> path;
        recurse(candidates, target, 0, path);
        return result;
    }
    void recurse(vector<int>& candidates, int target, int index, vector<int> path){
        //base
        if(target == 0){
            result.push_back(path);
            return;
        }
        if(target<0)
            return;
        //logic
        for(int i=index; i<candidates.size(); i++){
            //action
            path.push_back(candidates[i]);
            //recursion
            recurse(candidates, target-candidates[i], i, path);
            //backtrack
            path.pop_back();
        }
    }
};
