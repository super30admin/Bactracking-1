// Time Complexity : O(N) N = number of nodes in recursion tree
// Space Complexity : O(N) hashtable size
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

var combinationSum = function(candidates, target) {
    var finalArray = [];
    calculateCombinationSum(candidates, target, [], 0, finalArray);
    return finalArray;
};

function calculateCombinationSum(candidates, target, sumArray, start, result) {
    if (target < 0) {
        return;
    }
    if(target == 0) {
        result.push([...sumArray]);
    }
    if(target > 0) {
        for(let i=start;i<candidates.length;i++) {
            sumArray.push(candidates[i]);
            calculateCombinationSum(candidates, target-candidates[i], sumArray, i, result);
            sumArray.pop();
        }
    }
}
    
