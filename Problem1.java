// Time Complexity : O(2^(m+n))
// Space Complexity : O(2^(m+n))
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
/*Run a for each recursion loop with an element as pivot. 
Run recursively with each i as pivot and create an arraylist. 
If target is less than 0, return. 
If target = 0, create a deep copy and add it to result. 
 * 
 */

class Solution{
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        backtrack(candidates, 0, target, new ArrayList<>());
        return result;
}
    private void backtrack(int[] candidates, int pivot, int target, List<Integer> path){
        if(target < 0)
            return;
        if(target == 0){
            result.add(new ArrayList<>(path));
        }

        for(int i = pivot; i < candidates.length; i++){
            path.add(candidates[i]);
            backtrack(candidates, i, target - candidates[i], path);
            path.remove(path.size() -1);
        }
    }
}