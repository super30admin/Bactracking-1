## Problem1 
Combination Sum (https://leetcode.com/problems/combination-sum/)

// Time Complexity - exponential
// Space Complexity - exponential

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) {
            return new ArrayList<>();
        }
        result = new ArrayList<>();
        helper(candidates, target, 0, new ArrayList<>());
        return result;
    }
    private void helper(int[] candidates, int target, int index, List<Integer> path) {
        if (index == candidates.length || target < 0) {
            return;
        }
        if (target == 0) {
            result.add(path);
            return;
        }
        helper(candidates, target, index + 1, new ArrayList<>(path));
        path.add(candidates[index]);
        helper(candidates, target - candidates[index], index, new ArrayList<>(path));
    }
}

// 2nd approach using bactracking

// Time Complexity - 0(n^target) because algorithm explores all possible combinations of the candidates to form the target sum.
// Space Complexity - 0(target) because maximum depth of the recursive calls is limited by the target value
 
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) {
            return new ArrayList<>();
        }
        result = new ArrayList<>();
        helper(candidates, 0, target, new ArrayList<>());
        return result;       
    }
    private void helper(int[] candidates, int index, int target, List<Integer> path) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            path.add(candidates[i]);

            helper(candidates, i, target - candidates[i], path);

            path.remove(path.size() - 1);
        }
    }
}


## Problem2
Expression Add Operators(https://leetcode.com/problems/expression-add-operators/)

// Time Complexity - O(4^N), where N is the length of the input string num. The reason for this is that at each position in 
//                   the input string, we have 4 choices: we can either place a '+', '-', '*', or no operator
// Space Complexity - O(N) because the depth of the recursion is limited by the length of the input string num. 
//                    Additionally, at each level of recursion, a new string is created to store the current path. 


class Solution {
    List<String> result;
    public List<String> addOperators(String num, int target) {
        if (num == null || num.length() == 0) {
            return new ArrayList<>();
        }
        result = new ArrayList<>();
        helper(num, target, 0, 0, 0, "");
        return result;
        
    }
    private void helper(String num, int target, int index, long calc, long tail, String path) {
        if (index == num.length()) {
            if (calc == target) {
                result.add(path);
            }
        }
        for (int i = index; i < num.length(); i++) {
            if (num.charAt(index) == '0' && index != i) {
                continue;
            }
            long curr = Long.parseLong(num.substring(index, i + 1));
            if (index == 0) {
                helper(num, target, i + 1, curr, curr, path + curr);
            }
            else {
                helper(num, target, i + 1, calc + curr, +curr, path + '+' + curr);
                helper(num, target, i + 1, calc - curr, -curr, path + '-' + curr);
                helper(num, target, i + 1, calc - tail + tail * curr, tail * curr, path + '*' + curr);

            }
        }
    }
}