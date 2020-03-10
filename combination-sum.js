// Time Complexity : O(2^N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/**
 * @param {number[]} candidates
 * @param {number} target
 * @return {number[][]}
 */
let result;
var combinationSum = function(candidates, target) {
    // Edge Case
    if (!candidates || !candidates.length || target == 0) return [[]];
    result = [];
    backtrack(candidates, target, 0, 0, []);
    return result;
};

var backtrack = function(candidates, target, sum, index, temp) {
    // Base Case
    if (sum == target) {
        result.push([...temp]);
        return;
    }
    if (sum > target) return;
    
    // Logic
    for (let i = index; i < candidates.length; i++) {
        // Action
        temp.push(candidates[i]);
        // Recurse
        backtrack(candidates, target, sum + candidates[i], i, temp);
        // Backtrack
        temp.pop();
    }
};
