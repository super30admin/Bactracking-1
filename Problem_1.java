// Time Complexity : O(2^n)
// Space Complexity :O(2^n)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english
// backtrack: select case; add the value to the path, and recursively call the dfs; then backtrack (for unselected case) remove the last value from the path; and call dfs by increasing the index; if target is 0 add the path to the result by creating new arraylist<>();
// Your code here along with comments explaining your approach
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        if(candidates.length == 0 || candidates == null) return result;
        dfs(candidates, target, 0, new ArrayList<>());
        return result;
    }
    private void dfs(int[] candidates, int target, int index, List<Integer> path){
        //base
        if(target == 0){
            result.add(new ArrayList<>(path));
            return;
        }
        if(target < 0 || index == candidates.length) return;
        // logic
        // case 1: selected
        path.add(candidates[index]);
        dfs(candidates, target - candidates[index], index, path);
        path.remove(path.size()-1);
        // case 2: unselected
        dfs(candidates, target, index+1, path);
    }
}
