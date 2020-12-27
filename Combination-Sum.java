class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        if(candidates == null || candidates.length == 0)
            return result;
        helper(candidates,0,0,new ArrayList<>());
        return result;
        
        private void helper(int[] candidates, int index, int sum, List<Integer> temp){
            if(sum > target)
                return;
            
            if(sum == target){
                result.add(new ArrayList());
                return;
            }
            
            for(int i = index; i < candidates.length; i++){
                temp.add(candidates[i]);
                helper(candidates, target, i , sum+candidates[i],temp);
                temp.remove(temp.size()-1);
            }
        }
    }
}

// Time complexity : Exponential
// Space Complexity : O (m+n)
