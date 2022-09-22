// Time complexity: O(2^(m*n)). The reason is here we have 2^m*n nodes (as at every candidate we have 2 choices, so it is exponential. But it is not 2^n as there are two dependent fields, m and n, where m is the candidates and n is the target as both the things are responsible to increase time complexity. for example, if target is greater, then the number of nodes  for the tree will increase). m*n. Now since there are 2^m*n nodes, the TC is 2^(m*n)

// Space complexity: O(2^(m*n))

// backtracking is a general algorithm for finding all (or some) solutions to some computational problems. The idea is that it incrementally builds candidates to the solutions, and abandons a candidate ("backtrack") as soon as it determines that this candidate cannot lead to a final solution. Specifically, to our problem, we could incrementally build the combination, and once we find the current combination is not valid, we backtrack and try another option.

// Approach: Backtracking. This is using the for loop recursion technique and not the other technique which is the 0 1 recursion technique. We store the path, index and current amount as local variables and perform as DFS. In this approach, we do not have a not choose option.

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        if (candidates == null || target == 0) return result;
        backtrackHelper(candidates, target, 0, new ArrayList<>());
        return result;
    }
    
    private void backtrackHelper(int[] candidates, int currentAmount, int pivot, List<Integer> path) {
        // base
        if (currentAmount == 0) {
            // deep copying here otherwise the path will be [] empty after we traverse all nodes as we are backtracking and removing nodes from path after they are processed
            result.add(new ArrayList<>(path));
            return;
        }
        
        if (currentAmount < 0 || pivot == candidates.length) return;
        
        // logic
        for (int i = pivot; i < candidates.length; i++) {
            // action
            path.add(candidates[i]);
            // recurse
            backtrackHelper(candidates, currentAmount - candidates[i], i, path);
            // backtrack - undo action
            path.remove(path.size() - 1);
        }
    }
}