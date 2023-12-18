// Time Complexity: O(2 ^ (m+n)) where m is the number of elements in the array and n the target
// Space Complextiy: O(m+n)
// for loop based Backtracking approach
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();

        helper(candidates, target, 0, new ArrayList<>());
        return result;
    }

    private void helper(int candidates[], int target, int pivot, List<Integer> path){
        // base
        if(target < 0) return;

        if(target == 0){
            result.add(new ArrayList<>(path));
        }

        // logic
        for(int i=pivot; i<candidates.length; i++){
            // action
            path.add(candidates[i]);

            // recurse
            helper(candidates, target - candidates[i], i, path);

            // backtrack
            path.remove(path.size() -1);
        }


    }
}


// 0-1 Backtracking approach
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        helper(candidates, 0, target, new ArrayList<>());
        return result;
    }

    private void helper(int candidates[], int i, int target, List<Integer> path){
        if(target < 0 || i == candidates.length)
            return;
        if(target == 0){
            result.add(new ArrayList<>(path));
            return;
        }

        // don't choose
        helper(candidates, i+1, target, path);

        // Action
        path.add(candidates[i]);

        // choose
        // Recursion
        helper(candidates, i, target-candidates[i],  path);

        // Remove - Backtrack
        path.remove(path.size()-1);
    }
}