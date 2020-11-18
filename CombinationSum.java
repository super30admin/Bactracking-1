/**
 * TC : Exponential SC: O(m+n)
 * Approach : Explore all the possible combination until we find the target or we exceed the target, to conserve space we backtrack.
 *            at every recursive call only the refernce to the current list is being maintained,  when we get target we clone the list & add to res.
 */
class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<>();
        if(candidates.length == 0) return res;
        helper(candidates, target, 0, new ArrayList<>(), 0);
        return res;
    }
    
    private void helper(int[] candidates, int target, int sum, List<Integer> temp, int index){
        //Base
        if(index >= candidates.length || sum > target) return;
        if(sum == target){
            res.add(new ArrayList<>(temp));
            return;
        }
        //Logic   
        //choose
        //List<Integer> temp = new ArrayList<>(curr);
        //Action
        temp.add(candidates[index]);
        //recurse
        helper(candidates,target,sum+candidates[index],temp, index);
        //backtrack
        temp.remove(temp.size()-1);
        //don't choose
        helper(candidates, target, sum, temp, index+1);        
    }
}