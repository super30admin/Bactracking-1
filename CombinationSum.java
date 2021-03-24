class CombinationSum {
    
    // Time Complexity: O(N ^ (target/minimum element)+1) -- O(N ^ N) -- number of nodes in an N-array tree
    // Space Complexity: O(target/minimum element)
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        // Edge Case Checking
        if(candidates == null || candidates.length == 0)
            return result;
        // Recursion Call
        backtracking(candidates, target, result, new ArrayList(), 0);
        return result;
    }
    
    private void backtracking(int[] candidates, int target, List<List<Integer>> result, List<Integer> current, int index){
        // If target < 0 -> don't explore the path ahead
        if(target < 0)
            return;
        // If target = 0 -> enter the current list to the output list
        else if(target == 0){           
            result.add(new ArrayList(current));
            return;
        }
        
        // Loop through all the elements - sum them to reach the target - explore each path by including them and excluding them - thereby finding all unique paths.
        for(int i = index; i < candidates.length; i++){
            current.add(candidates[i]);
            backtracking(candidates, target - candidates[i], result, current, i);
            current.remove(current.size()-1);
        }
    }
}