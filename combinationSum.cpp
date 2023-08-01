// Time complexity: 2^(m+n);
// space compexity: 2^(m+n);

class Solution {
    vector<vector<int>> result;
    vector<int> path;
public:
    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        helper(candidates,0,target);
        return result;
        
    }

    void helper(vector<int> candidates, int i, int target){
        if(target <0 || i==candidates.size()){
            return;
        }
        if(target == 0){
            vector<int> p = path;
            result.push_back(p);
            return;
        }

        path.push_back(candidates[i]);
        helper(candidates,i,target-candidates[i]);
        path.pop_back();
        helper(candidates,i+1,target);
    }
};