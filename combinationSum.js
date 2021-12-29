// Time Complexity : O(2^n) - exponential
// Space Complexity : O(n) - recursive stack
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Backtracking approach - most efficient
var combinationSum = function (candidates, target) {
  const resultsArr = [];
  if (!candidates.length) return resultsArr;

  const helper = (candidates, target, index, path) => {
    // Base
    if (target === 0) {
      // push a new array - with all elements in path up until this point
      // because path will be empty once the stack unwinds
      resultsArr.push([...path]);
      return;
    }

    if (index === candidates.length || target < 0) {
      return;
    }

    // logic
    //Zero Case - do not choose
    helper(candidates, target, index + 1, path);

    // One case - choose
    path.push(candidates[index]); // action
    helper(candidates, target - candidates[index], index, path); // recursion
    path.pop(); // backtracking
  };

  helper(candidates, target, 0, []);
  return resultsArr;
};

// Not as efficient because we create a new array and copy over
// elements from path to store, each time recursion is performed.
var combinationSum = function (candidates, target) {
  const resultsArr = [];
  if (!candidates.length) return resultsArr;

  const helper = (candidates, target, index, path) => {
    // Base
    if (target === 0) {
      resultsArr.push(path);
      return;
    }

    if (index === candidates.length || target < 0) {
      return;
    }

    // logic
    //Zero Case - do not choose
    helper(candidates, target, index + 1, path);

    // One case - choose
    const newPath = [...path];
    newPath.push(candidates[index]);
    helper(candidates, target - candidates[index], index, newPath);
  };

  helper(candidates, target, 0, []);
  return resultsArr;
};

// Iterative recursion approach:
var combinationSum = function (candidates, target) {
  const resultsArr = [];
  if (!candidates.length) return resultsArr;

  const helper = (candidates, target, index, path) => {
    // base conditions
    if (target === 0) {
      resultsArr.push(path);
    }

    if (target < 0 || index === candidates.length) {
      return;
    }

    // logic
    for (let i = index; i < candidates.length; i++) {
      let newPath = [...path];
      newPath.push(candidates[i]);
      helper(candidates, target - candidates[i], i, newPath);
    }
  };

  helper(candidates, target, 0, []);
  return resultsArr;
};

//  Iterative recursion with backtracking - more efficient than above
var combinationSum = function (candidates, target) {
  const resultsArr = [];
  if (!candidates.length) return resultsArr;

  const helper = (candidates, target, index, path) => {
    // base conditions
    if (target === 0) {
      resultsArr.push([...path]);
    }

    if (target < 0 || index === candidates.length) {
      return;
    }

    // logic
    for (let i = index; i < candidates.length; i++) {
      path.push(candidates[i]); // action
      helper(candidates, target - candidates[i], i, path); // recurse
      path.pop(); // backtracking
    }
  };

  helper(candidates, target, 0, []);
  return resultsArr;
};
