// Time Complexity : O(2^n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

var result;
var combinationSum = function (candidates, target) {
    result = [];
    if (!candidates || candidates.length === 0) return result;
    helper(candidates, target, 0, []);
    return result;
};

var helper = function (candidates, target, index, path) {
    //base
    if (target < 0) return;
    if (target === 0) {
        result.push(path.slice());
        console.log(result);
        return;
    }
    //logic
    for (let i = index; i < candidates.length; i++) {
        path.push(candidates[i]);
        helper(candidates, target - candidates[i], i, path);
        path.pop();


    }

}