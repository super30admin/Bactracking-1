//https://leetcode.com/problems/combination-sum/
//// Time Complexity : O(N^N) visit all possible combinations
//// Space Complexity : O(N^N) stack space
//// Did this code successfully run on Leetcode : yes
//// Any problem you faced while coding this :

// not much way easier than previous backtracking

//// Your code here along with comments explaining your approach

// visit all combinations recursively
// deduct from target on each recursion
// if target hits 0, push to the output array
// return output
var combinationSum;

combinationSum = function(candidates, target) {
  var backtracking, output;
  output = [];
  backtracking = function(target, index, path) {
    var i, j, ref, ref1, results;
    if (target < 0) {
      return;
    }
    if (target === 0) {
      output.push(path);
      return;
    } else if (index >= candidates.length) {
      return;
    }
    results = [];
    for (i = j = ref = index, ref1 = candidates.length; (ref <= ref1 ? j < ref1 : j > ref1); i = ref <= ref1 ? ++j : --j) {
      results.push(backtracking(target - candidates[i], i, [].concat(path).concat(candidates[i])));
    }
    return results;
  };
  backtracking(target, 0, []);
  return output;
};

combinationSum([2, 3, 6, 7], 7);

//# sourceMappingURL=problem1-combination-sum.js.map
