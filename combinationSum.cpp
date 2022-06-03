//TC = exponential

choose - not choose method - with creating new vector for each node

class Solution {
public:
    vector<vector<int>> result;
    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        if(candidates.size()==0) return result;
        helper(candidates, target,0,vector<int>());
        return result;
    }
    
    void helper(vector<int>& candidates, int target, int i, vector<int> path){
        //base
        if(target==0) {
            result.push_back(path);
            return;
        }
        if(i==candidates.size() || target<0) return;
        //logic
        //no choose
        helper(candidates,target,i+1,vector<int>(path));
        //choose
        path.push_back(candidates[i]);
        helper(candidates,target-candidates[i],i,vector<int>(path));
    }
};

//BackTracking
class Solution {
public:
    vector<vector<int>> result;
    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        if(candidates.size()==0) return result;
        helper(candidates, target,0,vector<int>());
        return result;
    }
    
    void helper(vector<int>& candidates, int target, int i, vector<int> path){
        //base
        if(target==0) {
            result.push_back(vector<int>(path));
            return;
        }
        if(i==candidates.size() || target<0) return;
        //logic
        //no choose
        helper(candidates,target,i+1,path);
        //choose
        path.push_back(candidates[i]);
        helper(candidates,target-candidates[i],i,path);
        path.pop_back();
    }
};

FOR LOOP BRUTE RECURSION
//SC = O(N*N)

class Solution {
public:
    vector<vector<int>> result;
    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        if(candidates.size()==0) return result;
        recursion(candidates, target, 0, {});
        return result;
    }
    
    void recursion(vector<int>& candidates, int target, int pivot, vector<int> path){
        //base
        if(target==0){
            result.push_back(path);
            return;
        }
        if(target<0) return;
        for(int i = pivot;i<candidates.size();i++){
            vector<int>temp(path);
            temp.push_back(candidates[i]);
            recursion(candidates,target-candidates[i],i,vector<int>(temp));
        }
    }
};


FOR LOOP RECURSION
SC = O(N) //deep copy

BACK TRACKING
class Solution {
public:
    vector<vector<int>> result;
    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        if(candidates.size()==0) return result;
        recursion(candidates, target, 0, {});
        return result;
    }
    
    void recursion(vector<int>& candidates, int target, int pivot, vector<int> path){
        //base
        if(target==0){
            result.push_back(vector<int>(path));
            return;
        }
        if(target<0) return;
        for(int i = pivot;i<candidates.size();i++){
            path.push_back(candidates[i]);
            recursion(candidates,target-candidates[i],i,path);
            path.pop_back();
        }
    }
};
