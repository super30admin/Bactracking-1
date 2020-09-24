// Problem 1 - Combination Sum
// Time Complexity: O(n^n)
// Space Complexity: O(max. length of smallest number repeated) -> recursive stack

// Algorithm
// 1 - call backtracking with initial values
// 2 - if target goes negative, return
// 3 - if target equals 0, add path to output
// 4 - if index goes out of bounds, return
// 5 - loop over candidates from index
// 6 - add value to path
// 7 - call backtracking
// 8 - remove last value from path
class Solution {
  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    List<List<Integer>> output = new ArrayList<>();

    if (candidates == null || candidates.length == 0) {
      return output;
    }

    List<Integer> path = new ArrayList<>();
    // 1
    backtracking(output, candidates, target, 0, path);

    return output;
  }

  private void backtracking(List<List<Integer>> output, int[] candidates, int target, int index, List<Integer> path) {
    // 2
    if (target < 0) {
      return;
    } else if (target == 0) { // 3
      output.add(new ArrayList<>(path));
      return;
    } else if (index >= candidates.length) { // 4
      return;
    }
    // 5 
    for (int i=index; i<candidates.length; i++) {
      // 6
      path.add(candidates[i]);
      // 7
      backtracking(output, candidates, target - candidates[i], i, path);
      // 8
      path.remove(path.size() - 1);
    }
  }
}

// Problem 2 - Expression Add Operators
// Time Complexity: O(n^n)
// Space Complexity: O(n) -> recursive stack

// Algorithm
// 1 - call backtracking with initial values
// 2 - check for base condition if index equals length and previous sum equals target, add expression to output
// 3 - else for recursive condition, loop over the length of string starting from index
// 4 - get current number
// 5 - if current character is '0' and i not equals index, then skip the backtracking
// 6 - for index 0, backtracking with current num
// 7 - else backtracking for '+' operator
// 8 - else backtracking for '-' operator
// 9 - else backtracking for '*' operator
class Solution {
  public List<String> addOperators(String num, int target) {
    List<String> output = new ArrayList<>();
    if (num == null || num.length() == 0) {
      return output;
    }
    // 1
    backtracking(output, num, target, 0, "", 0, 0);

    return output;
  }

  private void backtracking(List<String> output, String num, int target, int index, String exp, long prevSum, long prevAdd) {
    // 2
    if (index >= num.length()) {
      if (prevSum == target) {
        output.add(exp);
      }
      return;
    }
    // 3
    for (int i=index; i<num.length(); i++) {
      // 4
      long curr = Long.parseLong(num.substring(index, i+1));
      // 5
      if (num.charAt(index) == '0' && i != index) {
        continue;
      }
      // 6
      if (index == 0) {
        backtracking(output, num, target, i + 1, exp + curr, curr, curr);
      } else {
        // 7
        backtracking(output, num, target, i + 1, exp + "+" + curr, prevSum + curr, curr);
        // 8
        backtracking(output, num, target, i + 1, exp + "-" + curr, prevSum - curr, -curr);
        // 9
        backtracking(output, num, target, i + 1, exp + "*" + curr, prevSum - prevAdd + prevAdd * curr, prevAdd * curr);
      }
    }
  }
}
