https://leetcode.com/submissions/detail/620343796/
//Time: Exponential O(l^k), l is length of array, k is longest possible combination
//Space: O(k), for storing path, which is k long at most.
class Solution {
    
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        result = new ArrayList<>();
        helper(new ArrayList<>(), candidates, target, 0);
        return result;
    }
    
    private void helper(List<Integer> currList, int[] candidates, int target, int i){
        
        if(i == candidates.length) {
            return;
        }
        
        if(target < 0) {
            return;
        }
        
        if(target == 0) {
            result.add(new ArrayList<>(currList));
            return;
        }
        
        helper(currList, candidates, target, i+1);
        currList.add(candidates[i]);
        helper(currList, candidates, target - candidates[i], i);
        
        currList.remove(currList.size() - 1);
    }
}