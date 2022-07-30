// TC : O(2^N)
// SC : O(N)

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(candidates == null || candidates.length == 0) return new ArrayList<>();
        
        result = new ArrayList<>();
        
        helper(candidates, target, 0, new ArrayList<>());
        
        return result;
        
        
    }
    
    private void helper(int[] candidates, int target, int index, List<Integer> Path){
        if(target<0 || index == candidates.length) return;
        if(target == 0) 
        {
            result.add(new ArrayList<>(Path));
            return;
        }
        // did not choose 
        helper(candidates,target, index+1,Path);
        // did choose
        Path.add(candidates[index]);
        helper(candidates,target-candidates[index],index,Path);
        // backtracking
        Path.remove(Path.size()-1);
    }
}