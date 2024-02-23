// TC = O(Target/ min + n); min = min of candidates, n = length of candidates
// SC = O(Target/ min + n); min = min of candidates, n = length of candidates
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
public:
    vector<vector<int>> result;
    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        // Backtrack
        // TC = O(Target/ min + n); min = min of candidates, n = length of candidates
        // SC = O(Target/ min + n); min = min of candidates, n = length of candidates
        // null 
        if(candidates.size() == 0) return result;
        helper(candidates, target, 0, vector<int>());
        return result;
    }
    // For loop based
    // void helper(vector<int>& candidates, int target, int index, vector<int> path) {
    //     // base
    //     if(target == 0) {
    //         result.push_back(path);
    //         return;
    //     }
    //     if(target < 0) return;
    //     // logic
    //     for(int i = index; i < candidates.size(); i++) {
    //         // action
    //         path.push_back(candidates[i]);
    //         // recurse
    //         helper(candidates, target - candidates[i], i, path);
    //         // backtrack
    //         path.erase(path.end() - 1);
    //     }
    // }
    void helper(vector<int>& candidates, int target, int index, vector<int> path) {
        // base
        if(target == 0) {
            // result.push_back(path); //it wont work as we pass by reference or it'll return empty list
            result.push_back(vector<int>(path));
            return;
        }
        if(index == candidates.size() || target < 0) return;
        // logic
        // no choose
        helper(candidates, target, index + 1, path);
        // choose
        // action
        path.push_back(candidates[index]);
        // recurse
        helper(candidates, target - candidates[index], index, path);
        // backtrack
        path.erase(path.end() - 1); // erase fn for vector
    }
};