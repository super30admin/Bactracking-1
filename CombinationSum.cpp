// Time Complexity : Exponential
// Space Complexity : Exponential
// Did this code successfully run on Leetcode : yes

// Your code here along with comments explaining your approach
/* Perform exhaustive search with all possible combinations. If target sum becomes 0 then add current path value to solution,
 * if solution becomes negative then simply return else keep exploring other options. 
 * Backtracking :- When calling a helper method add current value to path vector and when it comes out of helper method remove the added value from path vector.
 */

class Solution {
public:
    vector<vector<int>> results;
    
    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        
        if (candidates.size() == 0)
            return results;
        
        vector<int> path;
        helper(candidates, target, 0, path);
        return results;
    }
    
    void helper(vector<int>& candidates, int target, int index, vector<int>& path)
    {
        // Base case
        if (target == 0)
        {
            results.push_back(path);
            return;
        }
        
        if (target < 0)
        {
            return;
        }
        
        // Logic :- Loop starting with index considers choose case also.
        for (int i = index; i < candidates.size(); i++)
        {
            path.push_back(candidates[i]);
            helper(candidates, target - candidates[i], i, path);
            path.pop_back();
        }
    }
};