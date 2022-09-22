// Time complexity: O(2^(m*n)^2). 2 to the power m*n square. The reason is here we have 2^m*n nodes (as at every candidate we have 2 choices, so it is exponential. But it is not 2^n as there are two dependent fields, m and n, where m is the candidates and n is the target as both the things are responsible to increase time complexity. for example, if target is greater, then the number of nodes  for the tree will increase). m*n square because this is a brute force and we are taking a deep copy for every node. so let's say if the number of nodes was n, with the deep copy the TC would have been n^2 as deep copy take O(n). Now since there are 2^m*n nodes, the TC is 2^(m*n)^2

// Space complexity: O(2^(m*n))

// Approach: brute force. This is using the 0 1 recursion technique and not the other technique which is the for loop recursion. We store the path, index and current amount as local variables and perform as DFS. We create a deep copy of the path at every function call so that in the index we don't get all nodes in the paths. As the path will be reference and will keep update the same list. We will optimize this using backtracking where we don't need to keep a deep copy as we will remove the node from the path once the choose step is done.

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        if (candidates == null || target == 0) return result;
        helper(candidates, target, 0, new ArrayList<>());
        return result;
    }
    
    private void helper(int[] candidates, int currentAmount, int index, List<Integer> path) {
        // base
        if (currentAmount == 0) {
            result.add(path);
            return;
        }
        
        if (currentAmount < 0 || index == candidates.length) return;
        
        // logic
        // not choose
        helper(candidates, currentAmount, index + 1, new ArrayList<>(path));
        
        // choose
        path.add(candidates[index]);
        helper(candidates, currentAmount - candidates[index], index, new ArrayList<>(path));
    }
}