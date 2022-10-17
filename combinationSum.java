// Recursive based solutions are bad in terms of time and space
// Approach - 1
// Executed
class Solution {
    // recursive approach
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        
        if (candidates == null || candidates.length == 0)
            return result;
        
        helper(candidates, 0, target, new ArrayList<>());
        return result;
    }
    
    private void helper(int[] candidates, int index, int target, List<Integer> path) {
        // base
        if (target < 0 || index == candidates.length)
            return;
        if (target == 0) {
            result.add(path);
            return;
        }
        // logic
        // donot choose or 0
        helper(candidates, index+1, target, new ArrayList<>(path));
        // choose or 1
        path.add(candidates[index]);
        helper(candidates, index, target - candidates[index], new ArrayList<>(path));
    }
}

// Approach - 2 Backtracking executed
class Solution {
    // backtrack approach
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        
        if (candidates == null || candidates.length == 0)
            return result;
        
        helper(candidates, 0, target, new ArrayList<>());
        return result;
    }
    
    private void helper(int[] candidates, int index, int target, List<Integer> path) {
        // base
        if (target < 0 || index == candidates.length)
            return;
        if (target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }
        // logic
        // donot choose or 0
        helper(candidates, index+1, target, path);
        // choose or 1
        // action
        path.add(candidates[index]);
        // recurse
        helper(candidates, index, target - candidates[index], path);
        // backtrack
        path.remove(path.size()-1);
    }
}

// Approach - 3 recursion with for loop
// Executed
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        
        if (candidates == null || candidates.length == 0)
            return result;
        
        helper(candidates, 0, target, new ArrayList<>());
        return result;
    }
    
    private void helper(int[] candidates, int index, int target, List<Integer> path) {
        // base
        if (target < 0)
            return;
        if (target == 0) {
            result.add(path);
            return;
        }
        // logic
        // Recursion with for-loop
        for (int i = index; i < candidates.length; i++) {
            List<Integer> newList = new ArrayList<>(path);
            newList.add(candidates[i]);
            helper(candidates, i, target - candidates[i], newList);
        }
    }
}

// Approach - 4 
// for-loop based recursion with backtracking
// Executed
class Solution {
    // for-loop based recursion with backtracking
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        
        if (candidates == null || candidates.length == 0)
            return result;
        
        helper(candidates, 0, target, new ArrayList<>());
        return result;
    }
    
    private void helper(int[] candidates, int index, int target, List<Integer> path) {
        // base
        if (target < 0)
            return;
        if (target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }
        // logic
        // Recursion with for-loop
        for (int i = index; i < candidates.length; i++) {
            // action
            path.add(candidates[i]);
            // recurse
            helper(candidates, i, target - candidates[i], path);
            // backtrack
            path.remove(path.size()-1);
        }
    }
}

// Time complexity for above all approaches is exponential