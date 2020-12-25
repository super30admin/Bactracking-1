//Time Complexity: O(N^M) or Exponential
//Space Complexity: O(H) where H is height of tree    
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No
     
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        if(candidates == null || candidates.length == 0)
            return result;
        helper(candidates, target, 0, 0, new ArrayList<>());
        return result;
    }
    private void helper(int[] candidates, int target, int index, int sum, List<Integer> temp){
        if(index >= candidates.length || sum > target)
            return;
        if(sum == target){
            result.add(new ArrayList<>(temp));
            return;
        }
        
        helper(candidates, target, index + 1, sum, temp);
        temp.add(candidates[index]);
        helper(candidates, target, index, sum + candidates[index], temp);
        temp.remove(temp.size() - 1);
    }
}