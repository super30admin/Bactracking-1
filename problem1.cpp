class Solution {
public:
     vector<vector<int>>result;
    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        
        
        vector<int> path;
        helper(candidates,target,path,0);
        return result;
    }
    
    void helper(vector<int>& candidates, int target,vector<int> path,int index) {
        
        //base
        if(target == 0) {
            result.push_back(path);
            return;
        }
        
        if(target < 0 || index == candidates.size()) {
           return; 
        }
        
        //logic
        helper(candidates,target,path,index+1);
        
        path.push_back(candidates[index]);
        helper(candidates,target-candidates[index],path,index);
 
    }
};