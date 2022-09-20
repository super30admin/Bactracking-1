// Time complexity: O(2^(m*n)). The reason is here we have 2^m*n nodes (as at every candidate we have 2 choices, so it is exponential. But it is not 2^n as there are two dependent fields, m and n, where m is the candidates and n is the target as both the things are responsible to increase time complexity. for example, if target is greater, then the number of nodes  for the tree will increase). m*n. Now since there are 2^m*n nodes, the TC is 2^(m*n)

// Space complexity: O(2^(m*n))

// Approach: Backtracking. This is using the 0 1 recursion technique and not the other technique which is the for loop recursion. We store the path, index and current amount as local variables and perform as DFS. We add the current node to the path whenever we choose the candidate and remove it once we are done and pop from the stack. We don't need to keep a deep copy as we will remove the node from the path once the choose step is done.

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
            // deep copying here otherwise the path will be [] empty after we traverse all nodes as we are backtracking and removing nodes from path after they are processed
            result.add(new ArrayList<>(path));
            return;
        }
        
        if (currentAmount < 0 || index == candidates.length) return;
        
        // logic
        // not choose
        helper(candidates, currentAmount, index + 1, path);
        
        // choose
        // action - adding candidate/node to path here and not before not choose step as we won't add it to the path as we are not choosing it
        path.add(candidates[index]);
        // recurse
        helper(candidates, currentAmount - candidates[index], index, path);
        // backtrack - revert the action
        path.remove(path.size() - 1);
        
    }
}