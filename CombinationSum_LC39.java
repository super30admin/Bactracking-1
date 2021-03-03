/* for both
T: O(2^n) -> every time we have choose and don't choose path
S: O(d) -> depth of the tree
*/

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        if(candidates == null || candidates.length == 0)
            return result;
        
        helper(candidates, target, 0, new ArrayList<>());
        return result;
    }
    
    //without iteration
    private void helper(int[] candidates, int target, int i, List<Integer> path){
        //base case
        if(i == candidates.length || target < 0)
            return;
        
        //add to the path only if all elements add to target
        if(target == 0){
            result.add(new ArrayList(path));
            return;
        }
           
        //logic
        //don't choose so, path remain same
        helper(candidates, target, i + 1, path);
        
        //choose, so add to path
        path.add(candidates[i]);
        helper(candidates, target - candidates[i], i, path);
        
        //Backtrack remove last element
        path.remove(path.size() - 1);
    }

    //with iteration - for loop
    private void helperI(int[] candidates, int target, int index, List<Integer> path){
        //base
        if(target < 0) return;
        if(target == 0){
            result.add(new ArrayList<>(path));
            return;
        }
        //logic
        for(int i = index; i < candidates.length; i++){
            //action
            path.add(candidates[i]);
            //recurse
            helperI(candidates, target - candidates[i], i, path);
            //backtrack
            path.remove(path.size() - 1);
        }
    }
}