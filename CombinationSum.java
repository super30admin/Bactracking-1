
// Time Complexity :O(n^n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

// Your code here  with comments explaining your approach

class Solution {
  List<List<Integer>> result;

  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    result = new ArrayList<>();
    if (candidates == null || candidates.length == 0)
      return result;
    helper(candidates, target, 0, new ArrayList<>());
    return result;

  }

  private void helper(int[] candidates, int target, int index, List<Integer> path) {
    // base
    if (index == candidates.length || target < 0)
      return;

    if (target == 0) {
      result.add(new ArrayList<>(path));
      return;
    }

    // logic
    // Dont choose the current value
    helper(candidates, target, index + 1, path);
    // Choose the current value and add it to path
    path.add(candidates[index]);
    helper(candidates, target - candidates[index], index, path);
    // backtrack by removing the last possible value in combination
    path.remove(path.size() - 1);
  }
}