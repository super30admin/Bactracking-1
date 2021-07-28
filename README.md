# Bactracking-1

## Problem1

Combination Sum (https://leetcode.com/problems/combination-sum/)

Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.

The same repeated number may be chosen from candidates unlimited number of times.

Note:

All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
Example 1:

Input: candidates = [2,3,6,7], target = 7,
A solution set is:
[
[7],
[2,2,3]
]
Example 2:

Input: candidates = [2,3,5], target = 8,
A solution set is:
[
[2,2,2,2],
[2,3,3],
[3,5]
]

//Time Complexity = Exponential
//Space Complexity = Exponential

// class Solution {
// List<List<Integer>> result;
// public List<List<Integer>> combinationSum(int[] candidates, int target) {
// result = new ArrayList();

// if(candidates == null) {
// return result;
// }
// helper(candidates, target, 0, new ArrayList<Integer>());
// return result;

// }
// private void helper(int[] candidates, int target, int index, List<Integer> path) {
// //base
// if(target < 0 || index == candidates.length) {
// return;
// }
// if(target == 0) {
// result.add(new ArrayList(path));
// return;
// }
// //dont choose
// helper(candidates, target, index+1, path);
// path.add(candidates[index]);
// //choose
// helper(candidates, target - candidates[index], index, path);
// path.remove(path.size() - 1);
// }
// }

class Solution {
List<List<Integer>> result;
public List<List<Integer>> combinationSum(int[] candidates, int target) {
result = new ArrayList();
if(candidates == null) {
return result;
}
helper(candidates, target, 0,new ArrayList<Integer>());
return result;
}

    private void helper(int[] candidates, int target,int pivot,List path) {
        if(target < 0) {
            return;
        }
        if(target == 0) {
            result.add(new ArrayList(path));
            return;
        }

        for(int i = pivot; i < candidates.length; i++) {
            path.add(candidates[i]);
            helper(candidates, target - candidates[i], i, path);
            path.remove(path.size() - 1);
        }

    }

}

## Problem2

Expression Add Operators(https://leetcode.com/problems/expression-add-operators/)

Given a string that contains only digits 0-9 and a target value, return all possibilities to add binary operators (not unary) +, -, or \* between the digits so they evaluate to the target value.

Example 1:

Input: num = "123", target = 6
Output: ["1+2+3", "1*2*3"]
Example 2:

Input: num = "232", target = 8
Output: ["2*3+2", "2+3*2"]
Example 3:

Input: num = "105", target = 5
Output: ["1*0+5","10-5"]
Example 4:

Input: num = "00", target = 0
Output: ["0+0", "0-0", "0*0"]
Example 5:

Input: num = "3456237490", target = 9191
Output: []

//Time Complexity = Exponential
//Space Complexity = Exponential

class Solution {
List<String> result;
public List<String> addOperators(String num, int target) {
result = new ArrayList<>();

        helper(num, target, 0, 0, 0, new StringBuilder());
        return result;
    }
    private void helper(String num, int target, int index, long calc, long tail,StringBuilder sb) {
        //base
        if(index == num.length()) {
            if(calc == target) {
                result.add(sb.toString());
            }
            return;
        }
        //logic
        for(int i = index; i < num.length(); i++) {
            if(num.charAt(index) == '0' && i != index) {
                break;
            }
            Long current = Long.parseLong(num.substring(index, i+1));
            int len = sb.toString().length();
            if(index == 0) {
                sb.append(current);
                helper(num, target, i + 1, current, current, sb);
                sb.setLength(len);
            } else {
                //+
                sb.append("+");
                sb.append(current);
                helper(num, target, i + 1,calc + current, current, sb);
                sb.setLength(len);
                //-
                sb.append("-");
                sb.append(current);
                helper(num, target, i + 1,calc - current, -current, sb);
                sb.setLength(len);
                //*
                sb.append("*");
                sb.append(current);
                helper(num, target, i + 1,calc - tail + tail * current, tail * current, sb);
                sb.setLength(len);
            }

        }
    }

}
