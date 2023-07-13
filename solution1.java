class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        helper(candidates, target, 0, new ArrayList<>());
        return result;
    }
    
    private void helper(int[] candidates, int target, int idx, List<Integer> list) {
        //base case
        if( target == 0) {
            result.add(new ArrayList<>(list));
            return;
        }
        if( target < 0 || idx >= candidates.length) {
            return;
        }
        
        //logic
        for(int i = idx; i < candidates.length; i++) {
            //action
            list.add(candidates[i]);
            helper(candidates, target-candidates[i], i, list);
            list.remove(list.size()-1);
            // helper(candidates, target, i, list);
            //recurese
            
            //backtract
        }
    }
}