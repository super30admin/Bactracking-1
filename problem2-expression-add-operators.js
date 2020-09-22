//https://leetcode.com/problems/expression-add-operators/
//// Time Complexity :
//// Space Complexity :
//// Did this code successfully run on Leetcode :
//// Any problem you faced while coding this :

//// Your code here along with comments explaining your approach

///**
// * @param {string} num
// * @param {number} target
// * @return {string[]}
// */
var addOperators;

addOperators = function(nums, target) {
  var backtracking, output;
  output = [];
  backtracking = function(index, expr, prevSum, prevAddition) {
    var curr;
    if (index >= nums.length) {
      if (prevSum === target) {
        output.push(expr);
      }
      return;
    }
    curr = parseInt(nums[index]);
    if (index === 0) {
      return backtracking(index + 1, nums[index], curr, curr);
    } else {
      // +
      backtracking(index + 1, expr + '+' + nums[index], prevSum + curr, curr);
      // -
      backtracking(index + 1, expr + '-' + nums[index], prevSum - curr, curr * -1);
      // *
      return backtracking(index + 1, expr + '*' + nums[index], prevSum - prevAddition + prevAddition * curr, prevAddition * curr);
    }
  };
  backtracking(0, '', 0, 0);
  return output;
};

addOperators("123", 6);

//# sourceMappingURL=problem2-expression-add-operators.js.map
