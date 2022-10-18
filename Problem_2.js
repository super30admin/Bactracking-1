// Expression Add Operators(https://leetcode.com/problems/expression-add-operators/)
// TC: O(4^N)
// SC: O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

let result;
var helper = (num, target, index, path, calc, tail) => {
    // Base
    if (index === num.length) {
        // console.log("final path: ",path);
        if (calc === target)
            result.push(path);
        return;
    }

    // Logic
    for (let i = index; i < num.length; i++) {
        if (index !== i && num[index] === "0") continue;
        let curr = Number(num.slice(index, i + 1));
        if (index === 0) {
            // For the 1st digit
            helper(num, target, i + 1, path + curr, curr, curr);
        } else {
            // +
            helper(num, target, i + 1, path + '+' + curr, calc + curr, curr);
            // -
            helper(num, target, i + 1, path + '-' + curr, calc - curr, -curr);
            // *
            helper(num, target, i + 1, path + '*' + curr, (calc - tail + (tail * curr)), curr * tail);
        }
    }
}
/**
 * @param {string} num
 * @param {number} target
 * @return {string[]}
 */
var addOperators = function (num, target) {
    if (num === null || num.length === 0)
        return [];
    result = [];
    helper(num, target, 0, "", 0, 0);
    return result;
};