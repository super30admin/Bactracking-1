// Combination Sum (https://leetcode.com/problems/combination-sum/)

// Time Complexity: Exponential
// Space Complexity: O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

let result;
var helper = (candidates, target, index, path) => {
    // Base
    if (target < 0) {
        return;
    } else if (target === 0) {
        result.push(Array.from(path));
        return;
    }
    // Logic
    for (let i = index; i < candidates.length; i++) {
        // Action
        path.push(candidates[i]);
        // Recurse
        helper(candidates, target - candidates[i], i, path);
        // Backtrack
        path.pop();
    }
}

/**
 * @param {number[]} candidates
 * @param {number} target
 * @return {number[][]}
 */
var combinationSum = function (candidates, target) {
    if (candidates === null || candidates.length === 0)
        return [];
    result = [];
    helper(candidates, target, 0, []);
    return result;
};