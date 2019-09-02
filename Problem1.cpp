/* Time Complexity : O(nlogn)
Space Complexity : O(n)
Did it run on leetcode?  : Yes
Problems faced? : No
*/

class Solution {
public:
    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
    vector<vector<int>> res;    // Store the final result. 
        
    vector<int> nums; // Store the elements that add up to the target in a single pass.
    sort(candidates.begin(), candidates.end());// Sort the given input list.
        
    dfs(candidates, target, 0, nums, res);// Depth First Search in the array.
        
    return res;
}

void dfs(vector<int>& candidates, int target, int index, vector<int>& nums, vector<vector<int>>& res) {
    if (target < 0)
        return;
    if (target == 0) {
        res.push_back(nums);
        return;
    }
    for (int i=index; i<candidates.size(); i++) {
        nums.push_back(candidates[i]);
        
        dfs(candidates, target-candidates[i], i, nums, res); // Recursive function call.
        nums.pop_back();
    }
}
};