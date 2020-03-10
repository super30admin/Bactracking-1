// Time Complexity : O(4^N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes, this problem was really hard for me to wrap my head around.  I think I got it now.

/**
 * @param {string} num
 * @param {number} target
 * @return {string[]}
 */
let result;
var addOperators = function(num, target) {
    result = [];
    helper(num, target, 0, 0, [], 0);
    return result;
};

var helper = function(num, target, calc, tail, path, index) {
    console.log(path);
    // Base Case
    if (index == num.length) {
        if (calc == target) {
            result.push([...path].join(""));
            return;
        }
    }
    
    // Logic
    for (let i = index; i < num.length; i++) {
        if (i != index && num[index] == '0') break;
        let curr = parseInt(num.substring(index, i + 1));
        if (index == 0) {
            path.push(curr);
            helper(num, target, curr, curr, path, i + 1);
            path.pop();
        } else {
            path.push("+", curr);
            helper(num, target, calc + curr, curr, path, i + 1);
            path.pop()
            path.pop();
            
            path.push("-", curr);
            helper(num, target, calc - curr, -curr, path, i + 1);
            path.pop()
            path.pop();
            
            path.push("*", curr);
            helper(num, target, calc - tail + tail * curr, tail * curr, path, i + 1);
            path.pop()
            path.pop();
        }
    }
}
