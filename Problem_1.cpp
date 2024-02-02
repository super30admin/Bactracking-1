/*
 ? Problem: Combination Sum
 * Time Complexity : O(N^(T/M) + 1) -> N = number of candidates, T = target value, M = min value among candidates
 * Space Complexity : O(T/M)
 * Did this code successfully run on Leetcode : Yes
 * Any problem you faced while coding this : No
*/

#include <vector>

class Solution {
private:
    std::vector<std::vector<int>> results;
    void dfs(int curr_index, std::vector<int>& candidates, const int& target, int curr_sum, std::vector<int>& sublist) {
        if(curr_sum > target) return;

        if(curr_sum == target) {
            results.push_back(sublist);
            return;
        }

        for(int i = curr_index; i < candidates.size(); i++) {
            sublist.push_back(candidates[i]);
            curr_sum += candidates[i];
            dfs(i, candidates, target, curr_sum, sublist);
            curr_sum -= candidates[i];
            sublist.pop_back();
        }
    }
public:
    std::vector<std::vector<int>> combinationSum(std::vector<int>& candidates, int target) {
        std::vector<int> sublist = {};
        int n = candidates.size();

        dfs(0, candidates, target, 0, sublist);

        return results;
    }
};